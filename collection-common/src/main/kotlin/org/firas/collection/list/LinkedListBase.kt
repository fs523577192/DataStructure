package org.firas.collection.list

import org.firas.collection.stack.Stack

/**
 *
 */
abstract class LinkedListBase<E> : AbstractList<E>(), Stack<E> {

    protected abstract class LinkedListNodeBase<E, T: LinkedListNodeBase<E, T>>(
            var next: T?) {
        abstract fun getElement(): E
    }

    protected class LinkedListNode<E>(next: LinkedListNode<E>?, var element: E) :
            LinkedListNodeBase<E, LinkedListNode<E>>(next) {

        override fun getElement(): E {
            return element
        }
    }

    protected class BidirectionalLinkedListNode<E>(
            next: BidirectionalLinkedListNode<E>?,
            var prev: BidirectionalLinkedListNode<E>?,
            var element: E) :
            LinkedListNodeBase<E, BidirectionalLinkedListNode<E>>(next) {

        override fun getElement(): E {
            return element
        }

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
            head: LinkedListNodeBase<E, T>?, element: E): Boolean {
        var node = head
        while (true) {
            val temp = node ?: break
            if (null == element && null == temp.getElement() ||
                    null != element && element == temp.getElement()) {
                return true
            }
            node = temp.next
        }
        return false
    }

    protected fun <T: LinkedListNodeBase<E, T>> size(head: LinkedListNodeBase<E, T>?): Int {
        var result = 0
        var node = head
        while (true) {
            val temp = node ?: break
            result += 1
            node = temp.next
        }
        return result
    }

    protected fun <T: LinkedListNodeBase<E, T>> indexOf(
            head: LinkedListNodeBase<E, T>?, element: E): Int {
        var result = 0
        var node = head
        while (true) {
            val temp = node ?: break
            if (null == element && null == temp.getElement() ||
                    null != element && element == temp.getElement()) {
                return result
            }
            result += 1
            node = temp.next
        }
        return -1
    }

    protected fun <T: LinkedListNodeBase<E, T>> lastIndexOf(
            head: LinkedListNodeBase<E, T>?, element: E): Int {
        var result = -1
        var index = 0
        var node = head
        while (true) {
            val temp = node ?: break
            if (null == element && null == temp.getElement() ||
                    null != element && element == temp.getElement()) {
                result = index
            }
            index += 1
            node = temp.next
        }
        return result
    }

    protected fun <T: LinkedListNodeBase<E, T>> containsForCircular(
            head: LinkedListNodeBase<E, T>?, element: E): Boolean {
        if (null == head) {
            return false
        }
        if (null == element && null == head.getElement() ||
                null != element && element == head.getElement()) {
            return true
        }
        var node = head.next
        while (head != node) {
            if (null == element && null == node?.getElement() ||
                    null != element && element == node?.getElement()) {
                return true
            }
            node = node?.next
        }
        return false
    }

    protected fun <T: LinkedListNodeBase<E, T>> sizeForCircular(
            head: LinkedListNodeBase<E, T>?): Int {
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

    protected fun <T: LinkedListNodeBase<E, T>> indexOfForCircular(
            head: LinkedListNodeBase<E, T>?, element: E): Int {
        if (null == head) {
            return -1
        }
        if (null == element && null == head.getElement() ||
                null != element && element == head.getElement()) {
            return 0
        }
        var result = 1
        var node = head.next
        while (head != node) {
            if (null == element && null == node?.getElement() ||
                    null != element && element == node?.getElement()) {
                return result
            }
            result += 1
            node = node?.next
        }
        return -1
    }

    protected fun <T: LinkedListNodeBase<E, T>> lastIndexOfForCircular(
            head: LinkedListNodeBase<E, T>?, element: E): Int {
        if (null == head) {
            return -1
        }

        var result = -1
        if (null == element && null == head.getElement() ||
                null != element && element == head.getElement()) {
            result = 0
        }

        var index = 1
        var node = head.next
        while (head != node) {
            if (null == element && null == node?.getElement() ||
                    null != element && element == node?.getElement()) {
                result = index
            }
            index += 1
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
