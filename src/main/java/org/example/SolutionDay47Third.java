package org.example;

//    medium #linkedlist. Reversion of values in linked list easier than links. Here is second, more advance approach
//    https://leetcode.com/problems/reverse-linked-list-ii
//    Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes
//    of the list from position left to position right, and return the reversed list.
//    Example 1:
//    Input: head = [1,2,3,4,5], left = 2, right = 4
//    Output: [1,4,3,2,5]
//    Example 2:
//    Input: head = [5], left = 1, right = 1
//    Output: [5]
public class SolutionDay47Third {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode next = pre.next.next;
        for (int j = 0; j < right - left; j++) {
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = curr.next;
        }
        return dummy.next;
    }

    //it was done before solution of task
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
