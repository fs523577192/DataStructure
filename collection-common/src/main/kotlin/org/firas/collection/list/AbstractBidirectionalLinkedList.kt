package org.firas.collection.list

/**
 *
 */
abstract class AbstractBidirectionalLinkedList<E>
        protected constructor(protected var head: BidirectionalLinkedListNode<E>? = null) :
        LinkedListBase<E>() {

    override fun isEmpty(): Boolean {
        return null == head
    }

    override fun get(index: Int): E {
        return getNodeByIndex(head, index).getElement()
    }

    override fun set(index: Int, element: E) {
        modifyCount += 1
        getNodeByIndex(head, index).setElement(element)
    }
}
