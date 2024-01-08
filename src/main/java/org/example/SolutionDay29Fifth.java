package org.example;

//    medium. traversing binary tree and tracking number of nodes and sum of them.
//     int[] with 2 elements seems faster than Pair<Integer,Integer>
//    https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree
//    Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average
//    of the values in its subtree.
//    Note:
//    The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
//    A subtree of root is a tree consisting of root and all of its descendants.
//    Example 1:
//    Input: root = [4,8,5,0,1,null,6]
//    Output: 5
//    Explanation:
//    For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
//    For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
//    For the node with value 0: The average of its subtree is 0 / 1 = 0.
//    For the node with value 1: The average of its subtree is 1 / 1 = 1.
//    For the node with value 6: The average of its subtree is 6 / 1 = 6.
//    Example 2:
//    Input: root = [1]
//    Output: 1
//    Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
public class SolutionDay29Fifth {
    private static int ans = 0;

    public static int averageOfSubtree(TreeNode root) {
        traverse(root);
        return ans;
    }

    private static int[] traverse(TreeNode node) {
        if (node == null) {
            //key - sum, value - number of nodes in subtree
            return new int[]{0, 0};
        }
        int[] leftPair = traverse(node.left);
        int[] rightPair = traverse(node.right);
        int counter = leftPair[1] + rightPair[1] + 1;
        int sum = leftPair[0] + rightPair[0] + node.val;
        if (sum / counter == node.val) {
            ans++;
        }
        return new int[]{sum, counter};
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