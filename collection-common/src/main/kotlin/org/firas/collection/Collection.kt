package org.firas.collection

/**
 *
 */
interface Collection<out E> : org.firas.collection.Iterable<E> {

    fun size(): Int

    fun isEmpty(): Boolean

    fun contains(element: E): Boolean
}
