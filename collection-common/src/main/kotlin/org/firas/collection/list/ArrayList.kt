package org.firas.collection.list

import org.firas.collection.Iterator

/**
 *
 */
class ArrayList<E>(initialCapacity: Int = 10):
        AbstractList<E>(), org.firas.collection.stack.Stack<E> {

    private var capacity: Int = initialCapacity
    private var size: Int = 0
    private var array = arrayOfNulls<Any>(initialCapacity)

    override fun isEmpty(): Boolean {
        return 0 == size
    }

    override fun size(): Int {
        return size
    }

    override fun contains(element: E): Boolean {
        for (i in 0 .. (size - 1)) {
            if (null == element && null == array[i] ||
                    null != element && element.equals(array[i])) {
                return true
            }
        }
        return false
    }

    override fun get(index: Int): E {
        validateIndex(index)
        return elementData(index)
    }

    override fun set(index: Int, element: E) {
        validateIndex(index)
        array[index] = element
        modifyCount += 1
    }

    override fun append(element: E) {
        ensureCapacity(size + 1)
        array[size] = element
        size += 1
    }

    override fun push(element: E) {
        append(element);
    }

    override fun pop(): E {
        modifyCount += 1
        size -= 1
        return array[size]
    }

    override fun insert(index: Int, element: E) {
        ensureNonNegativeIndex(index)
        ensureCapacity(size + 1)
        var i = size
        var j = size - 1
        while (i > index) {
            array[i] = array[j]
            i = j
            j -= 1
        }
        array[index] = element
        size += 1
    }

    override fun remove(index: Int): E {
        validateIndex(index)
        modifyCount += 1
        val result = elementData(index)
        var i = index
        var j = index + 1
        while (j < size) {
            array[i] = array[j]
            i = j
            j += 1
        }
        size -= 1
        return result
    }

    override fun iterator(): Iterator<E> {
        return ArrayListIterator()
    }

    private inner open class ArrayListIterator : AbstractListIterator() {
        var cursor = 0

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

    private fun validateIndex(index: Int) {
        ensureNonNegativeIndex(index)
        if (index >= size) {
            throw IndexOutOfBoundsException()
        }
    }
}
