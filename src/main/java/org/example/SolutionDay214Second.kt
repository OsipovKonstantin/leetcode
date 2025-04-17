package org.example

import org.example.datastructures.TreeNode

//    medium #binary tree #recursion #kotlin
//    Time complexity is O(n), where n is the number of nodes in the binary tree
//    Space complexity is O(h), where h is the height of the binary tree
//    https://leetcode.com/problems/validate-binary-search-tree
class SolutionDay214Second {
    companion object {
        fun isValidBST(root: TreeNode?): Boolean {
            return traverse(root!!, Long.MIN_VALUE, Long.MAX_VALUE)
        }

        private fun traverse(node: TreeNode, min: Long, max: Long): Boolean {
            val curVal = node.`val`.toLong()
            if (curVal <= min || curVal >= max) return false
            var isValid = true
            node.left?.let { isValid = isValid && traverse(it, min, curVal) }
            node.right?.let { isValid = isValid && traverse(it, curVal, max) }
            return isValid
        }
    }
}