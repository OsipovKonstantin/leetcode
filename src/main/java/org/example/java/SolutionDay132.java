package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    medium #backtrack
//    Time complexity is O(2^n)
//    Space complexity is O(n)
//    Given a string s, partition s such that every
//    substring
//     of the partition is a
//    palindrome
//    . Return all possible palindrome partitioning of s.
//    Example 1:
//    Input: s = "aab"
//    Output: [["a","a","b"],["aa","b"]]
//    Example 2:
//    Input: s = "a"
//    Output: [["a"]]
public class SolutionDay132 {
    private static List<List<String>> ans = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        char[] cs = s.toCharArray();
        List<String> cur = new ArrayList<>();
        cur.add(Character.toString(cs[0]));
        backtrack(s.toCharArray(), 1, cur);
        return ans;
    }

    private static void backtrack(char[] cs, int index, List<String> cur) {
        if (index == cs.length) {
            if (isPalindromes(cur)) ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(Character.toString(cs[index]));
        backtrack(cs, index + 1, cur);
        cur.remove(cur.size() - 1);
        String temp = cur.get(cur.size() - 1);
        String next = temp + Character.toString(cs[index]);
        cur.remove(cur.size() - 1);
        cur.add(next);
        backtrack(cs, index + 1, cur);
        cur.remove(cur.size() - 1);
        cur.add(temp);
    }

    private static boolean isPalindromes(List<String> cur) {
        for (String s : cur) {
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            if (!s.equals(sb.toString())) return false;
        }
        return true;
    }
}
