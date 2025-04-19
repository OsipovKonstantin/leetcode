package org.example.java;

import org.example.datastructures.ListNode;

//    easy #linked list
//    Time complexity is O(n+m), where n and m are the sizes of the linked lists list1 and list2, respectively
//    Space complexity is O(n+m)
//    https://leetcode.com/problems/merge-two-sorted-lists
public class SolutionDay194Second {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null || list2 != null) {
            int val1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int val2 = list2 == null ? Integer.MAX_VALUE : list2.val;
            if (val1 <= val2) {
                cur.next = new ListNode(val1);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(val2);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
