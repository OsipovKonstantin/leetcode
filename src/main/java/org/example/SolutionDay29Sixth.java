package org.example;

import java.util.ArrayList;
import java.util.List;

//    easy. Solution saves more space (space complexity O(1)) than if we used hashmap (O(n)).
//     It is possible because tree is ordered (binary search tree). P.S. it is not consider space O(n) for recursion
//     stack
//    https://leetcode.com/problems/find-mode-in-binary-search-tree
//    Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently
//    occurred element) in it.
//    If the tree has more than one mode, return them in any order.
//    Assume a BST is defined as follows:
//    The left subtree of a node contains only nodes with keys less than or equal to the node's key.
//    The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
//    Both the left and right subtrees must also be binary search trees.
//    Example 1:
//    Input: root = [1,null,2,2]
//    Output: [2]
//    Example 2:
//    Input: root = [0]
//    Output: [0]
public class SolutionDay29Sixth {
    private static int currStreak = 0;
    private static int currNumber = Integer.MAX_VALUE;
    private static int maxStreak = 0;
    private static List<Integer> ansList = new ArrayList<>();

    public static int[] findMode(TreeNode root) {
        traverse(root);
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    private static void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        if (currNumber == node.val) {
            currStreak++;
        } else {
            currStreak = 1;
            currNumber = node.val;
        }
        if (maxStreak < currStreak) {
            maxStreak = currStreak;
            ansList = new ArrayList<>();
        }
        if (maxStreak == currStreak) {
            ansList.add(node.val);
        }

        traverse(node.right);
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
