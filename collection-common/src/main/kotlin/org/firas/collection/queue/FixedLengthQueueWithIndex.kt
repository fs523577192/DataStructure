package org.firas.collection.queue

class FixedLengthQueueWithIndex<E>(length: Int) : AbstractFixedLengthQueueWithIndex<E>(length) {

    override fun size(): Int {
        if (exitIndex < 0) {
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
        } else if (-1 == exitIndex) {
            exitIndex = entryIndex
        }
        array[entryIndex] = element
        entryIndex += 1
        if (entryIndex >= array.size) {
            entryIndex = 0
        }
    }

    override fun consume(): E {
        if (-1 == exitIndex) {
            throw Exception("Empty")
        }
        val result = elementData(exitIndex)
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
