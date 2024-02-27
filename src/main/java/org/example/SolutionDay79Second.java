package org.example;

import org.example.datastructures.TreeNode;

//    easy #binary tree #recursion
//    Time complexity is O(n), space complexity is O(n), where n is number of nodes
//    https://leetcode.com/problems/diameter-of-binary-tree
//    Given the root of a binary tree, return the length of the diameter of the tree.
//    The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
//    This path may or may not pass through the root.
//    The length of a path between two nodes is represented by the number of edges between them.
//    Example 1:
//    Input: root = [1,2,3,4,5]
//    Output: 3
//    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
//    Example 2:
//    Input: root = [1,2]
//    Output: 1
public class SolutionDay79Second {
    private static int ans;

    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        traverse(root);
        return ans;
    }

    private static int traverse(TreeNode node) {
        if (node == null) return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        ans = Math.max(ans, left + right);
        return 1 + Math.max(left, right);
    }
}
