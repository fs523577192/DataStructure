package org.firas.collection.tree

abstract class BinaryTree<E> : org.firas.collection.Collection {

    protected abstract class BinaryTreeNode<E, T: BinaryTreeNode<E, T>>(
            var left: T?, var right: T?)

    protected fun size(BinaryTreeNode<E, T> root) {
        if (null == root) {
            return 0
        }
        return 1 + size(root?.left) + size(root?.right)
    }
}
