package org.firas.collection.queue

/**
 *
 */
interface Queue<E> : ProducerInQueue<E>, ConsumerInQueue<E> {

    fun size(): Int
}
