package org.firas.collection.queue

/**
 *
 */
interface ProducerInQueue<in E: Any?> {

    fun produce(element: E)
}
