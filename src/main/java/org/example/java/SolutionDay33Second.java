package org.example.java;

//    medium. #greedy. Time complexity 0(n). There are a lot of approaches: bit manipulation, recursion.
//    But this one without bit manipulation and recursion. Recursion have more space complexity due to using stack
//    https://leetcode.com/problems/k-th-symbol-in-grammar
//    We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we
//    look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
//    For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
//    Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
//    Example 1:
//    Input: n = 1, k = 1
//    Output: 0
//    Explanation: row 1: 0
//    Example 2:
//    Input: n = 2, k = 1
//    Output: 0
//    Explanation:
//    row 1: 0
//    row 2: 01
//    Example 3:
//    Input: n = 2, k = 2
//    Output: 1
//    Explanation:
//    row 1: 0
//    row 2: 01
public class SolutionDay33Second {
    public static int kthGrammar(int n, int k) {
        int temp = 0;
        int left = 1;
        int right = (int) Math.pow(2, n - 1);
        while (left < right) {
            int mid = (left + right) / 2;
            if (k <= mid) {
                temp = temp == 0 ? 0 : 1;
                right = mid;
            } else {
                temp = temp == 0 ? 1 : 0;
                left = mid + 1;
            }
        }
        return temp;
    }
}