package org.firas.collection

interface SortedCollection<E: Comparable<E>>: Collection<E> {

    /**
     * 1 <= n <= size()
     * @throws IllegalArgumentException if n < 1
     * @throws NoSuchElementException if n > size()
     */
    fun nthLeast(n: Int): E

    /**
     * 1 <= n <= size()
     * @throws IllegalArgumentException if n < 1
     * @throws NoSuchElementException if n > size()
     */
    fun nthGreatest(n: Int): E

    /**
     * @throws NoSuchElementException if no element in the sorted collection
     *                                 is greater than "other"
     */
    fun leastThatGreaterThan(other: E): E

    fun countGreaterThan(other: E): Int

    /**
     * @throws NoSuchElementException if no element in the sorted collection
     *                                 is not less than "other"
     */
    fun leastThatNotLessThan(other: E): E

    fun countNotLessThan(other: E): Int

    /**
     * @throws NoSuchElementException if no element in the sorted collection
     *                                 is less than "other"
     */
    fun greatestThatLessThan(other: E): E

    fun countLessThan(other: E): Int

    /**
     * @throws NoSuchElementException if no element in the sorted collection
     *                                 is not greater than "other"
     */
    fun greatestThatNotGreaterThan(other: E): E

    fun countNotGreaterThan(other: E): Int
}
