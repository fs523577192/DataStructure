package org.firas.collection

/**
 *
 */
interface Iterator<out E: Any?> {

    fun hasNext(): Boolean

    fun next(): E
}