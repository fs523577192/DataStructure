package org.firas.collection.stack

/**
 *
 */
interface ConsumerInStack<out E: Any?> {

    fun pop(): E
}
