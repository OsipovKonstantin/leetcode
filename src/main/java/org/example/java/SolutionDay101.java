package org.example.java;

import org.example.datastructures.ListNode;

//    easy #linklist
//    Time complexity is O(n), where n is number of nodes
//    Space complexity is O(1)
//    https://leetcode.com/problems/palindrome-linked-list
//    Given the head of a singly linked list, return true if it is a
//    palindrome
//     or false otherwise.
//    Example 1:
//    Input: head = [1,2,2,1]
//    Output: true
//    Example 2:
//    Input: head = [1,2]
//    Output: false
public class SolutionDay101 {
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
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
        while (prev != null) {
            if (prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
