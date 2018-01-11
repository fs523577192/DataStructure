package org.firas.collection.list

import org.firas.collection.Iterator

/**
 *
 */
class BidirectionalLinkedList<E> private constructor(head: BidirectionalLinkedListNode<E>? = null) :
        AbstractBidirectionalLinkedList<E>(head), Stack<E> {

    override fun size(): Int {
        return size(head)
    }

    override fun push(element: E) {
        modifyCount += 1
        head = BidirectionalLinkedListNode(head, null, element)
        if (null != head?.next) {
            head?.next?.prev = head
        }
    }

    override fun insert(index: Int, element: E) {
        ensureNonNegativeIndex(index)
        if (0 == index) {
            append(element)
            return
        }
        val node = getNodeByIndex(head, index - 1)
        modifyCount += 1
        val newNode = BidirectionalLinkedListNode(node.next, node, element)
        node.next = newNode
        if (null != newNode.next) {
            newNode.next?.prev = newNode
        }
    }

    override fun append(element: E) {
    }

    override fun remove(index: Int): E {
        ensureNonNegativeIndex(index)
        if (0 == index) {
            return pop()
        }
        val node = getNodeByIndex(head, index)
        modifyCount += 1
        val result = checkNotNull(node?.element)
        node.afterInsert()
        return result
    }

    override fun pop(): E {
        ensureNotEmpty(head)
        modifyCount += 1
        val result = checkNotNull(head?.element)
        head = head?.next
        if (null != head) {
            head?.prev = null
        }
        return result
    }

    override fun iterator(): Iterator<E> {
        return LinkedListIterator()
    }

    private inner open class LinkedListIterator(
            var currentNode: BidirectionalLinkedListNode<E>? = head):
            AbstractListIterator() {

        override fun hasNext(): Boolean {
            checkForComodification()
            return null != currentNode
        }

        override fun next(): E {
            checkForComodification()
            val result = checkNotNull(currentNode?.element)
            currentNode = currentNode?.next
            return result
        }
    }
}