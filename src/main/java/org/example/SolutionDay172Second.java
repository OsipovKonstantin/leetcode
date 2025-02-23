package org.example;

import org.example.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

//    medium #recursion #binary tree #map
//    Time complexity is O(n), where n is the size of preorder array
//    Space complexity is O(n) because of depth of recursion and size of hashmap
//    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
public class SolutionDay172Second {
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int len = postorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(postorder[i], i);
        }
        traverse(root, preorder, postorder, map, len, 0, len - 1, 0, len - 1);
        return root;
    }

    public static void traverse(TreeNode node, int[] preorder, int[] postorder, Map<Integer, Integer> map,
                                int len, int l, int r, int l2, int r2) {
        if (l == r) return;
        int leftVal = preorder[l + 1];
        node.left = new TreeNode(leftVal);
        int leftWidth = map.get(leftVal) - l2;
        traverse(node.left, preorder, postorder, map, len, l + 1, l + 1 + leftWidth, l2, l2 + leftWidth);
        if (l2 == r2) return;
        if (preorder[l + 1] != postorder[r2 - 1]) {
            int rightVal = postorder[r2 - 1];
            node.right = new TreeNode(rightVal);
            traverse(node.right, preorder, postorder, map, len, l + 2 + leftWidth, r, l2 + leftWidth + 1, r2 - 1);
        }
    }
}
