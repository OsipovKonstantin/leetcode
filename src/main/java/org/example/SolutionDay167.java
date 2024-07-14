package org.example;

//    medium #counting
//    Time complexity is O(n)
//    Space complexity is O(n) or O(1) if we don't create array cs
//    https://leetcode.com/problems/maximum-score-from-removing-substrings
//    You are given a string s and two integers x and y. You can perform two types of operations any number of times.
//    Remove substring "ab" and gain x points.
//    For example, when removing "ab" from "cabxbae" it becomes "cxbae".
//    Remove substring "ba" and gain y points.
//    For example, when removing "ba" from "cabxbae" it becomes "cabxe".
//    Return the maximum points you can gain after applying the above operations on s.
//    Example 1:
//    Input: s = "cdbcbbaaabab", x = 4, y = 5
//    Output: 19
//    Explanation:
//    - Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
//    - Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
//    - Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
//    - Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
//    Total score = 5 + 4 + 5 + 5 = 19.
//    Example 2:
//    Input: s = "aabbaaxybbaabb", x = 5, y = 4
//    Output: 20
public class SolutionDay167 {
    public static int maximumGain(String s, int x, int y) {
        int as = 0;
        int bs = 0;
        int ans = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c != 'a' && c != 'b') {
                ans += Math.min(as, bs) * Math.min(x, y);
                as = 0;
                bs = 0;
                continue;
            }
            if (x > y) {
                if (c == 'b' && as != 0) {
                    as--;
                    ans += x;
                } else if (c == 'b') bs++;
                else as++;
            } else {
                if (c == 'a' && bs != 0) {
                    bs--;
                    ans += y;
                } else if (c == 'a') as++;
                else bs++;
            }
        }

        ans += Math.min(as, bs) * Math.min(x, y);
        return ans;
    }
}
