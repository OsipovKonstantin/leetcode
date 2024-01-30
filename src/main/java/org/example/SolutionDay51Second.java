package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//    medium #dynamic programming. Here is top-down approach with memoization
//    https://leetcode.com/problems/extra-characters-in-a-string
//    You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more
//    non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters
//    in s which are not present in any of the substrings.
//    Return the minimum number of extra characters left over if you break up s optimally.
//    Example 1:
//    Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
//    Output: 1
//    Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8.
//    There is only 1 unused character (at index 4), so we return 1.
//    Example 2:
//    Input: s = "sayhelloworld", dictionary = ["hello","world"]
//    Output: 3
//    Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12.
//    The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters.
//    Hence, we return 3.
public class SolutionDay51Second {
    private static int[] memo;

    public static int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        memo = new int[n];
        Arrays.fill(memo, -1);
        return traverse(s, dict, 0);
    }

    private static int traverse(String s, Set<String> dict, int curIndex) {
        int n = s.length();
        if (curIndex == n) {
            return 0;
        }
        if (memo[curIndex] != -1) {
            return memo[curIndex];
        }
        // 2 ways or further recursion. First traversion - we skip current char (count it as extra char).
        // Second traverse (in loop) - we found word in set, go to the char after founded word and not add extra char
        int ans = traverse(s, dict, curIndex + 1) + 1;
        for (int end = curIndex + 1; end <= n; end++) {
            if (dict.contains(s.substring(curIndex, end))) {
                ans = Math.min(ans, traverse(s, dict, end));
            }
        }
        return memo[curIndex] = ans;
    }
}
