package org.example.java;

//    medium. Prev variable for tracing equal char in string
//    https://leetcode.com/problems/count-number-of-homogenous-substrings
//    Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it
//    modulo 10^9 + 7.
//    A string is homogenous if all the characters of the string are the same.
//    A substring is a contiguous sequence of characters within a string.
//    Example 1:
//    Input: s = "abbcccaa"
//    Output: 13
//    Explanation: The homogenous substrings are listed as below:
//    "a"   appears 3 times.
//    "aa"  appears 1 time.
//    "b"   appears 2 times.
//    "bb"  appears 1 time.
//    "c"   appears 3 times.
//    "cc"  appears 2 times.
//    "ccc" appears 1 time.
//    3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
//    Example 2:
//    Input: s = "xy"
//    Output: 2
//    Explanation: The homogenous substrings are "x" and "y".
//    Example 3:
//    Input: s = "zzzzz"
//    Output: 15
public class SolutionDay28Third {
    public static int countHomogenous(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int mod = 1000000007;
        int prev = 0;
        long ans = n;
        for (int i = 1; i < n; i++) {
            if (c[i - 1] != c[i]) {
                prev = 0;
                continue;
            }
            prev += 1;
            ans = (ans + prev) % mod;
        }
        return (int) ans;
    }
}
