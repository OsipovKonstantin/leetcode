package org.example;

//    medium (really - hard). #traverse + reverse traverse approach. Time complexity O(n)! #math
//    Other solutions result in Time Limit Exceeded (recursion) or  Memory Limit Exceeded (maybe using StringBuilder)
//    We count decodedLength, then if decodedLength>=k we save the index in string s in the variable position.
//    At the end, we reverse traverse from position to 0. During the reverse traversal when we read a number we change
//    k = k%(decodedLength/s.charAt(position)) until we find k == 0 of k == decodedLength. k==0 (after %) means that
//    first char that we meet after number during reverse traversing is answer.
//    https://leetcode.com/problems/decoded-string-at-index
//    You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at
//    a time and the following steps are taken:
//    If the character read is a letter, that letter is written onto the tape.
//    If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
//    Given an integer k, return the kth letter (1-indexed) in the decoded string.
//    Example 1:
//    Input: s = "leet2code3", k = 10
//    Output: "o"
//    Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode".
//    The 10th letter in the string is "o".
//    Example 2:
//    Input: s = "ha22", k = 5
//    Output: "h"
//    Explanation: The decoded string is "hahahaha".
//    The 5th letter is "h".
//    Example 3:
//    Input: s = "a2345678999999999999999", k = 1
//    Output: "a"
//    Explanation: The decoded string is "a" repeated 8301530446056247680 times.
//    The 1st letter is "a"
public class SolutionDay40 {
    public static String decodeAtIndex(String s, int k) {
        if (k == 1) {
            return s.substring(0, 1);
        }
        int n = s.length();
        char[] cs = s.toCharArray();
        long decodedLength = 0;
        int position = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(cs[i])) {
                decodedLength *= (cs[i] - '0');
            } else {
                decodedLength++;
            }
            if (decodedLength >= k) {
                position = i;
                break;
            }
        }
        for (int j = position; j >= 0; j--) {
            if (Character.isDigit(cs[j])) {
                decodedLength = decodedLength / (cs[j] - '0');
                k = (int) (k % decodedLength);
            } else {
                if (k == 0 || decodedLength == k) {
                    return String.valueOf(cs[j]);
                }
                decodedLength--;
            }
        }
        return "";
    }
}