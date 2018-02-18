package org.firas.collection.map

interface MutableMap<in K, V>: Map<K, V> {

    fun put(K key, V value)

    fun remove(K key): V
}