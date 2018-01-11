package org.firas.collection.list

import org.firas.collection.Collection

/**
 *
 */
interface List<E> : Collection<E> {

    /**
     * Get the element in the list by index
     * The index begins at 0
     * @throws IllegalArgumentException if index < 0
     * @throws IndexOutOfBoundsException if index >= size()
     */
    fun get(index: Int): E
}