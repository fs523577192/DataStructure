package org.firas.collection

/**
 *
 */
interface Iterable<out E: Any?> {

    fun iterator(): org.firas.collection.Iterator<E>
}