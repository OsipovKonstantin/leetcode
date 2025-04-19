package org.example.java;

import org.example.datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//    easy #breadth-first search (BST)
//    Time complexity is O(n), space complexity is O(n), where n in number of nodes
//    https://leetcode.com/problems/minimum-depth-of-binary-tree
//    Given a binary tree, find its minimum depth.
//    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//    Note: A leaf is a node with no children.
//    Example 1:
//    Input: root = [3,9,20,null,null,15,7]
//    Output: 2
//    Example 2:
//    Input: root = [2,null,3,null,4,null,5,null,6]
//    Output: 5
public class SolutionDay72Third {
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) return depth;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return depth;
    }
}
