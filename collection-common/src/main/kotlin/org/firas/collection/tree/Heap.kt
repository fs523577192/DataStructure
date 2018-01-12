package org.firas.collection.tree

abstract class Heap<E: Any?>(protected var root: HeapNode<E>): BinaryTree<E>() {

    protected class HeapNode<E>(
            var left: HeapNode<E>?,
            var right: HeapNode<E>?,
            var element: E): BinaryTreeNode<E, HeapNode<E>>(left, right)
}
