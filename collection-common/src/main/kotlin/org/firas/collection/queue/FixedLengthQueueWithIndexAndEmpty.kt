package org.firas.collection.queue

class FixedLengthQueueWithIndexAndEmpty<E>(length: Int):
        AbstractFixedLengthQueueWithIndex<E>(length, 0) {

    private var empty = true

    override fun size(): Int {
        if (empty) {
            return 0
        }
        if (exitIndex <= entryIndex) {
            return exitIndex + array.size - entryIndex
        }
        return exitIndex - entryIndex
    }

    override fun produce(element: E) {
        if (entryIndex == exitIndex) {
            throw Exception("Full")
        }
        array[entryIndex] = element
        entryIndex += 1
        if (entryIndex >= array.size) {
            entryIndex = 0
        }
        empty = false
    }

    override fun consume(): E {
        if (empty) {
            throw NoSuchElementException("Empty Queue")
        }
        val result = elementData(exitIndex)
        exitIndex += 1
        if (exitIndex >= array.size) {
            exitIndex = 0
        }
        if (entryIndex == exitIndex) {
            empty = true
        }
        return result
    }
}
