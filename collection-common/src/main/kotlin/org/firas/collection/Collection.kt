package org.firas.collection

/**
 *
 */
interface Collection<out E: Any?> : org.firas.collection.Iterable<E> {

    fun size(): Int

    fun isEmpty(): Boolean
}