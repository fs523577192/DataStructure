package org.firas.collection.list

import org.firas.collection.Iterator

/**
 *
 */
class CircularBidirectionalLinkedList<E: Any?> private constructor(head: BidirectionalLinkedListNode<E>? = null) :
        AbstractBidirectionalLinkedList<E>(head) {

    override fun size(): Int {
        return sizeForCircular(head)
    }

    override fun push(element: E) {
        modifyCount += 1
        val original = head
        if (null == original) {
            head = BidirectionalLinkedListNode(null, null, element)
            head?.next = head
            head?.prev = head
        } else {
            head = BidirectionalLinkedListNode(
                    original, original.prev, element).afterInsert()
        }
    }

    override fun insert(index: Int, element: E) {
        ensureNonNegativeIndex(index)
        if (0 == index) {
            push(element)
            return
        }
        modifyCount += 1
        val node = getNodeByIndexForCircular(head, index - 1)
        val newNode = BidirectionalLinkedListNode(node, node.prev, element)
        newNode.next?.prev = newNode
        newNode.prev?.next = newNode
    }

    override fun append(element: E) {
        modifyCount += 1
        if (null == head) {
            head = BidirectionalLinkedListNode(null, null, element)
            head?.next = head
            head?.prev = head
            return
        }
        val newNode = BidirectionalLinkedListNode(head, head?.prev, element)
        head?.prev = newNode
        newNode.prev?.next = newNode
    }

    override fun remove(index: Int): E {
        ensureNonNegativeIndex(index)
        if (0 == index) {
            return pop()
        }
        val node = getNodeByIndexForCircular(head, index)
        modifyCount += 1
        node.prev?.next = node.next
        node.next?.prev = node.prev
        return node.element
    }

    override fun pop(): E {
        ensureNotEmpty(head)
        modifyCount += 1
        val result = (head?.element as E)
        if (head == head?.next) {
            head = null
            return result
        }
        var node = head
        while (head != node?.next) {
            node = node?.next
        }
        // The next node of the last node becomes the new head
        node?.next = head?.next
        head = head?.next
        head?.prev = node
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
            val result = (currentNode?.element as E)
            currentNode = currentNode?.next
            return result
        }
    }
}