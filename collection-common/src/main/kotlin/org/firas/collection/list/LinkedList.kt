package org.firas.collection.list

/**
 *
 */
class LinkedList<E> private constructor(head: LinkedListNode<E>? = null) :
        AbstractLinkedList<E>(head) {

    override fun size(): Int {
        return size(head)
    }
}