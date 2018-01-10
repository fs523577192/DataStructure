package org.firas.datatype.queue

abstract class FixedLengthQueueWithSize<E>(length: Int) : FixedLengthQueue<E>(length) {

    protected var size = 0

    fun size(): Int {
        return size
    }
}
