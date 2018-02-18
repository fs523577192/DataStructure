package org.firas.collection.map

interface Map<in K, out V> {

    fun get(key: K): V

    fun isEmpty(): Boolean

    fun size(): Int

    // TODO: keySet, entrySet

    interface Entry<K, V> {

        fun getKey(): K

        fun getValue(): V
    }
}
