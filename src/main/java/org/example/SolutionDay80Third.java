package org.example;

import org.example.datastructures.TreeNode;

//    medium #binary tree #recurcion
//    Time complexity is O(n), where n is the number of nodes. Space complexity is O(n) due to the stack (recursion)
//    https://leetcode.com/problems/find-bottom-left-tree-value
//    Given the root of a binary tree, return the leftmost value in the last row of the tree.
//    Example 1:
//    Input: root = [2,1,3]
//    Output: 1
//    Example 2:
//    Input: root = [1,2,3,4,null,5,6,null,null,7]
//    Output: 7
public class SolutionDay80Third {
    private static int ans = 0;
    private static int maxDepth = -1;

    public static int findBottomLeftValue(TreeNode root) {
        traverse(root, 0);
        return ans;
    }

    private static void traverse(TreeNode node, int curDepth) {
        if (node.left == null && node.right == null) {
            if (maxDepth < curDepth) {
                ans = node.val;
                maxDepth = curDepth;
            }
            return;
        }
        if (node.left != null) traverse(node.left, curDepth + 1);
        if (node.right != null) traverse(node.right, curDepth + 1);
    }
}
