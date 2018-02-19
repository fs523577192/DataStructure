package org.firas.collection.list

import kotlin.test.*

/**
 *
 */
class ListTest {

    fun <E> testListWithOneElement(list: List<E>) {
        assertFalse(list.isEmpty(), "The list is empty")
        assertEquals(1, list.size(), "The size of the list is not 1")
        try {
            list.get(0)
            true
        } catch (e: Exception) {
            false
        }
        try {
            list.get(1)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }
        try {
            list.get(2)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }
    }

    fun <E> testMutableListWithOneElement(list: MutableList<E>, element: E) {
        try {
            list.set(0, element)
            true
        } catch (e: Exception) {
            false
        }
        try {
            list.set(1, element)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }
        try {
            list.set(2, element)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }

        try {
            list.insert(2, element)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }
        try {
            list.insert(3, element)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }

        try {
            list.remove(1)
            false
        } catch (e: NoSuchElementException) {
            true
        } catch (e: Exception) {
            false
        }
        try {
            list.remove(2)
            false
        } catch (e: NoSuchElementException) {
            true
        } catch (e: Exception) {
            false
        }
    }

    fun <E> testEmptyList(newList: List<E>) {
        assertTrue(newList.isEmpty(), "The list is not empty")
        assertEquals(0, newList.size(), The size of the list is not 0")
        try {
            newList.get(0)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }
        try {
            newList.get(1)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }
    }

    fun <E> testEmptyMutableList(newList: MutableList<E>, element: E) {
        try {
            newList.set(0, element)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }
        try {
            newList.set(1, element)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }

        try {
            newList.insert(1, element)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }
        try {
            newList.insert(2, element)
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        } catch (e: Exception) {
            false
        }

        try {
            newList.remove(0)
            false
        } catch (e: NoSuchElementException) {
            true
        } catch (e: Exception) {
            false
        }
        try {
            newList.remove(1)
            false
        } catch (e: NoSuchElementException) {
            true
        } catch (e: Exception) {
            false
        }
    }

    fun testList(list: MutableList<Int>) {
        testEmptyList(list)
        testEmptyMutableList(list, 0)

        list.append(0)
        testListWithOneElement(list)
        testMutableListWithOneElement(list, 0)

        list.remove(0)
        testEmptyList(list)
        testEmptyMutableList(list, 0)

        list.insert(0, 0)
        testListWithOneElement(list)
        testMutableListWithOneElement(list, 0)

        list.insert(0, 1)
        list.remove(1)
        testListWithOneElement(list)
        testMutableListWithOneElement(list, 0)

        list.insert(0, 1)
        list.remove(1)
        testListWithOneElement(list)
        testMutableListWithOneElement(list, 0)
    }

    fun testArrayList() {

    }

    @Test
    fun test() {

    }
}
