package org.example;

import org.example.datastructures.ListNode;

//    medium #linked list
//    Time complexity is O(Math.max(n, m)), where n and m are the sizes of l1 and l2 linked lists respectively
//    Space complexity is O(Math.max(n, m))
//    https://leetcode.com/problems/add-two-numbers
public class SolutionDay193Third {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rootAns = new ListNode();
        ListNode ans = rootAns;
        int remainder = 0;
        boolean finishedFirstCycle = false;
        while (l1 != null || l2 != null || remainder != 0) {
            if (finishedFirstCycle) {
                ans.next = new ListNode();
                ans = ans.next;
            }
            int firstVal = l1 == null ? 0 : l1.val;
            int secondVal = l2 == null ? 0 : l2.val;
            ans.val = firstVal + secondVal + remainder;
            if (ans.val >= 10) {
                ans.val %= 10;
                remainder = 1;
            } else {
                remainder = 0;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            finishedFirstCycle = true;
        }
        return rootAns;
    }
}
