package org.firas.collection.stack

/**
 *
 */
class FixedLengthStack<E>(length: Int) : Stack<E> {

    private val array = arrayOfNulls<Any>(length)
    private var size = 0

    override fun size(): Int {
        return size
    }

    override fun push(element: E) {
        if (size >= array.size) {
            throw Exception("Full")
        }
        array[size] = element
        size += 1
    }

    override fun pop(): E {
        if (size <= 0) {
            throw Exception("Empty")
        }
        size -= 1
        return (array[size] as E)
    }
}
