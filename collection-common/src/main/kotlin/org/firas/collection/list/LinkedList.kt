package org.firas.collection.list

/**
 *
 */
class LinkedList<E> private constructor(head: LinkedListNode<E>? = null) :
        AbstractLinkedList<E>(head) {

    override fun isEmpty(): Boolean {
        return null == head
    }

    override fun size(): Int {
        val head = this.head
        if (null == head) {
            return 0
        }
        var size = 1
        var node = head.next
        while (null != node) {
            size += 1
        }
        return size
    }

    override fun get(index: Int): E? {
        val head = this.head
        ensureNonNegativeIndex(index);
        if (null == head) {
            throw kotlin.IndexOutOfBoundsException()
        }
        var temp = index
        while (temp > 0) {

        }
    }
}