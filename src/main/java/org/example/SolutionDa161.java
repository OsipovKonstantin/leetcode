package org.example;

import org.example.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

//    medium #binary search tree (balanced binary search tree like a Red-Black Tree)
//    Time complexity is O(n)
//    Space complexity is O(n) because of height of initial and final tree and length of ordered array of ints
//    https://leetcode.com/problems/balance-a-binary-search-tree
//    Given the root of a binary search tree, return a balanced binary search tree with the same node values.
//    If there is more than one answer, return any of them.
//    A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
//    Example 1:
//    Input: root = [1,null,2,null,3,null,4,null,null]
//    Output: [2,1,3,null,null,null,4]
//    Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
//    Example 2:
//    Input: root = [2,1,3]
//    Output: [2,1,3]
public class SolutionDa161 {
    private static List<Integer> ordered = new ArrayList<>();
    private static TreeNode balancedRoot;

    public static TreeNode balanceBST(TreeNode root) {
        decompose(root);

        int mid = ordered.size() / 2;
        balancedRoot = new TreeNode(ordered.get(mid));
        balance(balancedRoot, 0, mid - 1, mid + 1, ordered.size() - 1);
        return balancedRoot;
    }

    private static void balance(TreeNode parent, int startLeft, int endLeft, int startRight, int endRight) {
        if (startLeft <= endLeft) {
            parent.left = new TreeNode(ordered.get((endLeft + startLeft) / 2));
            balance(parent.left, startLeft, (endLeft + startLeft) / 2 - 1, (endLeft + startLeft)
                    / 2 + 1, endLeft);
        }
        if (startRight <= endRight) {
            parent.right = new TreeNode(ordered.get((endRight + startRight) / 2));
            balance(parent.right, startRight, (endRight + startRight) / 2 - 1, (endRight + startRight)
                    / 2 + 1, endRight);
        }
    }

    private static void decompose(TreeNode node) {
        if (node.left != null) decompose(node.left);
        ordered.add(node.val);
        if (node.right != null) decompose(node.right);
    }
}
