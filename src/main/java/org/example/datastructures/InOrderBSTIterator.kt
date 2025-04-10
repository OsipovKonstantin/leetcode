package org.example.datastructures

import java.util.*

//    medium #design #binary search tree #kotlin
//    Time complexity is O(h) for initialization and O(1) for operations next() and hasNext()
//    Space complexity is O(h), where h is the height of the binary tree
//    https://leetcode.com/problems/binary-search-tree-iterator
class InOrderBSTIterator(root: TreeNode?) {
    private val stack: Stack<TreeNode> = Stack()

    init {
        var cur = root
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }

    fun next(): Int {
        var temp = stack.pop()
        val value = temp.`val`
        if (temp.right != null) {
            temp = temp.right
            while (temp != null) {
                stack.push(temp)
                temp = temp.left
            }
        }
        return value
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }
}
