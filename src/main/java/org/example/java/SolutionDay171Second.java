package org.example.java;

import org.example.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

//    hard #binary tree #counting #map
//    Time complexity is O(n), where n is the length of traversal string
//    Space complexity is O(n), because of size of array of chars and map which size is the depth tree
//    https://leetcode.com/problems/recover-a-tree-from-preorder-traversal
public class SolutionDay171Second {
    public static TreeNode recoverFromPreorder(String traversal) {
        int r = 0;
        int number = 0;
        char[] cs = traversal.toCharArray();
        int len = cs.length;
        while (r < len && isDigit(cs[r])) {
            number *= 10;
            number += cs[r] - '0';
            r++;
        }
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(0, new TreeNode(number));

        int counter;
        while (r < len) {
            counter = 0;
            while (r < len && cs[r] == '-') {
                counter += 1;
                r++;
            }
            number = 0;
            while (r < len && isDigit(cs[r])) {
                number *= 10;
                number += cs[r] - '0';
                r++;
            }
            TreeNode parent = map.get(counter - 1);
            if (parent.left == null) {
                parent.left = new TreeNode(number);
                map.put(counter, parent.left);
            } else if (parent.right == null) {
                parent.right = new TreeNode(number);
                map.put(counter, parent.right);
            } //else - for case if there are left and right children
        }
        return map.get(0);
    }

    private static boolean isDigit(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }
}
