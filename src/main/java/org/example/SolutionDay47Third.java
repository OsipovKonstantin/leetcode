package org.example;

//    medium #linkedlist
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
        ListNode first = head;
        for (int i = 1; i < left; i++) {
            first = first.next;
        }
        int[] arr = new int[right - left + 1];
        arr[0] = first.val;
        ListNode last = first;
        for (int j = 1; j < arr.length; j++) {
            last = last.next;
            arr[j] = last.val;
        }
        for (int k = arr.length - 1; k >= 0; k--) {
            first.val = arr[k];
            first = first.next;
        }
        return head;
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
