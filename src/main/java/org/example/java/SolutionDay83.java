package org.example.java;

import org.example.datastructures.ListNode;

import java.util.ArrayList;
import java.util.List;

//    medium #linked list
//    Time complexity is O(n), where n is number of nodes, space complexity is O(n)
//    https://leetcode.com/problems/remove-nth-node-from-end-of-list
//    Given the head of a linked list, remove the nth node from the end of the list and return its head.
//    Example 1:
//    Input: head = [1,2,3,4,5], n = 2
//    Output: [1,2,3,5]
//    Example 2:
//    Input: head = [1], n = 1
//    Output: []
//    Example 3:
//    Input: head = [1,2], n = 1
//    Output: [1]
public class SolutionDay83 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = new ListNode(0, head);
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        cur = nodes.get(nodes.size() - n - 1);
        cur.next = cur.next.next;
        return nodes.get(0).next;
    }
}
