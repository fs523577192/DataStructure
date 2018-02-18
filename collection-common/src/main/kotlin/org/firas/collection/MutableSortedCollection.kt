package org.firas.collection

interface MutableSortedCollection<E: Comparable<E>>: SortedCollection<E> {

    fun add(element: E)

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
