package org.firas.collection.list

import org.firas.collection.Iterator

/**
 *
 */
class CircularBidirectionalLinkedList<E> private constructor(head: BidirectionalLinkedListNode<E>? = null) :
        AbstractBidirectionalLinkedList<E>(head) {

    override fun size(): Int {
        return sizeForCircular(head)
    }

    override fun push(element: E) {
        modifyCount += 1
        val original = head
        if (null == original) {
            head = BidirectionalLinkedListNode(original, null, element)
            head?.next = head
            head?.prev = head
        } else {
            head = BidirectionalLinkedListNode(original, original.prev, element)
            head.prev
        }
    }
    override fun insert(index: Int, element: E) {
        ensureNonNegativeIndex(index)
        if (0 == index) {
            push(element)
            return
        }
        modifyCount += 1
    }

    override fun append(element: E) {
    }

    override fun remove(index: Int): E {
    }

    override fun pop(): E {
        ensureNotEmpty(head)
    }

    override fun iterator(): Iterator<E> {
        return LinkedListIterator()
    }

    private inner open class LinkedListIterator(
            var currentNode: LinkedListNode<E>? = head): AbstractListIterator() {

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