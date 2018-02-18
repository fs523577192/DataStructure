package org.firas.collection.range

/**
 *
 */
class IntegerRangeIterator
        (beginValue: Int, endValue: Int, private val step: Int = 1):
        RangeIterator<Int>(beginValue, endValue) {

    constructor(endValue: Int, step: Int = 1): this(0, endValue, step)

    init {
        if (endValue > beginValue && step <= 0 || endValue < beginValue && step >= 0) {
            throw IllegalArgumentException("The end value cannot be reached")
        }
    }

    override fun increment() {
        this.currentValue += step
    }
}
