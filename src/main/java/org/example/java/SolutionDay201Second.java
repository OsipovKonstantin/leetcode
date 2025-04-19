package org.example.java;

import org.example.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

//    medium #binary tree (BT) #binary search (BS)
//    Time complexity is O(nlogn), where n is the size of inorder or postorder array
//    Space complexity is O(n)
//    https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
public class SolutionDay201Second {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(postorder[len - 1]);
        traverse(root, -1, len - 2, postorder, inorderMap);
        return root;
    }

    private static void traverse(TreeNode node, int start, int end, int[] postorder, Map<Integer, Integer> inorderMap) {
        if (start > end) return;
        int s = start;
        int val = node.val;
        int nodeIndex = inorderMap.get(val);
        int e = end;
        while (s < e) {
            int mid = e - (e - s) / 2;
            if (inorderMap.get(postorder[mid]) > nodeIndex) e = mid - 1;
            else s = mid;
        }
        if (s > start) {
            node.left = new TreeNode(postorder[s]);
            traverse(node.left, start, s - 1, postorder, inorderMap);
        }
        if (s != end) {
            node.right = new TreeNode(postorder[end]);
            traverse(node.right, s, end - 1, postorder, inorderMap);
        }
    }
}
