package org.firas.collection.range

import kotlin.test.*

class IntegerRangeTest {

    @Test
    fun test() {
        test01Common(IntegerRange(1))
        test01Common(IntegerRange(1, 0, -1))

        test024Common(IntegerRange(4, 2))
        test024Common(IntegerRange(5, 2))
        test024Common(IntegerRange(4, 0, -2))
        test024Common(IntegerRange(4, -1, -2))
    }

    fun test01Common(range: IntegerRange) {
        assertFalse(range.isEmpty(), "The range is empty")
        assertEquals(2, range.size(), "The size of the range is not 2")
        assertFalse(range.contains(-1), "The range contains -1")
        assertFalse(range.contains(2), "The range contains 2")
        assertTrue(range.contains(0), "The range does NOT contain 0")
        assertTrue(range.contains(1), "The range does NOT contain 1")

        assertEquals(0, range.countGreaterThan(2), "countGreaterThan(2) != 0")
        assertEquals(0, range.countGreaterThan(1), "countGreaterThan(1) != 0")
        assertEquals(1, range.countGreaterThan(0), "countGreaterThan(0) != 1")
        assertEquals(2, range.countGreaterThan(-1), "countGreaterThan(-1) != 2")

        assertEquals(0, range.countNotLessThan(2), "countNotLessThan(2) != 0")
        assertEquals(1, range.countNotLessThan(1), "countNotLessThan(1) != 1")
        assertEquals(2, range.countNotLessThan(0), "countNotLessThan(0) != 2")
        assertEquals(2, range.countNotLessThan(-1), "countNotLessThan(-1) != 2")

        assertEquals(2, range.countLessThan(2), "countLessThan(2) != 2")
        assertEquals(1, range.countLessThan(1), "countLessThan(1) != 1")
        assertEquals(0, range.countLessThan(0), "countLessThan(0) != 0")
        assertEquals(0, range.countLessThan(-1), "countLessThan(-1) != 0")

        assertEquals(2, range.countNotGreaterThan(2), "countNotGreaterThan(2) != 2")
        assertEquals(2, range.countNotGreaterThan(1), "countNotGreaterThan(1) != 2")
        assertEquals(1, range.countNotGreaterThan(0), "countNotGreaterThan(0) != 1")
        assertEquals(0, range.countNotGreaterThan(-1), "countNotGreaterThan(-1) != 0")
    }

    fun test024Common(range: IntegerRange) {
        assertFalse(range.isEmpty(), "The range is empty")
        assertEquals(3, range.size(), "The size of the range is not 3")
        assertFalse(range.contains(-1), "The range contains -1")
        assertFalse(range.contains(1), "The range contains 1")
        assertFalse(range.contains(3), "The range contains 3")
        assertFalse(range.contains(5), "The range contains 5")
        assertTrue(range.contains(0), "The range does NOT contain 0")
        assertTrue(range.contains(2), "The range does NOT contain 2")
        assertTrue(range.contains(4), "The range does NOT contain 4")

        assertEquals(0, range.countGreaterThan(5), "countGreaterThan(5) != 0")
        assertEquals(0, range.countGreaterThan(4), "countGreaterThan(4) != 0")
        assertEquals(1, range.countGreaterThan(3), "countGreaterThan(3) != 1")
        assertEquals(1, range.countGreaterThan(2), "countGreaterThan(2) != 1")
        assertEquals(2, range.countGreaterThan(1), "countGreaterThan(1) != 2")
        assertEquals(2, range.countGreaterThan(0), "countGreaterThan(0) != 2")
        assertEquals(3, range.countGreaterThan(-1), "countGreaterThan(-1) != 3")
    }
}
