package org.firas.collection.list

import org.firas.collection.stack.Stack

/**
 *
 */
abstract class LinkedListBase<E: Any?> : AbstractList<E>(), Stack<E> {

    protected abstract class LinkedListNodeBase<E, T: LinkedListNodeBase<E, T>>(var next: T?)

    protected class LinkedListNode<E>(next: LinkedListNode<E>?, var element: E) :
            LinkedListNodeBase<E, LinkedListNode<E>>(next)

    protected class BidirectionalLinkedListNode<E>(
            next: BidirectionalLinkedListNode<E>?,
            var prev: BidirectionalLinkedListNode<E>?,
            var element: E) :
            LinkedListNodeBase<E, BidirectionalLinkedListNode<E>>(next) {

        fun afterInsert(): BidirectionalLinkedListNode<E> {
            if (null != next) {
                next?.prev = this
            }
            if (null != prev) {
                prev?.next = this
            }
            return this
        }
    }

    protected fun <T: LinkedListNodeBase<E, T>> contains(
            head: LinkedListNodeBase<E, T>?, element: E): Int {
        var node = head
        while (null != node) {
            if (null == element && null == node.element ||
                    null != element && element.equals(node.element)) {
                return true
            }
        }
        return false
    }

    protected fun <T: LinkedListNodeBase<E, T>> size(head: LinkedListNodeBase<E, T>?): Int {
        var result = 0
        var node = head
        while (null != node) {
            result += 1
            node = node.next
        }
        return result
    }

    protected fun <T: LinkedListNodeBase<E, T>> containsForCircular(
            head: LinkedListNodeBase<E, T>?, element: E): Int {
        if (null == head) {
            return false
        }
        if (null == element && null == head.element ||
                null != element && element.equals(head.element)) {
            return true
        }
        var node = head.next
        while (head != node) {
            if (null == element && null == node.element ||
                    null != element && element.equals(node.element)) {
                return true
            }
        }
        return false
    }

    protected fun <T: LinkedListNodeBase<E, T>> sizeForCircular(head: LinkedListNodeBase<E, T>?): Int {
        if (null == head) {
            return 0
        }
        var result = 1
        var node = head.next
        while (head != node) {
            result += 1
            node = node?.next
        }
        return result
    }

    protected fun <T: LinkedListNodeBase<E, T>> getNodeByIndex(
            head: T?, index: Int): T {
        ensureNonNegativeIndex(index)
        if (isEmpty()) {
            throw IndexOutOfBoundsException()
        }
        var i = index
        var node = head
        while (i > 0 && null != node) {
            i -= 1
            node = node.next
        }
        if (null == node) {
            throw IndexOutOfBoundsException()
        }
        return node
    }

    protected fun <T: LinkedListNodeBase<E, T>> getNodeByIndexForCircular(
            head: T?, index: Int): T {
        ensureNonNegativeIndex(index)
        if (isEmpty()) {
            throw IndexOutOfBoundsException()
        }
        if (0 == index) {
            return checkNotNull(head)
        }
        var i = index
        var node = head?.next
        while (i > 1 && head != node) {
            i -= 1
            node = node?.next
        }
        if (head == node) {
            throw IndexOutOfBoundsException()
        }
        return checkNotNull(node)
    }

    protected fun <T: LinkedListNodeBase<E, T>> ensureNotEmpty(
            head: T?) {
        if (null == head) {
            throw NoSuchElementException("Empty List")
        }
    }
}
