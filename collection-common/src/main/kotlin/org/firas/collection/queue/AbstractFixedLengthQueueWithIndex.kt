package org.firas.collection.queue

abstract class AbstractFixedLengthQueueWithIndex<E>
        protected constructor(length: Int, protected var exitIndex: Int = 0) :
        FixedLengthQueue<E>(length) {

    protected var entryIndex = 0
}
