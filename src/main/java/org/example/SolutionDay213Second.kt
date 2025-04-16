package org.example

import org.example.datastructures.TreeNode

//    medium #binary search tree #depth-first search (inorder traversal) #kolin
//    Time complexity is O(n), where n is the number of nodes in the binary search tree
//    Space complexity is O(h), where h is the height of the binary search tree
//    https://leetcode.com/problems/kth-smallest-element-in-a-bst
class SolutionDay213Second {
    companion object {
        fun kthSmallest(root: TreeNode?, k: Int): Int {
            val ans = arrayOfNulls<TreeNode>(1)
            traverse(root, k, 0, ans);
            return ans[0]!!.`val`
        }

        private fun traverse(node: TreeNode?, k: Int, count: Int, ans: Array<TreeNode?>): Int {
            if (count >= k) return count;
            var varCount = count
            node?.let {
                node.left?.let { varCount = traverse(node.left, k, varCount, ans) }
                varCount++
                if (varCount == k) ans[0] = node;
                node.right?.let { varCount = traverse(node.right, k, varCount, ans) }
            }
            return varCount
        }
    }
}