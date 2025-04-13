package org.example

import org.example.datastructures.TreeNode
import java.util.*

//    easy #breadth-first search #kotlin
//    Time complexity is O(n)
//    Space complexity is O(n)
//    https://leetcode.com/problems/average-of-levels-in-binary-tree
class SolutionDay210Second {
    companion object {
        fun averageOfLevels(root: TreeNode?): DoubleArray {
            val ans = mutableListOf<Double>()
            val q: Queue<TreeNode> = LinkedList()
            q.offer(root)
            while (q.isNotEmpty()) {
                val size = q.size
                var sum = 0L
                for (i in 0 until size) {
                    val cur = q.poll()
                    sum += cur.`val`
                    cur.left?.let { q.offer(it) }
                    cur.right?.let { q.offer(it) }
                }
                ans.add(sum.toDouble() / size);
            }
            return ans.toDoubleArray()
        }
    }
}