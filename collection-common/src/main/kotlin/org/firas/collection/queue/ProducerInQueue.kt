package org.firas.collection.queue

/**
 *
 */
interface ProducerInQueue<in E> {

    fun produce(element: E)
}
