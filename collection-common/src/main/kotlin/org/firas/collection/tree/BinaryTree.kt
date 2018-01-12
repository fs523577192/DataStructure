package org.firas.collection.tree

import org.firas.collection.exception.NoSuchElementException

abstract class BinaryTree<E> {

    protected abstract class BinaryTreeNode<E, T: BinaryTreeNode<E, T>>(
            var left: T?, var right: T?) {

        fun leftRotateLeft() {
            val left = this.left ?: throw NoSuchElementException("No Left Node")
            try {
                this.left = left.rotateLeft()
            } catch (e: NoSuchElementException) {
                throw NoSuchElementException("The left node has no right child")
            }
        }

        fun leftRotateRight() {
            val left = this.left ?: throw NoSuchElementException("No Left Node")
            try {
                this.left = left.rotateRight()
            } catch (e: NoSuchElementException) {
                throw NoSuchElementException("The left node has no left child")
            }
        }

        fun rightRotateLeft() {
            val right = this.right ?: throw NoSuchElementException("No Right Node")
            try {
                this.right = right.rotateLeft()
            } catch (e: NoSuchElementException) {
                throw NoSuchElementException("The right node has no right child")
            }
        }

        fun rightRotateRight() {
            val right = this.right ?: throw NoSuchElementException("No Right Node")
            try {
                this.right = right.rotateRight()
            } catch (e: NoSuchElementException) {
                throw NoSuchElementException("The right node has no left child")
            }
        }


        /**
         * this: 1
         *
         *    1              3
         *   / \            / \
         *  0   3    ==>   1   4
         *     / \        / \
         *    2   4      0   2
         */
        private fun rotateLeft(): T {
            val three = this.right ?: throw NoSuchElementException("No Right Node")
            this.right = three.left // two
            three.left = (this as T)
            return three
        }

        /**
         * this: 3
         *
         *      3            1
         *     / \          / \
         *    1   4   ==>  0   3
         *   / \              / \
         *  0   2            2   4
         */
        private fun rotateRight(): T {
            val one = this.left ?: throw NoSuchElementException("No Right Node")
            this.left = one.right // two
            one.right = (this as T)
            return one
        }
    }

    protected abstract class BinaryTreeNodeWithParent<E, T: BinaryTreeNodeWithParent<E, T>>(
            left: T?, right: T?, var parent: T?):
            BinaryTreeNode<E, BinaryTreeNodeWithParent<E, T>>(left, right) {

        fun safelySetLeft(left: T?) {
            this.left = left
            if (null != left) {
                left.parent = (this as T)
            }
        }
        fun safelySetRight(right: T?) {
            this.right = right
            if (null != right) {
                right.parent = (this as T)
            }
        }

        /**
         * this: 1
         *
         *    1              3
         *   / \            / \
         *  0   3    ==>   1   4
         *     / \        / \
         *    2   4      0   2
         */
        fun rotateLeft() {
            val three = this.right ?: throw NoSuchElementException("No Right Node")
            val parent = this.parent
            if (null != parent) {
                if (this == parent.left) {
                    parent.left = three
                } else {
                    parent.right = three
                }
            }
            three.parent = parent
            safelySetRight(three.left as T?) // two
            three.left = (this as T)
            this.parent = (three.left as T)
        }

        /**
         * this: 3
         *
         *      3            1
         *     / \          / \
         *    1   4   ==>  0   3
         *   / \              / \
         *  0   2            2   4
         */
        fun rotateRight() {
            val one = this.left ?: throw NoSuchElementException("No Right Node")
            val parent = this.parent
            if (null != parent) {
                if (this == parent.left) {
                    parent.left = one
                } else {
                    parent.right = one
                }
            }
            one.parent = parent
            safelySetLeft(one.right as T) // two
            one.right = (this as T)
            this.parent = (one as T)
        }
    }

    protected fun <T: BinaryTreeNode<E, T>> size(root: BinaryTreeNode<E, T>?): Int {
        if (null == root) {
            return 0
        }
        return 1 + size(root.left) + size(root.right)
    }
}
