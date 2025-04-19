package org.example.java;

import java.util.Arrays;

//     medium #count backward and change lower number of frequency
//    https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique
//    A string s is called good if there are no two different characters in s that have the same frequency.
//    Given a string s, return the minimum number of characters you need to delete to make s good.
//    The frequency of a character in a string is the number of times it appears in the string. For example, in the
//    string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
//    Example 1:
//    Input: s = "aab"
//    Output: 0
//    Explanation: s is already good.
//    Example 2:
//    Input: s = "aaabbbcc"
//    Output: 2
//    Explanation: You can delete two 'b's resulting in the good string "aaabcc".
//    Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
//    Example 3:
//    Input: s = "ceabaacb"
//    Output: 2
//    Explanation: You can delete both 'c's resulting in the good string "eabaab".
//    Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
public class SolutionDay46Third {
    public static int minDeletions(String s) {
        char[] cs = s.toCharArray();
        int[] frequency = new int[26];
        int n = frequency.length;
        for (char c : cs) {
            frequency[c - 'a']++;
        }
        int ans = 0;
        Arrays.sort(frequency);
        for (int i = n - 2; i >= 0; i--) {
            if (frequency[i] == 0) {
                break;
            }
            if (frequency[i] >= frequency[i + 1]) {
                ans += frequency[i] - (frequency[i + 1] - (frequency[i + 1] - 1 < 0 ? 0 : 1));
                frequency[i] = Math.max(frequency[i + 1] - 1, 0);
            }
        }
        return ans;
    }
}
