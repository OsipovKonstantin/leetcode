package org.example;

import org.example.datastructures.ListNode;

//    medium #linkedlist
//    https://leetcode.com/problems/split-linked-list-in-parts
//    Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list
//    parts.
//    The length of each part should be as equal as possible: no two parts should have a size differing by more than
//    one. This may lead to some parts being null.
//    The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have
//    a size greater than or equal to parts occurring later.
//    Return an array of the k parts.
//    Example 1:
//    Input: head = [1,2,3], k = 5
//    Output: [[1],[2],[3],[],[]]
//    Explanation:
//    The first element output[0] has output[0].val = 1, output[0].next = null.
//    The last element output[4] is null, but its string representation as a ListNode is [].
//    Example 2:
//    Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
//    Output: [[1,2,3,4],[5,6,7],[8,9,10]]
//    Explanation:
//    The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger
//    size than the later parts.
public class SolutionDay48Second {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        ListNode[] ans = new ListNode[k];
        int width = n / k;
        int rem = n % k;

        ListNode start = head;
        ListNode cur;
        temp = head;
        for (int j = 0; j < k; j++) {
            int size = width + (rem > j ? 1 : 0);
            for (int h = 0; h < size - 1; h++) {
                temp = temp.next;
            }
            cur = temp;
            temp = temp == null ? null : temp.next;
            if (cur != null) {
                cur.next = null;
            }
            ans[j] = start;
            start = temp;
        }
        return ans;
    }
}