package org.firas.collection

/**
 *
 */
interface Iterable<out E> {

    fun iterator(): org.firas.collection.Iterator<E>
}