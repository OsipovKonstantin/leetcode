package org.example.kotlin

import org.example.datastructures.TreeNode

class SolutionDay205 {
    companion object {
        fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
            return traverse(root)[0]
        }

        private fun traverse(node: TreeNode?): Array<TreeNode?> {
            if (node == null) return arrayOf(null, TreeNode(0))
            val left = traverse(node.left)
            val right = traverse(node.right)

            val leftDepth = left[1]?.`val` ?: 0
            val rightDepth = right[1]?.`val` ?: 0

            return when {
                leftDepth == rightDepth -> arrayOf(node, TreeNode(leftDepth + 1))
                leftDepth > rightDepth -> arrayOf(left[0], TreeNode(leftDepth + 1))
                else -> arrayOf(right[0], TreeNode(rightDepth + 1))
            }
        }
    }
}