package org.example;

import org.example.datastructures.ListNode;

//    medium #linked list
//    Time complexity is O(n)
//    Space complexity is O(1)
//    https://leetcode.com/problems/rotate-list
public class SolutionDay196Second {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0, head);
        int len = 1;
        while (head.next != null) {
            len++;
            head = head.next;
        }
        int count = k % len;
        if (count == 0) return dummy.next;
        ListNode head2 = dummy.next;
        for (int i = 0; i < len - count - 1; i++) {
            head2 = head2.next;
        }
        head.next = dummy.next;
        dummy.next = head2.next;
        head2.next = null;
        return dummy.next;
    }
}
