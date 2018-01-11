package org.firas.collection.list

/**
 *
 */
abstract class AbstractLinkedList<E>
        protected constructor(protected var head: LinkedListNode<E>? = null) :
        LinkedListBase<E>() {

    override fun isEmpty(): Boolean {
        return null == head
    }

    override fun get(index: Int): E {
        return getNodeByIndex(head, index).element
    }

    override fun set(index: Int, element: E) {
        modifyCount += 1
        getNodeByIndex(head, index).element = element
    }
}
