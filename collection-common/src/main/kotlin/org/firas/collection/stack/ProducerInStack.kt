package org.firas.collection.stack

/**
 *
 */
interface ProducerInStack<in E: Any?> {

    fun push(element: E)
}
