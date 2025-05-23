package org.example.java;

import org.example.datastructures.ListNode;

//    easy #cycle detection (hare and tortoise approach)
//    https://leetcode.com/problems/linked-list-cycle
//    Given head, the head of a linked list, determine if the linked list has a cycle in it.
//    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
//    the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected
//    to. Note that pos is not passed as a parameter.
//    Return true if there is a cycle in the linked list. Otherwise, return false.
//    Example 1:
//    Input: head = [3,2,0,-4], pos = 1
//    Output: true
//    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//    Example 2:
//    Input: head = [1,2], pos = 0
//    Output: true
//    Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
//    Example 3:
//    Input: head = [1], pos = -1
//    Output: false
//    Explanation: There is no cycle in the linked list.
public class SolutionDay49 {
    public static boolean hasCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise) return true;
        }
        return false;
    }
}
