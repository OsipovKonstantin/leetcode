package org.example;

import com.github.javaparser.utils.Pair;
import org.example.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    medium #dynamic programming. Brilliant usage of recursion in two for-each loops
//    https://leetcode.com/problems/unique-binary-search-trees-ii
//    Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of
//    unique values from 1 to n. Return the answer in any order.
//    Example 1:
//    Input: n = 3
//    Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
//    Example 2:
//    Input: n = 1
//    Output: [[1]]
public class SolutionDay59Fourth {
    private static Map<Pair<Integer, Integer>, List<TreeNode>> memo;

    public static List<TreeNode> generateTrees(int n) {
        memo = new HashMap<>();
        return generate(1, n);
    }

    private static List<TreeNode> generate(int left, int right) {
        if (left > right) {
            List<TreeNode> nullList = new ArrayList<>();
            nullList.add(null);
            return nullList;
        }
        Pair<Integer, Integer> pair = new Pair(left, right);
        if (memo.containsKey(pair)) return memo.get(pair);

        List<TreeNode> ans = new ArrayList<>();
        for (int val = left; val < right + 1; val++)
            for (TreeNode l : generate(left, val - 1))
                for (TreeNode r : generate(val + 1, right))
                    ans.add(new TreeNode(val, l, r));
        memo.put(pair, ans);
        return ans;
    }
}
