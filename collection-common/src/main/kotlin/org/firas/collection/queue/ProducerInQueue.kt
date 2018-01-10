package org.firas.collection.queue

/**
 *
 */
interface ProducerInQueue<E> {

    fun produce(element: E)
}
