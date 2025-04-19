package org.example.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//    medium #BST (breadth first search) #DST (depth first search). Here is BST. No matter how we traverse children.
//    So to make DST we only need to substitute queue with stack, offer with push, poll with pop. That's it
//    https://leetcode.com/problems/validate-binary-tree-nodes
//    You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and
//    rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
//    If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
//    Note that the nodes have no values and that we only use the node numbers in this problem.
//    Example 1:
//    Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
//    Output: true
//    Example 2:
//    Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
//    Output: false
//    Example 3:
//    Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
//    Output: false
public class SolutionDay35Third {
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        Set<Integer> visited = new HashSet<>();
        visited.add(root);
        while (!q.isEmpty()) {
            int node = q.poll();
            int[] children = new int[]{leftChild[node], rightChild[node]};
            for (int child : children) {
                if (child != -1) {
                    if (visited.contains(child)) {
                        return false;
                    }
                    q.offer(child);
                    visited.add(child);
                }
            }
        }
        return visited.size() == n;
    }

    private static int findRoot(int n, int[] left, int[] right) {
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < left.length; i++) {
            nodes.add(left[i]);
            nodes.add(right[i]);
        }
        if (nodes.size() != n) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if (!nodes.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
