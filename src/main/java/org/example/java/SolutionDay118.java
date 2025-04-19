package org.example.java;

import org.example.datastructures.TreeNode;

//    medium #tree
//    Time complexity is O(n), where n is number of nodes in tree
//    Space complexity is O(10), where 10 is depth of tree based on task constraints.
//    In recursion we store at most 10 elements
//    https://leetcode.com/problems/sum-root-to-leaf-numbers
//    You are given the root of a binary tree containing digits from 0 to 9 only.
//    Each root-to-leaf path in the tree represents a number.
//    For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//    Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in
//    a 32-bit integer.
//    A leaf node is a node with no children.
//    Example 1:
//    Input: root = [1,2,3]
//    Output: 25
//    Explanation:
//    The root-to-leaf path 1->2 represents the number 12.
//    The root-to-leaf path 1->3 represents the number 13.
//    Therefore, sum = 12 + 13 = 25.
//    Example 2:
//    Input: root = [4,9,0,5,1]
//    Output: 1026
//    Explanation:
//    The root-to-leaf path 4->9->5 represents the number 495.
//    The root-to-leaf path 4->9->1 represents the number 491.
//    The root-to-leaf path 4->0 represents the number 40.
//    Therefore, sum = 495 + 491 + 40 = 1026.
public class SolutionDay118 {
    static int ans;

    public static int sumNumbers(TreeNode root) {
        ans = 0;
        traverse(root, root.val);
        return ans;
    }

    public static void traverse(TreeNode node, int val) {
        if (node.left == null && node.right == null) {
            ans += val;
            return;
        }
        if (node.left != null) traverse(node.left, val * 10 + node.left.val);
        if (node.right != null) traverse(node.right, val * 10 + node.right.val);
    }
}
