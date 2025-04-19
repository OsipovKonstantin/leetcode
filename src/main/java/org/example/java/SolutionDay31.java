package org.example.java;

import org.example.datastructures.TreeNode;

import java.util.*;

//    medium. #Binary tree; #traversion with saving parent. 2 maps first is value: currNode, second is value: parentNode
//    Or 1 map (graph) with value: adjacent values.
//    https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected
//    You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts
//    from the node with value start.
//    Each minute, a node becomes infected if:
//    The node is currently uninfected.
//    The node is adjacent to an infected node.
//    Return the number of minutes needed for the entire tree to be infected.
//    Example 1:
//    Input: root = [1,5,3,null,4,10,6,9,2], start = 3
//    Output: 4
//    Explanation: The following nodes are infected during:
//    - Minute 0: Node 3
//    - Minute 1: Nodes 1, 10 and 6
//    - Minute 2: Node 5
//    - Minute 3: Node 4
//    - Minute 4: Nodes 9 and 2
//    It takes 4 minutes for the whole tree to be infected so we return 4.
//    Example 2:
//    Input: root = [1], start = 1
//    Output: 0
//    Explanation: At minute 0, the only node in the tree is infected so we return 0.
public class SolutionDay31 {
    public static int amountOfTime(TreeNode root, int start) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        convert(root, map, parentMap);
        int steps = -1;
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        visited.add(start);
        q.offer(map.get(start));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode ill = q.poll();
                TreeNode p = parentMap.get(ill.val);
                if (p != null && !visited.contains(p.val)) {
                    visited.add(parentMap.get(ill.val).val);
                    q.offer(parentMap.get(ill.val));
                }
                if (ill.left != null && !visited.contains(ill.left.val)) {
                    visited.add(ill.left.val);
                    q.offer(map.get(ill.left.val));
                }
                if (ill.right != null && !visited.contains(ill.right.val)) {
                    visited.add(ill.right.val);
                    q.offer(map.get(ill.right.val));
                }
            }
            steps++;
        }
        return steps;
    }

    private static void convert(TreeNode node, Map<Integer, TreeNode> map, Map<Integer, TreeNode> parentMap) {
        if (node == null) {
            return;
        }
        map.put(node.val, node);
        if (node.left != null) {
            parentMap.put(node.left.val, node);
        }
        if (node.right != null) {
            parentMap.put(node.right.val, node);
        }
        convert(node.left, map, parentMap);
        convert(node.right, map, parentMap);
    }
}
