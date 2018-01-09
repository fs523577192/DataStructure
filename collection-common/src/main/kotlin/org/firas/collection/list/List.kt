package org.firas.collection.list

import org.firas.collection.Collection

/**
 *
 */
interface List<E> : Collection<E> {

    fun get(index: Int): E?
}