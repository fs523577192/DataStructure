package org.firas.collection.list

/**
 *
 */
class CircularBidirectionalLinkedList<E> private constructor(head: BidirectionalLinkedListNode<E>? = null) :
        AbstractBidirectionalLinkedList<E>(head) {

    override fun size(): Int {
        return sizeForCircular(head)
    }

}