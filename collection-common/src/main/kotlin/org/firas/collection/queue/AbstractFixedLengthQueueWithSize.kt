package org.firas.collection.queue

abstract class AbstractFixedLengthQueueWithSize<E>(length: Int):
        FixedLengthQueue<E>(length) {

    protected var _size = 0

    override fun size(): Int {
        return _size
    }

    protected fun checkFull() {
        if (_size >= array.size) {
            throw Exception("Full")
        }
    }

    protected fun checkEmpty() {
        if (_size <= 0) {
            throw NoSuchElementException("Empty Queue")
        }
    }
}
