package org.example.java;

import org.example.datastructures.ListNode;

//    easy #linkedlist
//    Time complexity is O(n)
//    Space complexity is O(1)
//    https://leetcode.com/problems/reverse-linked-list
//    Given the head of a singly linked list, reverse the list, and return the reversed list.
//    Example 1:
//    Input: head = [1,2,3,4,5]
//    Output: [5,4,3,2,1]
//    Example 2:
//    Input: head = [1,2]
//    Output: [2,1]
//    Example 3:
//    Input: head = []
//    Output: []
public class SolutionDay100 {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode cur = prev.next;
        ListNode next = cur.next;
        prev.next = null;
        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if (next != null) next = next.next;
        }
        return prev;
    }
}
