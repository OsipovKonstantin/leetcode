package org.example.java;

import org.example.datastructures.ListNode;

//    medium #linkedlist #tortoisehare
//    Time complexity is O(n), where n is number of nodes
//    Space complexity is O(1)
//    https://leetcode.com/problems/reorder-list
//    You are given the head of a singly linked-list. The list can be represented as:
//    L0 → L1 → … → Ln - 1 → Ln
//    Reorder the list to be on the following form:
//    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//    You may not modify the values in the list's nodes. Only nodes themselves may be changed.
//    Example 1:
//    Input: head = [1,2,3,4]
//    Output: [1,4,2,3]
//    Example 2:
//    Input: head = [1,2,3,4,5]
//    Output: [1,5,2,4,3]
public class SolutionDay102 {
    public static void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode first = head;
        while (prev != null) {
            ListNode second = first.next;
            ListNode prelast = prev.next;
            first.next = prev;
            if (prev != second)
                prev.next = second;
            first = second;
            prev = prelast;
        }
    }
}
