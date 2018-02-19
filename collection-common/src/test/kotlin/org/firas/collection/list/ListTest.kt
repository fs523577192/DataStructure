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
        } catch (e: Exception) {
            fail("Fail to get the first element")
        }
        assertFailsWith(IndexOutOfBoundsException::class, {list.get(1)})
        assertFailsWith(IndexOutOfBoundsException::class, {list.get(2)})
    }

    fun <E> testMutableListWithOneElement(list: MutableList<E>, element: E) {
        try {
            list.set(0, element)
        } catch (e: Exception) {
            fail("Fail to set the first element")
        }
        assertEquals(element, list.get(0), "The element got is not the same as the element set")

        assertFailsWith(IndexOutOfBoundsException::class, {list.set(1, element)})
        assertFailsWith(IndexOutOfBoundsException::class, {list.set(2, element)})

        assertFailsWith(IndexOutOfBoundsException::class, {list.insert(2, element)})
        assertFailsWith(IndexOutOfBoundsException::class, {list.insert(3, element)})

        assertFailsWith(IndexOutOfBoundsException::class, {list.remove(1)})
        assertFailsWith(IndexOutOfBoundsException::class, {list.remove(2)})
    }

    fun <E> testEmptyList(newList: List<E>) {
        assertTrue(newList.isEmpty(), "The list is not empty")
        assertEquals(0, newList.size(), "The size of the list is not 0")

        assertFailsWith(IndexOutOfBoundsException::class, {newList.get(0)})
        assertFailsWith(IndexOutOfBoundsException::class, {newList.get(1)})
    }

    fun <E> testEmptyMutableList(newList: MutableList<E>, element: E) {
        assertFailsWith(IndexOutOfBoundsException::class, {newList.set(0, element)})
        assertFailsWith(IndexOutOfBoundsException::class, {newList.set(1, element)})

        assertFailsWith(IndexOutOfBoundsException::class, {newList.insert(1, element)})
        assertFailsWith(IndexOutOfBoundsException::class, {newList.insert(2, element)})

        assertFailsWith(IndexOutOfBoundsException::class, {newList.remove(0)})
        assertFailsWith(IndexOutOfBoundsException::class, {newList.remove(1)})
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

    @Test
    fun test() {
        testList(ArrayList())
        testList(ArrayList(1))

        testList(LinkedList())
        testList(LinkedListWithTail())
        testList(BidirectionalLinkedList())
        testList(CircularLinkedList())
        testList(CircularBidirectionalLinkedList())
    }
}
