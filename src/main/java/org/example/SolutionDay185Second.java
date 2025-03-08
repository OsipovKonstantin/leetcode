package org.example;

//    easy #string #counting
//    Time complexity is O(n+m), where n and m is the length of ransomNote and magazine strings respectively
//    Space complexity is O(n+m)
//    https://leetcode.com/problems/ransom-note
public class SolutionDay185Second {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        char[] mCs = magazine.toCharArray();
        char[] rCs = ransomNote.toCharArray();
        for (char c : mCs) {
            chars[c - 'a']++;
        }
        for (char c : rCs) {
            if (chars[c - 'a'] == 0) return false;
            chars[c - 'a']--;
        }
        return true;
    }
}
