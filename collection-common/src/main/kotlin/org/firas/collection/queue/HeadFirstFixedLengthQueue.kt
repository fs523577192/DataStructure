package org.firas.collection.queue

/**
 *
 */
class HeadFirstFixedLengthQueue<E>(length: Int) : AbstractFixedLengthQueueWithSize<E>(length) {

    override fun produce(element: E) {
        checkFull()
        var i = size
        var j = size - 1
        while (j >= 0) {
            array[i] = array[j]
            i = j
            j -= 1
        }
        array[0] = element
        size += 1
    }

    override fun consume(): E {
        checkEmpty()
        size -= 1
        return elementData(size)
    }
}