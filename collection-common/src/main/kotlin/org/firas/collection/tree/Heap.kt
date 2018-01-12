package org.firas.collection.tree

abstract class Heap<E: Any?> protected constructor(
        protected var root: HeapNode<E>): BinaryTree<E>() {

    protected class HeapNode<E>(
            left: HeapNode<E>?,
            right: HeapNode<E>?,
            var element: E): BinaryTreeNode<E, HeapNode<E>>(left, right)
}
