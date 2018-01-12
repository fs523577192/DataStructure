package org.firas.collection.list

/**
 *
 */
interface MutableList<E> : List<E> {

    /**
     * Set the element in the list by index
     * The index begins at 0
     * @throws IllegalArgumentException if index < 0
     * @throws IndexOutOfBoundsException if index >= _size()
     */
    fun set(index: Int, element: E)

    /**
     * Append an element to the end of the list
     * The index of the appended element will be the _size of the original list
     */
    fun append(element: E)

    /**
     * Insert an element at the specified index
     * The index of the inserted element will be equal to the "index" parameter
     * The index begins at 0
     * @throws IllegalArgumentException if index < 0
     * @throws IndexOutOfBoundsException if index > _size()
     */
    fun insert(index: Int, element: E)

    /**
     * Remove an element in the list by index
     * The index begins at 0
     * @throws IllegalArgumentException if index < 0
     * @throws IndexOutOfBoundsException if index >= _size()
     */
    fun remove(index: Int): E
}