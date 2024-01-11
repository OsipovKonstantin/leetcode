package org.example;

//    medium. #binary tree. This solution has O(n) time complexity meanwhile one with hashmap outside recursion O(n^2)
//    https://leetcode.com/problems/maximum-difference-between-node-and-ancestor
//    Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where
//    v = |a.val - b.val| and a is an ancestor of b.
//    A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
//    Example 1:
//    Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
//    Output: 7
//    Explanation: We have various ancestor-node differences, some of which are given below :
//    |8 - 3| = 5
//    |3 - 7| = 4
//    |8 - 1| = 7
//    |10 - 13| = 3
//    Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
//    Example 2:
//    Input: root = [1,null,2,null,0,3]
//    Output: 3
public class SolutionDay32 {
    public static int maxAncestorDiff(TreeNode root) {
        return traverse(root, root.val, root.val);
    }

    private static int traverse(TreeNode node, int min, int max) {
        if (node == null) {
            return 0;
        }
        int curr = node.val;
        int currDiff = Math.max(Math.abs(curr - min), Math.abs(curr - max));
        int leftDiff = traverse(node.left, Math.min(min, curr), Math.max(max, curr));
        int rightDiff = traverse(node.right, Math.min(min, curr), Math.max(max, curr));
        return Math.max(currDiff, Math.max(leftDiff, rightDiff));
    }
}