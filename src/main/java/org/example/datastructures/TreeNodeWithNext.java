package org.example.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeWithNext {
    public int val;
    public TreeNodeWithNext left;
    public TreeNodeWithNext right;
    public TreeNodeWithNext next;

    public TreeNodeWithNext() {
    }

    public TreeNodeWithNext(int _val) {
        val = _val;
    }

    public TreeNodeWithNext(int _val, TreeNodeWithNext _left, TreeNodeWithNext _right, TreeNodeWithNext _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public List<String> asList() {
        List<String> list = new ArrayList<>();
        Queue<TreeNodeWithNext> q = new LinkedList<>();
        q.offer(new TreeNodeWithNext(val, left, right, next));
        while (!q.isEmpty()) {
            TreeNodeWithNext cur = q.poll();
            if (cur != null) {
                list.add(String.valueOf(cur.val));
                if (cur.left != null || cur.right != null) {
                    q.add(cur.left);
                    q.add(cur.right);
                }
                if(cur.next==null) list.add("#");
            }
        }
        return list;
    }
};
