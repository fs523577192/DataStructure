package org.firas.collection.stack

/**
 *
 */
interface ConsumerInStack<out E> {

    fun pop(): E
}
