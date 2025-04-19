package org.example.kotlin

import org.example.datastructures.TreeNode
import java.util.*

//medium #binary search tree #kotlin
//Time complexity is O(n), where n is the number of nodes in the binary tree
//Space complexity is O(n) due to the queue that stores the nodes of the binary tree for each depth
class SolutionDay209Second {
    companion object {
        fun rightSideView(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()
            val ans = mutableListOf<Int>()
            val q: Queue<TreeNode> = LinkedList()
            q.offer(root)
            while (q.isNotEmpty()) {
                val size = q.size
                for (i in 0 until size) {
                    val cur = q.poll()
                    if (i == size - 1) {
                        ans.add(cur.`val`)
                    }
                    cur.left?.let { q.offer(it) }
                    cur.right?.let { q.offer(it) }
                }
            }
            return ans
        }
    }
}