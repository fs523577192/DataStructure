package org.firas.collection.list

import org.firas.collection.range.IntegerRange

class SortedArrayList<E: Comparable<E>>(initialCapacity: Int = 10):
        org.firas.collection.MutableSortedCollection<E> {

    private var size: Int = 0
    private var array = arrayOfNulls<Any>(initialCapacity)
    private var modifyCount: Int = 0

    override fun isEmpty(): Boolean {
        return 0 == size
    }

    override fun size(): Int {
        return size
    }

    override fun contains(element: E): Boolean {
        return IntegerRange(size - 1).any {
            element == array[it]
        }
    }

    override fun countLessThan(other: E): Int {
        if (false) {
            var result = 0
            while (result < size && elementData(result) < other) {
                result += 1
            }
            return result
        }
        var begin = 0
        var end = size - 1
        while (begin < end) {
            var middle = (begin + end) ushr 1
            if (elementData(middle) < other) {
                begin = middle
            } else { // array[middle] >= other
                end = middle
            }
        }
        return begin + 1
    }

    override fun countNotGreaterThan(other: E): Int {
        if (false) {
            var result = 0
            while (result < size && elementData(result) <= other) {
                result += 1
            }
            return result
        }
        var begin = 0
        var end = size - 1
        while (begin < end) {
            var middle = (begin + end) ushr 1
            if (elementData(middle) <= other) {
                begin = middle
            } else { // array[middle] > other
                end = middle
            }
        }
        return begin + 1
    }

    override fun countGreaterThan(other: E): Int {
        return size - countNotLessThan(other)
    }

    override fun countNotLessThan(other: E): Int {
        return size - countLessThan(other)
    }

    override fun nthLeast(n: Int): E {
        ensureNth(n)
        return elementData(n - 1)
    }

    override fun nthGreatest(n: Int): E {
        ensureNth(n)
        return elementData(size - n)
    }

    override fun leastThatGreaterThan(other: E): E {
        val index = countNotGreaterThan(other)
        if (index >= size) {
            throw NoSuchElementException("No element in the list is greater than other")
        }
        return elementData(index)
    }

    override fun leastThatNotLessThan(other: E): E {
        val index = countLessThan(other)
        if (index >= size) {
            throw NoSuchElementException("No element in the list is not less than other")
        }
        return elementData(index)
    }

    override fun greatestThatLessThan(other: E): E {
        val index = countLessThan(other)
        if (index <= 0) {
            throw NoSuchElementException("No element in the list is less than other")
        }
        return elementData(index - 1)
    }

    override fun greatestThatNotGreaterThan(other: E): E {
        val index = countNotGreaterThan(other)
        if (index <= 0) {
            throw NoSuchElementException("No element in the list is not greater than other")
        }
        return elementData(index - 1)
    }

    override fun add(element: E): Boolean {
        val index = countNotLessThan(element)
        ensureCapacity(size + 1)
        var i = size
        while (i > index) {
            array[i] = array[i - 1]
            i -= 1
        }
        array[index] = element
        return true
    }

    override fun remove(element: E): Boolean {
        var index = countNotLessThan(element)
        if (elementData(index) == element) {
            modifyCount += 1
            size -= 1
            while (index < size) {
                array[index] = array[index + 1]
                index += 1
            }
            return true
        }
        return false
    }

    override fun removeNthLeast(n: Int): E {
        ensureNth(n)
        var index = n - 1
        val result = elementData(index)
        while (index < size) {
            array[index] = array[index + 1]
            index += 1
        }
        return result
    }

    override fun removeNthGreatest(n: Int): E {
        ensureNth(n)
        var index = size - n
        val result = elementData(index)
        while (index < size) {
            array[index] = array[index + 1]
            index += 1
        }
        return result
    }

    private fun ensureNth(n: Int) {
        if (n <= 0) {
            throw IllegalArgumentException("\"n\" must be positive: $n")
        }
        if (n > size) {
            throw NoSuchElementException("There are/is less than $n element(s) in the sorted collection")
        }
    }

    override fun iterator(): Iterator<E> {
        return SortedArrayListIterator()
    }

    private inner class SortedArrayListIterator: Iterator<E> {
        var cursor = 0
        val expectedModifyCount = modifyCount

        private fun checkForComodification() {
            if (modifyCount != expectedModifyCount) {
                throw Exception("Concurrent modification")
            }
        }

        override fun hasNext(): Boolean {
            checkForComodification()
            return cursor < size
        }

        override fun next(): E {
            checkForComodification()
            val index = cursor
            cursor += 1
            if (index >= size) {
                throw Exception("No such element")
            }
            return elementData(index)
        }
    }

    private fun ensureCapacity(minCapacity: Int) {
        if (minCapacity <= array.size) {
            return
        }
        var capacity = array.size + (array.size ushr 1)
        if (minCapacity > capacity) {
            capacity = minCapacity
        }
        modifyCount += 1
        array = array.copyOf(capacity)
    }

    private fun elementData(index: Int): E {
        return (array[index] as E)
    }
}