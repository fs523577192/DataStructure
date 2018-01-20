package org.firas.collection

interface MutableSortedCollection<E: Comparable<E>>: SortedCollection<E> {

    fun add(element: E)

    fun remove(element: E): Boolean

    fun removeNthLeast(): E

    fun removeNthGreatest(): E
}
