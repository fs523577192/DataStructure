package org.firas.datatype.queue

abstract class AbstractFixedLengthQueueWithIndex<E>
        protected constructor(length: Int, protected var exitIndex = 0) :
        FixedLengthQueue<E>(length) {

    protected var entryIndex = 0
}
