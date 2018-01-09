package org.firas.collection.queue

/**
 *
 */
interface ConsumerInQueue<E> {

    fun consume(): E
}