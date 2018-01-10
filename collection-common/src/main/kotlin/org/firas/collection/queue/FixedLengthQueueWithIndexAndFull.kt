package org.firas.datatype.queue

class FixedLengthQueueWithIndex<E>(length: Int) : AbstractFixedLengthQueueWithIndex<E>(length, 0) {

    private var full = false

    fun size() {
        if (full) {
            return array.size
        }
        if (exitIndex <= entryIndex) {
            return exitIndex + array.size - entryIndex
        }
        return exitIndex - entryIndex
    }

    fun produce(element: E) {
        if (full) {
            throw Exception("Full")
        }
        array[entryIndex] = element
        entryIndex += 1
        if (entryIndex >= array.size) {
            entryIndex = 0
        }
        if (entryIndex == exitIndex) {
            full = true
        }
    }

    fun consume(): E {
        val result = checkNotNull(array[exitIndex])
        exitIndex += 1
        if (exitIndex >= array.size) {
            exitIndex = 0
        }
        full = false
        return result
    }
}
