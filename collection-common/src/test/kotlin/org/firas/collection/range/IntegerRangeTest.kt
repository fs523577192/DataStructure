package org.firas.collection.range

import kotlin.test.Test

class IntegerRangeTest {

    fun test01() {
        val range = IntegerRange(1)
    }

    fun test10() {
        val range = IntegerRange(-1, -1)
    }

    fun test024() {
        val range = IntegerRange(4, 2)
    }

    fun test420() {
        val range = IntegerRange(4, 0, -2)
    }

    @Test
    fun testIntegerRange() {
        test01()
        test10()
        test024()
        test420()
    }
}