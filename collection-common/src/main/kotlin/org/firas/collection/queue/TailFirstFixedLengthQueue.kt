package org.firas.collection.queue

/**
 *
 */
class TailFirstFixedLengthQueue<E>(length: Int) : AbstractFixedLengthQueueWithSize<E>(length) {

    override fun produce(element: E) {
        checkFull()
        array[size] = element
        size += 1
    }

    override fun consume(): E {
        checkEmpty()
        val result = elementData(0)
        size -= 1
        var i = 0
        var j = 1
        while (j <= size) {
            array[i] = array[j]
            i = j
            j += 1
        }
        return result
    }
}