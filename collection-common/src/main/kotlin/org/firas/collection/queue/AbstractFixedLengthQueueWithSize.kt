package org.firas.collection.queue

abstract class AbstractFixedLengthQueueWithSize<E>(length: Int) : FixedLengthQueue<E>(length) {

    protected var size = 0

    override fun size(): Int {
        return size
    }

    protected fun checkFull() {
        if (size >= array.size) {
            throw Exception("Full")
        }
    }

    protected fun checkEmpty() {
        if (size <= 0) {
            throw Exception("Empty")
        }
    }
}
