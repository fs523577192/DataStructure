package org.firas.collection.list

import kotlin.collections.Iterator

/**
 * Uni-directional Non-circular Linked List
 *
 * Extra space: n + 1
 * n "next" pointer + 1 "head" pointer
 */
class LinkedList<E> private constructor(
        head: LinkedListNode<E>?) :
        AbstractLinkedList<E>(head) {

    constructor(): this(null)

    override fun size(): Int {
        return size(head)
    }

    override fun contains(element: E): Boolean {
        return contains(head, element)
    }

    /**
     * Push an element into the stack
     * Insert the element before the original head
     * Worst Time: O(1)
     * Extra space: 0
     */
    override fun push(element: E) {
        modifyCount += 1
        head = LinkedListNode(head, element)
    }

    /**
     * Insert an element into the list
     * Time: O(n)
     */
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

    /**
     * Append an element to the end of the list
     * Time: O(n)
     */
    override fun append(element: E) {
        modifyCount += 1
        if (null == head) {
            head = LinkedListNode(null, element)
            return
        }
        var node = head
        while (null != node?.next) {
            node = node.next
        }
        node?.next = LinkedListNode(null, element)
    }

    /**
     * Remove the element at the specified index in the list
     * @return the removed element
     * Time: O(n)
     */
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

    /**
     * Pop an element from the stack
     * Worst Time: O(1)
     * Extra Space: 1 (to store the element removed)
     */
    override fun pop(): E {
        ensureNotEmpty(head)
        modifyCount += 1
        val result = (head?.element as E)
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
            val result = (currentNode?.element as E)
            currentNode = currentNode?.next
            return result
        }
    }
}
