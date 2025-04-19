package org.example.java;

//    easy. Recursion. Binary Tree
//    https://leetcode.com/problems/construct-string-from-binary-tree
//    Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with
//    the preorder traversal way, and return it.
//    Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and
//    the original binary tree.
//    Example 1:
//    Input: root = [1,2,3,4]
//    Output: "1(2(4))(3)"
//    Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty
//    parenthesis pairs. And it will be "1(2(4))(3)"
//    Example 2:
//    Input: root = [1,2,3,null,4]
//    Output: "1(2()(4))(3)"
//    Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the
//    one-to-one mapping relationship between the input and the output.

import org.example.datastructures.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class SolutionDay20Fourth {
    public static String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root != null) {
            res.append(root.val);
        }
        helper(res, root);
        return res.toString();
    }

    public static void helper(StringBuilder res, TreeNode node) {
        if (node.left != null) {
            res.append("(");
            res.append(node.left.val);
            helper(res, node.left);
            res.append(")");
        }
        if (node.left == null && node.right != null) {
            res.append("()");
        }
        if (node.right != null) {
            res.append("(");
            res.append(node.right.val);
            helper(res, node.right);
            res.append(")");
        }
    }
}