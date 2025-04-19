package org.example.java;

import org.example.datastructures.TreeNode;

//    medium #bitmask (used for numbers less than 32 (int) or 64 (long)) #recursive preorder traversal of a binary tree
//    Idea behind a bitmask is to convert a small number to 2^number (or 1 << number) to store in one variable bitMask
//    array of numbers. Here we store occurrence of digits in bitMask. If the occurrence is even we delete this number
//    from bitMask. At the end of the day we count odd occurrences of numbers and when there are 1 or fewer odd
//    occurrences we have pseudo palindromic (definition from task) sequence of digits. Using a bitmask instead of an
//    array of digits (int[10]) has 10 times lower time complexity, beating 90% of LeetCode solutions
//    https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree
//    Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be
//    pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
//    Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
//    Example 1:
//    Input: root = [2,3,1,3,1,null,1]
//    Output: 2
//    Explanation: The figure above represents the given binary tree. There are three paths going from the root node
//    to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red
//    path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3]
//    (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
//    Example 2:
//    Input: root = [2,1,1,1,3,null,null,null,null,null,1]
//    Output: 1
//    Explanation: The figure above represents the given binary tree. There are three paths going from the root node
//    to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green
//    path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
//    Example 3:
//    Input: root = [9]
//    Output: 1
public class SolutionDay45 {
    public static int pseudoPalindromicPaths(TreeNode root) {
        return traverse(root, 0);
    }

    private static int traverse(TreeNode node, int bitMask) {
        bitMask = (bitMask & (1 << node.val)) == 0 ? bitMask + (1 << node.val) : bitMask - (1 << node.val);
        if (node.left == null && node.right == null && Integer.bitCount(bitMask) <= 1) {
            return 1;
        }
        int sum = 0;
        if (node.left != null) {
            sum += traverse(node.left, bitMask);
        }
        if (node.right != null) {
            sum += traverse(node.right, bitMask);
        }

        return sum;
    }
}
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
