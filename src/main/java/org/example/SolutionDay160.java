package org.example;

import org.example.datastructures.TreeNode;

//    medium #binary tree
//    Time complexity is O(n)
//    Space complexity is O(h), where h is height of binary tree
//    https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
//    Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original
//    BST is changed to the original key plus the sum of all keys greater than the original key in BST.
//    As a reminder, a binary search tree is a tree that satisfies these constraints:
//    The left subtree of a node contains only nodes with keys less than the node's key.
//    The right subtree of a node contains only nodes with keys greater than the node's key.
//    Both the left and right subtrees must also be binary search trees.
//    Example 1:
//    Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//    Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
//    Example 2:
//    Input: root = [0,null,1]
//    Output: [1,null,1]
public class SolutionDay160 {
    private static int sum = 0;

    public static TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    private static void traverse(TreeNode node) {
        if (node.right != null) traverse(node.right);
        sum += node.val;
        node.val = sum;
        if (node.left != null) traverse(node.left);
    }
}
