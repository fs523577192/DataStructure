package org.firas.collection.set

interface MutableSet<E>: Set<E> {

    /**
     * @return false if there is already an item
     *                equal to element in the set
     */
    fun add(element: E): Boolean

    /**
     * @return false if there is no item in the set
     *                equal to element
     */
    fun remove(element: E): Boolean
}
