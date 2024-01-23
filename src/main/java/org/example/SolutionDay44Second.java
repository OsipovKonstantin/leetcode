package org.example;

import java.util.*;

//    medium #bit manipulation #Breadth First Search (BFS) #set to reduce redundant loops. Decided it within 2 hours
//    You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has
//    unique characters.
//    Return the maximum possible length of s.
//    A subsequence is an array that can be derived from another array by deleting some or no elements without changing
//    the order of the remaining elements.
//    Example 1:
//    Input: arr = ["un","iq","ue"]
//    Output: 4
//    Explanation: All the valid concatenations are:
//    - ""
//    - "un"
//    - "iq"
//    - "ue"
//    - "uniq" ("un" + "iq")
//    - "ique" ("iq" + "ue")
//    Maximum length is 4.
//    Example 2:
//    Input: arr = ["cha","r","act","ers"]
//    Output: 6
//    Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
//    Example 3:
//    Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
//    Output: 26
//    Explanation: The only string in arr has all 26 characters.
public class SolutionDay44Second {
    public static int maxLength(List<String> arr) {
        int n = arr.size();
        int[] bitArr = new int[n];
        for (int i = 0; i < n; i++) {
            char[] cs = arr.get(i).toCharArray();
            bitArr[i] = countBitNum(cs);
        }
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int bitNum : bitArr) {
            q.offer(bitNum);
        }
        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (set.contains(curr)) {
                continue;
            }
            set.add(curr);
            ans = Math.max(ans, Integer.bitCount(curr));
            for (int next : bitArr) {
                if ((curr & next) == 0) {
                    q.offer(curr | next);
                }
            }
        }
        return ans;
    }

    private static int countBitNum(char[] cs) {
        int bitNum = 0;
        for (char c : cs) {
            if ((bitNum & 1 << (c - 'a')) == 1 << (c - 'a')) {
                return 0;
            }
            bitNum += 1 << (c - 'a');
        }
        return bitNum;
    }
}
