package org.firas.collection.list

import org.firas.collection.Iterator

/**
 *
 */
class CircularLinkedList<E> private constructor(head: LinkedListNode<E>? = null) :
        AbstractLinkedList<E>(head) {

    override fun size(): Int {
        return sizeForCircular(head)
    }

    override fun append(element: E) {
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
            node?.next = head
        }
    }

    override fun insert(index: Int, element: E) {
        ensureNonNegativeIndex(index)
        if (0 == index) {
            append(element)
            return
        }
        modifyCount += 1
        val node = getNodeByIndexForCircular(head, index - 1)
        node.next = LinkedListNode(node.next, element)
    }

    override fun append(element: E) {
    }

    override fun remove(index: Int): E {
        ensureNonNegativeIndex(index)
        if (0 == index) {
            return removeHead()
        }
    }

    private fun removeHead(): E {
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