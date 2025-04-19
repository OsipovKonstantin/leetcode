package org.example.java;


import org.example.datastructures.TreeNode;

public class SolutionDay199Second {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return traverse(root, root);
    }

    private static boolean traverse(TreeNode left, TreeNode right) {
        if (left.val != right.val) return false;
        if ((left.left != null && right.right == null) || (left.left == null && right.right != null)
                || (left.right != null && right.left == null) || (left.right == null && right.left != null))
            return false;
        return (left.left == null || traverse(left.left, right.right))
                && (left.right == null || traverse(left.right, right.left));
    }
}
