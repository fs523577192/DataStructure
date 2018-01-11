package org.firas.collection.list

import org.firas.collection.Iterator

/**
 *
 */
class LinkedList<E> private constructor(head: LinkedListNode<E>? = null) :
        AbstractLinkedList<E>(head) {

    override fun size(): Int {
        return size(head)
    }

    override fun push(element: E) {
        modifyCount += 1
        head = LinkedListNode(head, element)
    }

    override fun insert(index: Int, element: E) {
        ensureNonNegativeIndex(index)
        if (0 == index) {
            push(element)
            return
        }
        modifyCount += 1
        val node = getNodeByIndex(head, index - 1)
        node.next = LinkedListNode(node.next, element)
    }

    override fun append(element: E) {
    }

    override fun remove(index: Int): E {
        ensureNonNegativeIndex(index)
        if (0 == index) {
            return pop()
        }
        val prev = getNodeByIndex(head, index - 1)
        val node = prev.next ?: throw IndexOutOfBoundsException()
        modifyCount += 1
        prev.next = node.next
        return node.element
    }

    override fun pop(): E {
        ensureNotEmpty(head)
        modifyCount += 1
        val result = checkNotNull(head?.element)
        head = head?.next
        return result
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