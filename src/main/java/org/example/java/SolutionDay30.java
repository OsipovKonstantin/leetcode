package org.example.java;

import org.example.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

//    easy. #Depth First Search (here - traversing binary tree from left to right). #list1.equals(list2)
//    https://leetcode.com/problems/leaf-similar-trees
//    Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value
//    sequence.
//    For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//    Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//    Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//    Example 1:
//    Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
//    Output: true
//    Example 2:
//    Input: root1 = [1,2,3], root2 = [1,3,2]
//    Output: false
public class SolutionDay30 {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        traverse(root1, leaves1);
        traverse(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private static void traverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traverse(node.left, list);
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        traverse(node.right, list);
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
