package org.example;

import org.example.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    medium #dynamic programming. Recursive approach with memoization. Time complexity is O(2^(n/2)),
//    space complexity is O(n*2^(n/2)), because number of subproblems with n nodes is 2^(n/2).
//    For example 7 nodes has 5 configurations, each configuration store 7 nodes. Overall 35 nodes stored for n = 7
//    https://leetcode.com/problems/all-possible-full-binary-trees
//    Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the
//    answer must have Node.val == 0.
//    Each element of the answer is the root node of one possible tree. You may return the final list of trees in any
//    order.
//    A full binary tree is a binary tree where each node has exactly 0 or 2 children.
//    Example 1:
//    Input: n = 7
//    Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],
//    [0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//    Example 2:
//    Input: n = 3
//    Output: [[0,0,0]]
public class SolutionDay66 {
    public static List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>();
        Map<Integer, List<TreeNode>> memo = new HashMap<>();
        memo.put(0, new ArrayList<>());
        memo.computeIfAbsent(1, key -> new ArrayList<>()).add(new TreeNode(0));
        return traverse(memo, n);
    }

    private static List<TreeNode> traverse(Map<Integer, List<TreeNode>> memo, int n) {
        if (memo.containsKey(n)) return memo.get(n);
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftNodes = traverse(memo, i);
            List<TreeNode> rightNodes = traverse(memo, n - 1 - i);
            for (TreeNode left : leftNodes)
                for (TreeNode right : rightNodes)
                    res.add(new TreeNode(0, left, right));
        }
        memo.put(n, res);
        return res;
    }
}
