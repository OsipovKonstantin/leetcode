package org.example.java;

import org.example.datastructures.ListNode;

//    medium #linkedlist
//    Time complexity is O(b+m), where b is index in list 1, m is number of elements in list2
//    Space complexity is O(1)
//    https://leetcode.com/problems/merge-in-between-linked-lists/
//    You are given two linked lists: list1 and list2 of sizes n and m respectively.
//    Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
//    The blue edges and nodes in the following figure indicate the result:
//    Build the result list and return its head.
//    Example 1:
//    Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
//    Output: [10,1,13,1000000,1000001,1000002,5]
//    Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes
//    in the above figure indicate the result.
//    Example 2:
//    Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
//    Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
//    Explanation: The blue edges and nodes in the above figure indicate the result.
public class SolutionDay99 {
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy1 = new ListNode(0, list1);
        list1 = dummy1;
        ListNode dummy2 = list2;
        ListNode pre = null;
        ListNode post = null;
        for (int i = 0; i <= b + 2; i++) {
            if (i == a) pre = list1;
            else if (i == b + 2) post = list1;
            list1 = list1.next;
        }
        while (list2.next != null) list2 = list2.next;
        pre.next = dummy2;
        list2.next = post;
        return dummy1.next;
    }
}
