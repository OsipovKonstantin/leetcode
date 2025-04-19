package org.example.java;

import org.example.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

//    medium. #binary tree (saving depth of current level as parameter of recursion method.
//    Here we place parameter row in method traverse)
//    saving result at once in arraylist is faster than hashmap and then in arraylist
//    https://leetcode.com/problems/find-largest-value-in-each-tree-row
//    Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
//    Example 1:
//    Input: root = [1,3,2,5,3,null,9]
//    Output: [1,3,9]
//    Example 2:
//    Input: root = [1,2,3]
//    Output: [1,3]
public class SolutionDay33Third {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, 0, ans);
        return ans;
    }

    private static void traverse(TreeNode node, int row, List<Integer> list) {
        if (node == null) {
            return;
        }
        int value = node.val;
        if (list.size() < row + 1) {
            list.add(value);
        }
        if (list.get(row) < value) {
            list.set(row, value);
        }
        traverse(node.left, row + 1, list);
        traverse(node.right, row + 1, list);
    }
}