package org.example;

import org.example.datastructures.TreeNode;

//    easy #binary tree
//    Time complexity is O(n), where n is the number of nodes in the tree
//    Space complexity is O(n) due to the maximum height of the tree
//    https://leetcode.com/problems/invert-binary-tree
public class SolutionDay198Second {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        traverse(root);
        return root;
    }

    private static void traverse(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) traverse(root.left);
        if (root.right != null) traverse(root.right);
    }
}
