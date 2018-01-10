package org.firas.datatype.stack

/**
 *
 */
class FixedLengthStack<E>(length: Int) : Stack<E> {

    private val array = arrayOfNulls<E>(length)
    private var size = 0

    fun size(): Int {
        return size
    }

    fun push(element: E) {
        if (size >= array.size) {
            throw Exception()
        }
        array[size] = element
        size += 1
    }

    fun pop(): E {
        if (size <= 0) {
            throw Exception()
        }
        size -= 1
        return checkNotNull(array[size])
    }
}
