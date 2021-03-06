package org.firas.collection.list

import kotlin.collections.Iterator

/**
 *
 */
class BidirectionalLinkedList<E> private constructor(
        head: BidirectionalLinkedListNode<E>?) :
        AbstractBidirectionalLinkedList<E>(head) {

    constructor(): this(null)

    override fun size(): Int {
        return size(head)
    }

    override fun contains(element: E): Boolean {
        return contains(head, element)
    }

    override fun indexOf(element: E): Int {
        return indexOf(head, element)
    }

    override fun lastIndexOf(element: E): Int {
        return lastIndexOf(head, element)
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
            push(element)
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
        modifyCount += 1
        if (null == head) {
            head = BidirectionalLinkedListNode(null, null, element)
            return
        }
        var node = head
        while (null != node?.next) {
            node = node.next
        }
        val newNode = BidirectionalLinkedListNode(node?.next, node, element)
        node?.next = newNode
        newNode.prev = node
    }

    override fun remove(index: Int): E {
        ensureNonNegativeIndex(index)
        if (0 == index) {
            try {
                return pop()
            } catch (ex: NoSuchElementException) {
                throw IndexOutOfBoundsException()
            }
        }
        val node = getNodeByIndex(head, index)
        modifyCount += 1
        val result = node.getElement()
        if (null != node.prev) {
            node.prev?.next = node.next
        }
        if (null != node.next) {
            node.next?.prev = node.prev
        }
        return result
    }

    override fun pop(): E {
        ensureNotEmpty(head)
        modifyCount += 1
        val result = (head?.getElement() as E)
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
            val result = (currentNode?.getElement() as E)
            currentNode = currentNode?.next
            return result
        }
    }
}
