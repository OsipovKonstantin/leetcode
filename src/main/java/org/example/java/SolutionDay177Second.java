package org.example.java;

//    easy #string
//    Time complexity is O(lenH*lenN), where lenH is the length of haystack string and lenN is the length of needle array
//    Space complexity is O(lenH+lenN)
//    https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
public class SolutionDay177Second {
    public static int strStr(String haystack, String needle) {
        char[] csH = haystack.toCharArray();
        int lenH = csH.length;
        char[] csN = needle.toCharArray();
        int lenN = csN.length;
        for (int i = 0; i < lenH; i++) {
            if (i + lenN > lenH) break;
            for (int j = 0; j < lenN; j++) {
                if (csN[j] != csH[i + j]) break;
                if (j == lenN - 1) return i;
            }
        }
        return -1;
    }
}
