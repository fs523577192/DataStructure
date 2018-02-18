package org.firas.collection.queue

class FixedLengthQueueWithIndexAndSize<E>(length: Int) : AbstractFixedLengthQueueWithSize<E>(length) {

    private var exitIndex = 0

    override fun size(): Int {
        return _size
    }

    override fun produce(element: E) {
        checkFull()
        var index = exitIndex + _size
        if (index > array.size) {
            index -= array.size
        }
        array[index] = element
        _size += 1
    }

    override fun consume(): E {
        checkEmpty()
        val result = elementData(exitIndex)
        exitIndex += 1
        if (exitIndex >= array.size) {
            exitIndex = 0
        }
        return result
    }
}
