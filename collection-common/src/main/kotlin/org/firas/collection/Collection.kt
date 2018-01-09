package org.firas.collection

/**
 *
 */
interface Collection<E> : org.firas.collection.Iterable<E> {

    fun size(): Int

    fun isEmpty(): Boolean
}