package org.firas.collection.queue

class FixedLengthQueueWithIndexAndFull<E>(length: Int) : AbstractFixedLengthQueueWithIndex<E>(length, 0) {

    private var full = false

    override fun size(): Int {
        if (full) {
            return array.size
        }
        if (exitIndex <= entryIndex) {
            return exitIndex + array.size - entryIndex
        }
        return exitIndex - entryIndex
    }

    override fun produce(element: E) {
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

    override fun consume(): E {
        val result = elementData(exitIndex)
        exitIndex += 1
        if (exitIndex >= array.size) {
            exitIndex = 0
        }
        full = false
        return result
    }
}
