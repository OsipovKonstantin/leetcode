package org.example.java;

import org.example.datastructures.TreeNode;

//    easy #binary tree
//    Time complixity is O(n), where n is number of nodes
//    Space complexity is O(h), where h is height of the tree because of stack in recursion
//    https://leetcode.com/problems/same-tree
//    Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
//    Example 1:
//    Input: p = [1,2,3], q = [1,2,3]
//    Output: true
//    Example 2:
//    Input: p = [1,2], q = [1,null,2]
//    Output: false
//    Example 3:
//    Input: p = [1,2,1], q = [1,1,2]
//    Output: false
public class SolutionDay78Third {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if((p==null && q!= null) || (p!=null && q==null)) return false;
        return traverse(p, q);
    }

    private static boolean traverse(TreeNode p, TreeNode q) {
        if((p.left==null && q.left!=null) ||p.left!=null && q.left==null) return false;
        if((p.right==null && q.right!=null)||(p.right!=null&&q.right==null)) return false;
        if(p.val!=q.val) return false;
        boolean ans = true;
        if(p.left!=null) ans = ans && traverse(p.left, q.left);
        if(p.right!=null) ans = ans && traverse(p.right, q.right);
        return ans;
    }
}
