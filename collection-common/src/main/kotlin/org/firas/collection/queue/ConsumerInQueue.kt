package org.firas.collection.queue

/**
 *
 */
interface ConsumerInQueue<out E> {

    fun consume(): E
}