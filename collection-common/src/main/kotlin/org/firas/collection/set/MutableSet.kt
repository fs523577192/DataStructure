package org.firas.collection.set

interface MutableSet<E>: Set<E> {

    /**
     * @return false if there is already an item
     *                  equal to element in the set
     */
    fun add(element: E): Boolean

    fun remove(element; E)
}
