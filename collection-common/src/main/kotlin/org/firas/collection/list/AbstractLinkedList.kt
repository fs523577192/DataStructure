package org.firas.collection.list

/**
 *
 */
abstract class AbstractLinkedList<E>
        protected constructor(protected var head: LinkedListNode<E>? = null) :
        AbstractList<E>() {

    protected class LinkedListNode<E>(var next: LinkedListNode<E>?, var element: E?)
}