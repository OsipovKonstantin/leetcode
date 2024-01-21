package org.example;

import java.util.*;

//    medium (really hard) #sorting #graph #2 pointers #recursion with memoization. Solution is fast; I made it myself
//    in 3-4 hours, but it is complicated, and I think it could be done more simply than that
//    https://leetcode.com/problems/longest-string-chain
//    You are given an array of words where each word consists of lowercase English letters.
//    wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without
//    changing the order of the other characters to make it equal to wordB.
//    For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
//    A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of
//    word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
//    Return the length of the longest possible word chain with words chosen from the given list of words.
//    Example 1:
//    Input: words = ["a","b","ba","bca","bda","bdca"]
//    Output: 4
//    Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
//    Example 2:
//    Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
//    Output: 5
//    Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
//    Example 3:
//    Input: words = ["abcd","dbqca"]
//    Output: 1
//    Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
//    ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
public class SolutionDay41Fourth {
    private static int ans = 1;
    private static int[] memo;

    public static int longestStrChain(String[] words) {
        int n = words.length;
        memo = new int[n];
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        int left = 0;
        int right = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i < n; i++) {
            if (words[i].length() > words[i - 1].length()) {
                if (words[i].length() - words[left].length() > 1) {
                    left = i;
                }
                if (words[i - 1].length() != words[right].length()) {
                    left = right + 1;
                }
                right = i - 1;
            }
            if (words[i].length() == words[left].length()) {
                continue;
            }
            for (int j = left; j < right + 1; j++) {
                if (isParent(words[i], words[j])) {
                    if (!graph.containsKey(i)) {
                        graph.put(i, new ArrayList<>());
                    }
                    graph.get(i).add(j);
                }
            }
        }
        for (int parent : graph.keySet()) {
            traverse(graph, parent, parent, 1);
        }
        for (int val : memo) {
            ans = Math.max(ans, val);
        }
        return ans;
    }

    private static boolean isParent(String anchestor, String child) {
        int counter = 1;
        int childLen = child.length();
        for (int k = childLen - 1; k >= 0; k--) {
            if (anchestor.charAt(k + counter) != child.charAt(k)) {
                counter--;
                k++;
            }
            if (counter < 0) {
                return false;
            }
        }
        return true;
    }

    private static void traverse(Map<Integer, List<Integer>> graph, int parent, int child, int quantity) {
        if (!graph.containsKey(child)) {
            memo[parent] = Math.max(quantity, memo[parent]);
            return;
        }
        if (memo[child] != 0) {
            memo[parent] = Math.max(memo[parent], memo[child] + quantity - 1);
            return;
        }
        for (int node : graph.get(child)) {
            traverse(graph, parent, node, quantity + 1);
        }
    }
}
