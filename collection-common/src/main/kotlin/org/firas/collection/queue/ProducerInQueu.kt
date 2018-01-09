package org.firas.collection.queue

/**
 *
 */
interface ProducerInQueu<E> {

    fun produce(element: E)
}