package org.firas.collection.list

import kotlin.collections.Iterator

/**
 *
 */
class CircularBidirectionalLinkedList<E> private constructor(
        head: BidirectionalLinkedListNode<E>?) :
        AbstractBidirectionalLinkedList<E>(head),
        org.firas.collection.queue.Queue<E> {

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
        if (null == original) {
            head = BidirectionalLinkedListNode(null, null, element)
            head?.next = head
            head?.prev = head
        } else {
            head = BidirectionalLinkedListNode(
                    original, original.prev, element).afterInsert()
        }
    }

    override fun produce(element: E) {
        modifyCount += 1
        val temp = head
        if (null == temp) {
            val newHead = BidirectionalLinkedListNode(null, null, element)
            newHead.next = temp
            newHead.prev = temp
            head = newHead
        } else {
            temp.prev = BidirectionalLinkedListNode(
                    temp, temp.prev, element).afterInsert()
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
            try {
                return pop()
            } catch (ex: NoSuchElementException) {
                throw IndexOutOfBoundsException()
            }
        }
        val node = getNodeByIndexForCircular(head, index)
        modifyCount += 1
        node.prev?.next = node.next
        node.next?.prev = node.prev
        return node.getElement()
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
        head?.prev = node
        return result
    }

    override fun consume(): E {
        return pop()
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
