package org.example;

import org.example.datastructures.TreeNode;

//    medium #binary tree (BT) #binary search (BS)
//    Time complexity is O(nlogn), where n is the size of preorder or inorder
//    Space complexity is O(n) due to the maximum depth of the reconstructed tree
//    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class SolutionDay200Second {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        if (len == 1) return root;
        int[] inorderIndex = new int[3000 * 2 + 1];
        for (int i = 0; i < len; i++) {
            inorderIndex[inorder[i] + 3000] = i;
        }
        traverse(root, 1, len, inorderIndex, preorder);
        return root;
    }

    private static void traverse(TreeNode node, int start, int end, int[] inorderIndex, int[] preorder) {
        int nodeIndex = inorderIndex[node.val + 3000];
        int s = start;
        int e = end;
        while (s < e) {
            int mid = (s + e) / 2;
            if (inorderIndex[preorder[mid] + 3000] <= nodeIndex) s = mid + 1;
            else e = mid;
        }
        if (s != start) {
            node.left = new TreeNode(preorder[start]);
            traverse(node.left, start + 1, s, inorderIndex, preorder);
        }
        if (s < end) {
            node.right = new TreeNode(preorder[s]);
            traverse(node.right, s + 1, end, inorderIndex, preorder);
        }
    }
}
