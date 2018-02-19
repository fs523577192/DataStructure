package org.firas.collection.list

import kotlin.collections.Iterator

/**
 *
 */
class CircularLinkedList<E> private constructor(
        head: LinkedListNode<E>?): AbstractLinkedList<E>(head) {

    constructor(): this(null)

    override fun size(): Int {
        return sizeForCircular(head)
    }

    override fun contains(element: E): Boolean {
        return containsForCircular(head, element)
    }

    override fun indexOf(element: E): Int {
        return indexOfForCircular(head, element)
    }

    override fun lastIndexOf(element: E): Int {
        return lastIndexOfForCircular(head, element)
    }

    override fun get(index: Int): E {
        return getNodeByIndexForCircular(head, index).getElement()
    }

    override fun set(index: Int, element: E) {
        modifyCount += 1
        getNodeByIndexForCircular(head, index).setElement(element)
    }

    override fun push(element: E) {
        modifyCount += 1
        val original = head
        head = LinkedListNode(original, element)
        if (null == original) {
            head?.next = head
        } else {
            var node = original
            while (original != node?.next) {
                node = node?.next
            }
            node.next = head
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
        node.next = LinkedListNode(node.next, element)
    }

    override fun append(element: E) {
        modifyCount += 1
        if (null == head) {
            head = LinkedListNode(null, element)
            head?.next = head
            return
        }
        val newNode = LinkedListNode(head, element)
        var node = head
        while (head != node?.next) {
            node = node?.next
        }
        node?.next = newNode
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
        val prev = getNodeByIndexForCircular(head, index - 1)
        val node = prev.next
        if (head == node) {
            throw IndexOutOfBoundsException()
        }
        modifyCount += 1
        prev.next = node?.next
        return (node?.getElement() as E)
    }

    override fun pop(): E {
        ensureNotEmpty(head)
        modifyCount += 1
        val result = (head?.getElement() as E)
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
        return result
    }

    override fun iterator(): Iterator<E> {
        return LinkedListIterator()
    }

    private open inner class LinkedListIterator(
            var currentNode: LinkedListNode<E>? = head): AbstractListIterator() {

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
