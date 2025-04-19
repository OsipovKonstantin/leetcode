package org.example.kotlin

import org.example.datastructures.TreeNode

//    easy #binary tree
//    Time complexity is O(n), where n is the number of nodes in the binary tree
//    Space complexity is O(n) due to the maximum height of the tree
//    https://leetcode.com/problems/path-sum
class SolutionDay205Second {
    companion object {
        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
            return traverse(root, 0, targetSum)
        }

        private fun traverse(node: TreeNode?, curSum: Int, targetSum: Int): Boolean {
            if (node == null) return false
            val nextSum = curSum + (node?.`val` ?: 0)
            return if (node.left == null && node.right == null && nextSum == targetSum) {
                true
            } else {
                traverse(node.left, nextSum, targetSum) || traverse(node.right, nextSum, targetSum)
            }
        }
    }
}