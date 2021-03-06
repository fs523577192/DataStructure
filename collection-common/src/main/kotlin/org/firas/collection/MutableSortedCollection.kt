package org.firas.collection

interface MutableSortedCollection<E: Comparable<E>>: SortedCollection<E> {

    /**
     * @return true  if the element is added successfully
     *          false otherwise
     */
    fun add(element: E): Boolean

    /**
     * @return false if there is no item equal to "element" in the sorted collection
     *          true  otherwise
     */
    fun remove(element: E): Boolean

    /**
     * 1 <= n <= size()
     * @throws IllegalArgumentException if n < 1
     * @throws NoSuchElementException if n > size()
     */
    fun removeNthLeast(n: Int): E

    /**
     * 1 <= n <= size()
     * @throws IllegalArgumentException if n < 1
     * @throws NoSuchElementException if n > size()
     */
    fun removeNthGreatest(n: Int): E
}
