package org.firas.collection.list

/**
 *
 */
class CircularLinkedList<E> private constructor(head: LinkedListNode<E>? = null) :
        AbstractLinkedList<E>(head) {

    override fun size(): Int {
        return sizeForCircular(head)
    }

}