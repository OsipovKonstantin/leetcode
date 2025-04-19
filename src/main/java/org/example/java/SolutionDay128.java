package org.example.java;

import org.example.datastructures.TreeNode;

//    medium #binary tree
//    Time complexity is O(n)
//    Space complexity is O(h), where h is depth of binary tree
//    https://leetcode.com/problems/delete-leaves-with-a-given-value
//    Given a binary tree root and an integer target, delete all the leaf nodes with value target.
//    Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value
//    target, it should also be deleted (you need to continue doing that until you cannot).
//    Example 1:
//    Input: root = [1,2,3,2,null,2,4], target = 2
//    Output: [1,null,3,null,4]
//    Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
//    After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
//    Example 2:
//    Input: root = [1,3,3,3,2], target = 3
//    Output: [1,3,null,null,2]
//    Example 3:
//    Input: root = [1,2,null,2,null,2], target = 2
//    Output: [1]
//    Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
public class SolutionDay128 {
    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode dummy = new TreeNode(0, root, null);
        traverse(root, dummy, "left", target);
        return dummy.left;
    }

    private static void traverse(TreeNode node, TreeNode parent, String leftOrRight, int target) {
        if (node.left != null) traverse(node.left, node, "left", target);
        if (node.right != null) traverse(node.right, node, "right", target);
        if (node.left == null && node.right == null && node.val == target) {
            if (leftOrRight.equals("left")) parent.left = null;
            else parent.right = null;
        }
    }
}
