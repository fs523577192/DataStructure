package org.firas.collection.range

/**
 *
 */
class DoubleRangeIterator
        (beginValue: Double, endValue: Double, private val step: Double):
        RangeIterator<Double>(beginValue, endValue) {

    init {
        if (endValue > beginValue && step <= 0 || endValue < beginValue && step >= 0) {
            throw IllegalArgumentException("The end value cannot be reached")
        }
    }

    override fun increment() {
        this.currentValue += step
    }
}
