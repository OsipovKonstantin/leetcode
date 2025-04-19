package org.example.java;

//    easy #pointer
//    Time complexity is O(n), space complexity is O(n)
//    https://leetcode.com/problems/maximum-odd-binary-number
//    You are given a binary string s that contains at least one '1'.
//    You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number
//    that can be created from this combination.
//    Return a string representing the maximum odd binary number that can be created from the given combination.
//    Note that the resulting string can have leading zeros.
//    Example 1:
//    Input: s = "010"
//    Output: "001"
//    Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".
//    Example 2:
//    Input: s = "0101"
//    Output: "1001"
//    Explanation: One of the '1's must be in the last position. The maximum number that can be made with the remaining
//    digits is "100". So the answer is "1001".
public class SolutionDay81 {
    public static String maximumOddBinaryNumber(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int start = -1;
        for (int i = 0; i < n; i++) {
            char cur = cs[i];
            if (cur == '1') {
                start++;
                char temp = cur;
                cs[i] = cs[start];
                cs[start] = temp;
            }
        }
        char temp = cs[n - 1];
        cs[n - 1] = cs[start];
        cs[start] = temp;
        return new String(cs);
    }
}
