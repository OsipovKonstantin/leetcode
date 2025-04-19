package org.example.java;

import org.example.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//    easy. Stack instead of recursion
//    https://leetcode.com/problems/binary-tree-inorder-traversal
//    Given the root of a binary tree, return the inorder traversal of its nodes' values.
//    Example 1:
//    Input: root = [1,null,2,3]
//    Output: [1,3,2]
//    Example 2:
//    Input: root = []
//    Output: []
//    Example 3:
//    Input: root = [1]
//    Output: [1]
public class SolutionDay20Third {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}

//Definition for a binary tree node.
