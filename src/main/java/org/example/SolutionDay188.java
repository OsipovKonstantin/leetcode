package org.example;

//    medium #bitmask
//    Time complexity is O(n), where n is the length of s string
//    Space complexity is O(n)
//    https://leetcode.com/problems/number-of-substrings-containing-all-three-characters
public class SolutionDay188 {
    public static int numberOfSubstrings(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int start = 0;
        int ans = 0;
        int[] occurrence = new int[3];
        int unique = 0; // 1 - a, 2 - b, 4 - c
        for (int end = 0; end < len; end++) {
            int cur = cs[end] - 'a';
            occurrence[cur]++;
            unique |= 1 << cur;
            while (unique == 7) {
                ans += len - end;
                int prev = cs[start] - 'a';
                if (occurrence[prev] == 1) {
                    unique ^= 1 << prev;
                }
                occurrence[prev]--;
                start++;
            }
        }
        return ans;
    }
}
