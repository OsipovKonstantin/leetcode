package org.example.java;

import org.example.datastructures.ListNode;

//    easy #linked list
//    https://leetcode.com/problems/middle-of-the-linked-list
//    Given the head of a singly linked list, return the middle node of the linked list.
//    If there are two middle nodes, return the second middle node.
//    Example 1:
//    Input: head = [1,2,3,4,5]
//    Output: [3,4,5]
//    Explanation: The middle node of the list is node 3.
//    Example 2:
//    Input: head = [1,2,3,4,5,6]
//    Output: [4,5,6]
//    Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
public class SolutionDay87 {
    public static ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode tortoise = dummy;
        ListNode hare = dummy;
        while (hare != null) {
            tortoise = tortoise.next;
            if (hare.next == null) hare = hare.next;
            else hare = hare.next.next;
        }
        return tortoise;
    }
}
