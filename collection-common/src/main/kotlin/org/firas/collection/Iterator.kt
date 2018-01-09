package org.firas.collection

/**
 *
 */
interface Iterator<E> {

    fun hasNext(): Boolean

    fun next(): E
}