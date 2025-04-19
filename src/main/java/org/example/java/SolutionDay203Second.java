package org.example.java;

import org.example.datastructures.TreeNode;

//    medium #binary tree
//    Time complexity is O(n), where n is the number of nodes in tree
//    Space complexity is O(n) due to height of tree
//    https://leetcode.com/problems/flatten-binary-tree-to-linked-list
public class SolutionDay203Second {
    public static void flatten(TreeNode root) {
        if (root == null) return;
        traverse(root);
    }

    private static TreeNode traverse(TreeNode node) {
        TreeNode last = node;
        TreeNode temp = null;
        if (node.right != null) {
            temp = node.right;
        }
        if (node.left != null) {
            last = traverse(node.left);
            node.right = node.left;
            node.left = null;
            last.right = temp;
        }
        if (temp != null) last = traverse(temp);
        return last;
    }
}
