package org.example.kotlin

import org.example.datastructures.TreeNode
import java.util.*

//    medium #binary search tree #kotlin
//    Time complexity is O(n), where n is the number of nodes in the binary tree
//    Space complexity is O(h), where h is the maximum height of the binary tree
//    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
class SolutionDay208Second {
    companion object {
        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            val first: Stack<TreeNode> = Stack()
            val second: Stack<TreeNode> = Stack()
            traverse(first, root, p)
            traverse(second, root, q)
            while (first.isNotEmpty() && second.isNotEmpty()) {
                if (first.size > second.size) {
                    first.pop()
                } else if (first.size < second.size) {
                    second.pop()
                } else {
                    val firstNode = first.pop()
                    val secondNode = second.pop()
                    if (firstNode == secondNode) return firstNode
                }
            }
            return null
        }

        private fun traverse(stack: Stack<TreeNode>, node: TreeNode?, cur: TreeNode?): Boolean {
            stack.push(node)
            if (stack.peek() == cur) return true

            if (node?.left != null && traverse(stack, node.left, cur)) return true
            if (node?.right != null && traverse(stack, node.right, cur)) return true

            stack.pop()
            return false
        }
    }
}