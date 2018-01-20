package org.firas.collection

interface SortedCollection<E: Comparable<E>>: Collection<E> {

    fun nthLeast(): E

    fun nthGreatest(): E

    fun leastThatGreaterThan(other: E): E

    fun countGreaterThan(other: E): Int

    fun leastThatNotLessThan(other: E): E

    fun countNotLessThan(other: E): Int

    fun greatestThatLessThan(other: E): E

    fun countLessThan(other: E): Int

    fun greatestThatNotGreaterThan(other: E): E

    fun countNotGreaterThan(other: E): Int
}
