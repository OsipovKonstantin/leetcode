package org.example

import org.example.datastructures.TreeNode
import java.util.*

//    medium #breadth-first search #kotlin
//    Time complexity is O(n), where n is the number of nodes in the binary tree
//    Space complexity is O(n)
//    https://leetcode.com/problems/binary-tree-level-order-traversal
class SolutionDay211Second {
    companion object {
        fun levelOrder(root: TreeNode?): List<List<Int>> {
            if (root == null) return emptyList()
            val ans = mutableListOf<List<Int>>()
            val q: Queue<TreeNode> = LinkedList()
            q.offer(root)
            while (q.isNotEmpty()) {
                val size = q.size
                val curLevel = mutableListOf<Int>()
                for (i in 0 until size) {
                    val cur = q.poll()
                    curLevel.add(cur.`val`)
                    cur.left?.let { q.offer(it) }
                    cur.right?.let { q.offer(it) }
                }
                ans.add(curLevel)
            }
            return ans
        }
    }
}