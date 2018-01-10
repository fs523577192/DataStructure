package org.firas.datatype.queue

class FixedLengthQueueWithIndexAndEmpty<E>(length: Int) : AbstractFixedLengthQueueWithIndex<E>(length, 0) {

    private var empty = true

    fun size() {
        if (empty) {
            return 0
        }
        if (exitIndex <= entryIndex) {
            return exitIndex + array.size - entryIndex
        }
        return exitIndex - entryIndex
    }

    fun produce(element: E) {
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

    fun consume(): E {
        if (-1 == exitIndex) {
            throw Exception("Empty")
        }
        val result = checkNotNull(array[exitIndex])
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
