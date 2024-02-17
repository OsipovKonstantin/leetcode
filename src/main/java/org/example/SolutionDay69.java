package org.example;

import org.example.datastructures.ListNode;

//    medium #linked list. Alternative approach is using Stack. Original task where we revert linked list to solve
//    problem.
//    We can't solve task with storing in numbers in int or long because numbers in test cases are larger...
//    So here is a solution for very big numbers
//    Time complexity is O(n+m), space complexity is O(n+m)
//    https://leetcode.com/problems/add-two-numbers-ii
//    You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
//    first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//    Example 1:
//    Input: l1 = [7,2,4,3], l2 = [5,6,4]
//    Output: [7,8,0,7]
//    Example 2:
//    Input: l1 = [2,4,3], l2 = [5,6,4]
//    Output: [8,0,7]
//    Example 3:
//    Input: l1 = [0], l2 = [0]
//    Output: [0]
public class SolutionDay69 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reversed1 = null;
        ListNode reversed2 = null;
        while (l1 != null) {
            ListNode temp = reversed1;
            reversed1 = new ListNode(l1.val, temp);
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode temp = reversed2;
            reversed2 = new ListNode(l2.val, temp);
            l2 = l2.next;
        }
        ListNode ans = null;
        int remainder = 0;
        while (reversed1 != null || reversed2 != null || remainder != 0) {
            ListNode temp = ans;
            ans = new ListNode((reversed1 == null ? 0 : reversed1.val) +
                    (reversed2 == null ? 0 : reversed2.val) + remainder, temp);
            if (remainder == 1) remainder = 0;
            if (ans.val > 9) {
                remainder = 1;
                ans.val -= 10;
            }
            reversed1 = reversed1 == null ? null : reversed1.next;
            reversed2 = reversed2 == null ? null : reversed2.next;
        }
        return ans;
    }
}
