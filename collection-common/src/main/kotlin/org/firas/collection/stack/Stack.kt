package org.firas.collection.stack

/**
 *
 */
interface Stack<E: Any?> : ProducerInStack<E>, ConsumerInStack<E> {

    fun size(): Int
}
