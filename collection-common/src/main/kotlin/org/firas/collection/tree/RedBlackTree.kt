package org.firas.collection.tree

class RedBlackTree<E: Any?>(protected var root: RedBlackTreeNode<E>): BinaryTree<E>() {

    protected class RedBlackTreeNode<E>(
            var left: RedBlackTreeNode<E>?,
            var right: RedBlackTreeNode<E>?,
            var isBlack: Boolean,
            var element: E): BinaryTreeNode<E, RedBlackTreeNode<E>>(left, right)
}
