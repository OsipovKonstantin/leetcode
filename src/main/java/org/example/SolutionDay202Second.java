package org.example;

import org.example.datastructures.TreeNodeWithNext;

//    medium #binary tree with next
//    Time complexity is O(n), where n is the number of nodes
//    Space complexity is O(1)
//    https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
public class SolutionDay202Second {
    public static TreeNodeWithNext connect(TreeNodeWithNext root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNodeWithNext cur = root;
        TreeNodeWithNext firstDeeper = null;
        TreeNodeWithNext curDeeper = null;
        while (cur != null) { //проходимся слева направо
            if (firstDeeper == null) {
                if (cur.left != null) {
                    firstDeeper = cur.left;
                    curDeeper = cur.left;
                }
                if (cur.right != null) {
                    if (firstDeeper == null) {
                        firstDeeper = cur.right;
                        curDeeper = cur.right;
                    } else {
                        curDeeper.next = cur.right;
                        curDeeper = curDeeper.next;
                    }
                }
            } else {
                if (cur.left != null && cur.left != curDeeper) {
                    curDeeper.next = cur.left;
                    curDeeper = curDeeper.next;
                }
                if (cur.right != null) {
                    curDeeper.next = cur.right;
                    curDeeper = curDeeper.next;
                }
            }
            cur = cur.next;
            if (cur == null) {
                cur = firstDeeper;
                firstDeeper = null;
                curDeeper = null;
            }
        }
        return root;
    }
}
