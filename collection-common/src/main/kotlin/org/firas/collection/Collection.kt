package org.firas.collection

/**
 *
 */
interface Collection<E>: Iterable<E> {

    fun size(): Int

    fun isEmpty(): Boolean

    fun contains(element: E): Boolean
}
