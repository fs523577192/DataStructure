package org.firas.collection.map

interface Map<K, V> {

    fun get(key: K): V

    fun isEmpty(): Boolean

    fun size(): Int

    // TODO: keySet, entrySet

    interface Entry<K, V> {

        fun getKey(): K

        fun getValue(): V
    }
}
