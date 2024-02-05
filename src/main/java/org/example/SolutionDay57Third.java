package org.example;

import org.example.datastructures.ListNode;

//    medium #two pointers #linked list
//    Time complexity is O(n), space complexity is O(1)
//    https://leetcode.com/problems/partition-list
//    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes
//    greater than or equal to x.
//    You should preserve the original relative order of the nodes in each of the two partitions.
//    Example 1:
//    Input: head = [1,4,3,2,5,2], x = 3
//    Output: [1,2,2,4,3,5]
//    Example 2:
//    Input: head = [2,1], x = 2
//    Output: [1,2]
public class SolutionDay57Third {
    public static ListNode partition(ListNode head, int x) {
//    dummy node is useful because it preserves link to begin of linked list.
//    In this task head may change position. For example, head.val is equal or greater x
        ListNode dummy = new ListNode(-1, head);

//    before is right end of list with smaller values than x
//    after is current right end of list with equal or greater values compare to x
//    If after.ext equal or greater than x, we go further (after = after.next).
//    Otherwise, we store variable temp = after.next and change links after.next, temp.next and before.next
        ListNode before = dummy;
        while (before.next != null && before.next.val < x)
            before = before.next;
        ListNode after = before.next;

        while (after != null && after.next != null) {
            if (after.next.val >= x) after = after.next;
            else {
                ListNode temp = after.next;
                after.next = temp.next;
                temp.next = before.next;
                before.next = temp;
                before = temp;
            }
        }
        return dummy.next;
    }
}
