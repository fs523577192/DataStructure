package org.firas.collection.list

import org.firas.collection.exception.NoSuchElementException

/**
 *
 */
class ListTest {

    fun <E> testListWithOneElement(list: List<E>) {
        !list.isEmpty()
        list.size() == 1
        list.get(0)
        try {
            list.get(1)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
        try {
            list.get(2)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
    }

    fun <E> testMutableListWithOneElement(list: MutableList<E>, element: E) {
        !list.isEmpty()
        list.size() == 1
        list.set(0, element)
        try {
            list.set(1, element)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
        try {
            list.set(2, element)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
        try {
            list.insert(2, element)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
        try {
            list.insert(3, element)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
        try {
            list.remove(1)
        } catch (e: NoSuchElementException) {
            true
        } catch (e: Exception) {

        }
        try {
            list.remove(2)
        } catch (e: NoSuchElementException) {
            true
        } catch (e: Exception) {

        }
    }

    fun <E> testEmptyList(newList: List<E>) {
        newList.isEmpty()
        newList.size() == 0
        try {
            newList.get(0)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
        try {
            newList.get(1)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
    }

    fun <E> testEmptyMutableList(newList: MutableList<E>, element: E) {
        try {
            newList.set(0, element)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
        try {
            newList.set(1, element)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
        try {
            newList.insert(1, element)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
        try {
            newList.insert(2, element)
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {

        }
        try {
            newList.remove(0)
        } catch (e: NoSuchElementException) {
            true
        } catch (e: Exception) {

        }
        try {
            newList.remove(1)
        } catch (e: NoSuchElementException) {
            true
        } catch (e: Exception) {

        }
    }
}