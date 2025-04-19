package org.example.java;

import org.example.datastructures.TreeNode;

import java.util.HashSet;
import java.util.Set;

//    medium #binary tree
//    Time complexity is O(n), where n is the number of elements in tree
//    Space complexity is O(n), because size of set is equal to number of elements in tree
public class SolutionDay170 {
    Set<Integer> unique = new HashSet<>();

    public SolutionDay170(TreeNode root) {
        traverse(root, 0, unique);
    }

    public boolean find(int target) {
        return unique.contains(target);
    }

    private void traverse(TreeNode node, int currentValue, Set<Integer> unique) {
        if (node != null) {
            unique.add(currentValue);
            if (node.left != null) traverse(node.left, currentValue * 2 + 1, unique);
            if (node.right != null) traverse(node.right, currentValue * 2 + 2, unique);
        }
    }
}
