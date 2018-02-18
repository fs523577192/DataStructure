package org.firas.collection.range

/**
 *
 */
abstract class RangeIterator<E: Comparable<E>> protected constructor(
        protected var currentValue: E, private val endValue: E):
        kotlin.collections.Iterator<E> {

    protected abstract fun increment()

    override fun hasNext(): Boolean {
        return currentValue.compareTo(endValue) <= 0
    }

    override fun next(): E {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        val result = currentValue
        increment()
        return result
    }
}
