package org.firas.collection.tree

class RedBlackTree<E: Any?>(): BinaryTree<E>() {

    private var root: RedBlackTreeNode<E>? = null

    private class RedBlackTreeNode<E>(
            left: RedBlackTreeNode<E>?,
            right: RedBlackTreeNode<E>?,
            var isBlack: Boolean,
            var element: E): BinaryTreeNode<E, RedBlackTreeNode<E>>(left, right)
}
