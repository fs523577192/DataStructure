package org.firas.collection

/**
 *
 */
interface Iterable<E> {

    fun iterator(): org.firas.collection.Iterator<E>
}