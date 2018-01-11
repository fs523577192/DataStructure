package org.firas.collection.queue

abstract class FixedLengthQueue<E>(length: Int) : Queue<E> {

    protected val array = arrayOfNulls<Any>(length)

    protected fun elementData(index: Int): E {
        return (array[index] as E)
    }
}
