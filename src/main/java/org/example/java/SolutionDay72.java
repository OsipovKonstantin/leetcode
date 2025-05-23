package org.example.java;

import org.example.datastructures.TreeNode;

import java.util.*;

//    medium #BFS. We convert tree to graph and then use Breadth-First Search to find elements on k distance from target
//    Time complexity is O(n) where n is number of nodes, space complexity is O(n) due to usage of graph, q and seen
//    https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree
//    Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the
//    values of all nodes that have a distance k from the target node.
//    You can return the answer in any order.
//    Example 1:
//    Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//    Output: [7,4,1]
//    Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
//    Example 2:
//    Input: root = [1], target = 1, k = 3
//    Output: []
public class SolutionDay72 {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(root.val, new ArrayList<>());
        traverse(root, graph);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.offer(target.val);
        int counter = 0;
        while (!q.isEmpty() && counter != k) {
            counter++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                seen.add(cur);
                for (int adj : graph.get(cur)) {
                    if (!seen.contains(adj)) {
                        q.offer(adj);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }

    private static void traverse(TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (parent == null) return;
        int parentVal = parent.val;
        if (parent.left != null) {
            int leftVal = parent.left.val;
            graph.computeIfAbsent(leftVal, key -> new ArrayList<>()).add(parentVal);
            graph.computeIfAbsent(parentVal, key -> new ArrayList<>()).add(leftVal);
            traverse(parent.left, graph);
        }
        if (parent.right != null) {
            int rightVal = parent.right.val;
            graph.computeIfAbsent(rightVal, key -> new ArrayList<>()).add(parentVal);
            graph.computeIfAbsent(parentVal, key -> new ArrayList<>()).add(rightVal);
            traverse(parent.right, graph);
        }
    }
}
