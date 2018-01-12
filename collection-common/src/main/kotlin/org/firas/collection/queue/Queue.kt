package org.firas.collection.queue

/**
 *
 */
interface Queue<E: Any?> : ProducerInQueue<E>, ConsumerInQueue<E> {

    fun size(): Int
}
