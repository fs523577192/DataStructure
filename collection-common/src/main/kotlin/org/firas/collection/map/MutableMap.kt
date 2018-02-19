package org.firas.collection.map

interface MutableMap<in K, V>: Map<K, V> {

    fun put(key: K, value: V)

    fun remove(key: K): V
}