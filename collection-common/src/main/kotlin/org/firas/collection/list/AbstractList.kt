package org.firas.collection.list

import org.firas.collection.Iterator

/**
 *
 */
abstract class AbstractList<E> : MutableList<E> {

    protected inner abstract class AbstractListIterator : Iterator<E> {
        val expectedModifyCount = modifyCount

        protected fun checkForComodification() {
            if (modifyCount != expectedModifyCount) {
                throw Exception("Concurrent modification")
            }
        }
    }

    protected fun ensureNonNegativeIndex(index: Int) {
        if (index < 0) {
            throw IllegalArgumentException()
        }
    }

    protected var modifyCount = 0
}
