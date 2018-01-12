package org.firas.collection.queue

/**
 *
 */
interface ConsumerInQueue<out E: Any?> {

    fun consume(): E
}