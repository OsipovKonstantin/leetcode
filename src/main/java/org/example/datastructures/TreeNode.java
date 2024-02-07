package org.example.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<Integer> asList() {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(new TreeNode(val, left, right));
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur != null) {
                list.add(cur.val);
                if (cur.left != null || cur.right != null) {
                    q.add(cur.left);
                    q.add(cur.right);
                }
            } else if (!q.isEmpty()) list.add(null);
        }
        return list;
    }
}