package org.firas.collection.stack

/**
 *
 */
interface Stack<E> : ProducerInStack<E>, ConsumerInStack<E> {

    fun size(): Int
}
