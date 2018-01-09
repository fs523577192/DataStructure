package org.firas.collection.list

/**
 *
 */
interface MutableList<E> : List<E> {

    fun set(index: Int, element: E)

    fun remove(index: Int): E
}