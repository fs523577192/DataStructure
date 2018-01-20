package org.firas.collection

/**
 *
 */
interface Iterator<out E> {

    fun hasNext(): Boolean

    fun next(): E
}
