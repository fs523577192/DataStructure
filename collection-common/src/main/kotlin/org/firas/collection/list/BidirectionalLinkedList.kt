package org.firas.collection.list

/**
 *
 */
class BidirectionalLinkedList<E> private constructor(head: BidirectionalLinkedListNode<E>? = null) :
        AbstractBidirectionalLinkedList<E>(head) {

    override fun size(): Int {
        return size(head)
    }
}