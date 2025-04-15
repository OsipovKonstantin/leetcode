package org.example

import org.example.datastructures.TreeNode
import java.util.*

//    medium # binary tree #breadth-first search #kotlin
//    Time complexity is O(n), where n is the number of nodes in the binary tree
//    Space complexity is O(n)
//    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
class SolutionDay212 {
    companion object {
        fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
            if (root == null) return emptyList()
            val ans = mutableListOf<List<Int>>()
            val q: Queue<TreeNode> = LinkedList()
            q.offer(root)
            var depth = 1
            while (q.isNotEmpty()) {
                val size = q.size
                val list = mutableListOf<Int>()
                for (i in 0 until size) {
                    val cur = q.poll()
                    list.add(cur.`val`)
                    cur.left?.let { q.offer(it) }
                    cur.right?.let { q.offer(it) }
                }
                if (depth % 2 == 0) list.reverse()
                ans.add(list)
                depth++
            }
            return ans
        }
    }
}