package org.example.java;

import org.example.datastructures.TreeNode;

//    easy #binary tree
//    Time complexity is O(n)
//    Space complexity is O(n) due to the maximum height of the tree
//    https://leetcode.com/problems/maximum-depth-of-binary-tree
public class SolutionDay197Second {
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return traverse(root, 1);
    }

    private static int traverse(TreeNode root, int curDepth) {
        int depth = curDepth;
        if (root.left != null) depth = Math.max(depth, traverse(root.left, curDepth + 1));
        if (root.right != null) depth = Math.max(depth, traverse(root.right, curDepth + 1));
        return depth;
    }
}
