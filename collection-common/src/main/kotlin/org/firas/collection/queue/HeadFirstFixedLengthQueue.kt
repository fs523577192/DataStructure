package org.firas.collection.queue

/**
 *
 */
class HeadFirstFixedLengthQueue<E: Any?>(length: Int) : AbstractFixedLengthQueueWithSize<E>(length) {

    override fun produce(element: E) {
        checkFull()
        var i = _size
        var j = _size - 1
        while (j >= 0) {
            array[i] = array[j]
            i = j
            j -= 1
        }
        array[0] = element
        _size += 1
    }

    override fun consume(): E {
        checkEmpty()
        _size -= 1
        return elementData(_size)
    }
}