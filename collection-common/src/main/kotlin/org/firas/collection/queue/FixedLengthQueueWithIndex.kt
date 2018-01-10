package org.firas.datatype.queue

class FixedLengthQueueWithIndex<E>(length: Int) : AbstractFixedLengthQueueWithIndex<E>(length) {

    fun size() {
        if (exitIndex < 0) {
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
        } else if (-1 == exitIndex) {
            exitIndex = entryIndex
        }
        array[entryIndex] = element
        entryIndex += 1
        if (entryIndex >= array.size) {
            entryIndex = 0
        }
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
            // becomes empty
            exitIndex = -1
        }
        return result
    }
}
