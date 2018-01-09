package org.firas.collection.list

/**
 *
 */
abstract class AbstractList<E> : MutableList<E> {

    protected fun ensureNonNegativeIndex(index: Int) {
        if (index < 0) {
            throw kotlin.IllegalArgumentException()
        }
    }
}