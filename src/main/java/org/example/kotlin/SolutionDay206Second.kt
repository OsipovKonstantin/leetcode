package org.example.kotlin

import org.example.datastructures.TreeNode

//    #easy #binary tree (BT) #kotlin
//    Time complexity is O(logn*logn), where n is the number of nodes in the binary tree
//    Space complexity is O(logn) due to the height of binary tree
//    https://leetcode.com/problems/count-complete-tree-nodes
class SolutionDay206Second {
    companion object {
        fun countNodes(root: TreeNode?): Int {
            if (root == null) return 0
            val dummy = TreeNode(0, root, null)
            var depth = 0
            var node = root
            while (node != null) {
                node = node.left
                depth++
            }

            var left = 1
            var right = 1 shl (depth - 1)
            while (left < right) {
                val mid: Int = right - (right - left) / 2
                if (isValid(mid, dummy.left, depth)) left = mid
                else right = mid - 1
            }
            return (1 shl (depth - 1)) - 1 + left
        }

        private fun isValid(mid: Int, node: TreeNode?, curDepth: Int): Boolean {
            if (curDepth == 1) return true
            var isValid = false
            val half = 1 shl (curDepth - 2)
            if (mid <= half) {
                if (node?.left != null) {
                    isValid = isValid(mid, node.left, curDepth - 1)
                }
            } else {
                if (node?.right != null) {
                    isValid = isValid(mid - half, node.right, curDepth - 1)
                }
            }
            return isValid
        }
    }
}