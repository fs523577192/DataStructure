package org.firas.datatype.queue

abstract class FixedLengthQueue<E>(length: Int) : Queue<E> {

    protected val array = arrayOfNulls<E>(length)
}
