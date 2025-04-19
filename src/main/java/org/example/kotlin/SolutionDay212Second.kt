package org.example.kotlin

import org.example.datastructures.TreeNode

//    easy #binary search tree #recursion #kotlin
//    Time complexity is O(n), where n is the number of node in the binary search tree
//    Space complexity is O(h), where h is the height of the binary search tree
//    https://leetcode.com/problems/minimum-absolute-difference-in-bst
class SolutionDay212Second {
    companion object {
        fun getMinimumDifference(root: TreeNode?): Int {
            return traverse(Int.MIN_VALUE / 2, Int.MAX_VALUE / 2, root!!);
        }

        private fun traverse(min: Int, max: Int, node: TreeNode): Int {
            val valNode = node.`val`
            var ans = minOf(max - valNode, valNode - min);
            node.left?.let { ans = minOf(ans, traverse(min, valNode, node.left)) }
            node.right?.let { ans = minOf(ans, traverse(valNode, max, node.right)) }
            return ans
        }
    }
}