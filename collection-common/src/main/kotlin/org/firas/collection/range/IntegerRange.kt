package org.firas.collection.range

import kotlin.math.max
import kotlin.math.min

class IntegerRange(
        private val beginValue: Int,
        private val endValue: Int,
        private val step: Int = 1):
        org.firas.collection.SortedCollection<Int> {

    constructor(endValue: Int, step: Int = 1): this(0, endValue, step)

    init {
        if (endValue > beginValue && step <= 0 || endValue < beginValue && step >= 0) {
            throw IllegalArgumentException("The end value cannot be reached")
        }
    }

    override fun isEmpty(): Boolean {
        return false
    }

    override fun size(): Int {
        return if (beginValue == endValue) 1 else (endValue - beginValue) / step + 1
    }

    override fun contains(element: Int): Boolean {
        return (step > 0 && element in beginValue..endValue
                && ((element - beginValue) % step == 0))
                || (step < 0 && element in endValue..beginValue
                && ((beginValue - element) % -step == 0))
    }

    override fun iterator(): Iterator<Int> {
        return IntegerRangeIterator(beginValue, endValue, step)
    }

    override fun countGreaterThan(other: Int): Int {
        if (step < 0) {
            // beginValue is the maximum
            if (beginValue <= other) {
                return 0
            }
            // beginValue > other
            val min = if (endValue > other) endValue else (other + 1)
            return (beginValue - min) / -step + 1
        }

        // step > 0, beginValue is the minimum
        val max = beginValue + (endValue - beginValue) / step * step
        if (max <= other) {
            return 0
        }
        // max > other
        val min = if (beginValue > other) beginValue else (other + 1)
        return (max - min) / step + 1
    }

    override fun leastThatGreaterThan(other: Int): Int {
        if (step < 0) {
            // beginValue is the maximum
            if (beginValue <= other) {
                throw NoSuchElementException("No element is greater than $other")
            }
            // beginValue > other
            val min = if (endValue > other) endValue else (other + 1)
            return beginValue + (min - beginValue) / step * step
        }

        // step > 0, beginValue is the minimum
        val max = beginValue + (endValue - beginValue) / step * step
        if (max <= other) {
            throw NoSuchElementException("No element is greater than $other")
        }
        // max > other
        val min = if (beginValue > other) beginValue else (other + 1)
        return beginValue + (max - min) / step * step
    }

    override fun countNotLessThan(other: Int): Int {
        if (step < 0) {
            // beginValue is the maximum
            if (beginValue < other) {
                return 0
            }
            // beginValue >= other
            val min = if (endValue >= other) endValue else other
            return (beginValue - min) / -step + 1
        }

        // step > 0, beginValue is the minimum
        val max = beginValue + (endValue - beginValue) / step * step
        if (max < other) {
            return 0
        }
        // max >= other
        val min = if (beginValue >= other) beginValue else other
        return (max - min) / step + 1
    }

    override fun leastThatNotLessThan(other: Int): Int {
        if (step < 0) {
            // beginValue is the maximum
            if (beginValue < other) {
                throw NoSuchElementException("No element is not less than $other")
            }
            // beginValue >= other
            return beginValue + (max(endValue, other) - beginValue) / step * step
        }

        // step > 0, beginValue is the minimum
        val max = beginValue + (endValue - beginValue) / step * step
        if (max < other) {
            throw NoSuchElementException("No element is not less than $other")
        }
        // max >= other
        return beginValue + (max - max(beginValue, other)) / step * step
    }

    override fun countLessThan(other: Int): Int {
        if (step > 0) {
            // beginValue is the minimum
            if (beginValue >= other) {
                return 0
            }
            // beginValue < other
            val max = if (endValue < other) endValue else (other - 1)
            return (max - beginValue) / step + 1
        }

        // step < 0, beginValue is the maximum
        val min = beginValue + (endValue - beginValue) / step * step
        if (min >= other) {
            return 0
        }
        // min < other
        val max = if (beginValue < other) beginValue else (other - 1)
        return (max - min) / -step + 1
    }

    override fun greatestThatLessThan(other: Int): Int {
        if (step > 0) {
            // beginValue is the minimum
            if (beginValue >= other) {
                throw NoSuchElementException("No element is less than $other")
            }
            // beginValue < other
            val max = if (endValue > other) endValue else (other - 1)
            return beginValue + (max - beginValue) / step * step
        }

        // step < 0, beginValue is the maximum
        val min = beginValue + (endValue - beginValue) / step * step
        if (min >= other) {
            throw NoSuchElementException("No element is less than $other")
        }
        // min < other
        val max = if (beginValue > other) beginValue else (other - 1)
        return beginValue + (max - min) / -step * step
    }

    override fun countNotGreaterThan(other: Int): Int {
        if (step > 0) {
            // beginValue is the minimum
            if (beginValue > other) {
                return 0
            }
            // beginValue <= other
            return (min(endValue, other) - beginValue) / step + 1
        }

        // step < 0, beginValue is the maximum
        val min = beginValue + (beginValue - endValue) / -step * step
        if (min > other) {
            return 0
        }
        // min <= other
        return (min(beginValue, other) - min) / -step + 1
    }

    override fun greatestThatNotGreaterThan(other: Int): Int {
        if (step > 0) {
            // beginValue is the minimum
            if (beginValue > other) {
                throw NoSuchElementException("No element is not greater than $other")
            }
            // beginValue <= other
            return beginValue + (min(endValue, other) - beginValue) / step * step
        }

        // step < 0, beginValue is the maximum
        val min = beginValue + (endValue - beginValue) / step * step
        if (min > other) {
            throw NoSuchElementException("No element is not greater than $other")
        }
        // min <= other
        return beginValue + (min(beginValue, other) - min) / -step * step
    }

    override fun nthLeast(n: Int): Int {
        ensurePositive(n)
        if (step < 0) { // beginValue is the maximum
            val size = size()
            if (n > size) {
                throw NoSuchElementException("There are/is less than $n element(s) in the sorted collection")
            }
            return beginValue + (size - n) * step
        }

        // step > 0, beginValue is the minimum
        val result = beginValue + (n - 1) * step
        if (result > endValue) {
            throw NoSuchElementException("There are/is less than $n element(s) in the sorted collection")
        }
        return result
    }

    override fun nthGreatest(n: Int): Int {
        ensurePositive(n)
        if (step > 0) { // beginValue is the minimum
            val size = size()
            if (n > size) {
                throw NoSuchElementException("There are/is less than $n element(s) in the sorted collection")
            }
            return beginValue + (size - n) * step
        }

        // step < 0, beginValue is the maximum
        val result = beginValue + (n - 1) * step
        if (result < endValue) {
            throw NoSuchElementException("There are/is less than $n element(s) in the sorted collection")
        }
        return result
    }

    private fun ensurePositive(n: Int) {
        if (n <= 0) {
            throw IllegalArgumentException("\"n\" must be positive: $n")
        }
    }
}