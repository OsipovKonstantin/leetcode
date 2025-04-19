package org.example.java;

import org.example.datastructures.ListNode;

//    medium #linked list
//    Time complexity is O(n), where n is the size of the linked list
//    Space complexity is O(1)
//    https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
public class SolutionDay195Second {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            int count = 1;
            while (head.next != null && head.val == head.next.val) {
                count++;
                head = head.next;
            }
            if (count == 1) {
                prev.next = head;
                prev = head;
            }
            head = head.next;
        }
        if (prev.next != null) prev.next = null;
        return dummy.next;
    }
}
