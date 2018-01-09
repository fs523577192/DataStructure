package org.firas.collection.list

/**
 *
 */
class ArrayList<E>(initialCapacity: Int = 10) : AbstractList<E>() {

    private var capacity: Int = initialCapacity
    private var size: Int = 0
    private var array = arrayOfNulls<E>(initialCapacity)

    override fun get(index: Int): E? {
        ensureNonNegativeIndex(index)
        if (index >= size) {
            throw kotlin.IndexOutOfBoundsException()
        }
        return array[index]
    }

    override fun isEmpty(): Boolean {
        return 0 == size
    }

    override fun size(): Int {
        return size
    }

    override fun set(index: Int, element: E?) {
        if (index < 0) {
            throw kotlin.IllegalArgumentException()
        }
        if (index >= size) {
            throw kotlin.IndexOutOfBoundsException()
        }
        array[index] = element
    }
}