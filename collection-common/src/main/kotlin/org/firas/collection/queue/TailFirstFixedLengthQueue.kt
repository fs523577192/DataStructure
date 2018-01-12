package org.firas.collection.queue

/**
 *
 */
class TailFirstFixedLengthQueue<E: Any?>(length: Int):
        AbstractFixedLengthQueueWithSize<E>(length) {

    override fun produce(element: E) {
        checkFull()
        array[_size] = element
        _size += 1
    }

    override fun consume(): E {
        checkEmpty()
        val result = elementData(0)
        _size -= 1
        var i = 0
        var j = 1
        while (j <= _size) {
            array[i] = array[j]
            i = j
            j += 1
        }
        return result
    }
}