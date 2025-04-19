package org.example.java;

//    medium #prefix sum #binary search
//    Time complexity is O(max(n, 1001)), where n is the size of citations array and 1001 is the maximum number of citations
//    Space complexity is O(n)
//    https://leetcode.com/problems/h-index
public class SolutionDay173 {
    public static int hIndex(int[] citations) {
        int len = citations.length;
        int lenNumber = 1001;
        int[] cNumber = new int[lenNumber];
        for (int i = 0; i < len; i++) {
            cNumber[citations[i]]++;
        }
        int[] prefixSum = new int[lenNumber];
        for (int i = lenNumber - 1; i >= 0; i--) {
            prefixSum[i] = cNumber[i] + (i + 1 < lenNumber ? prefixSum[i + 1] : 0);
        }
        int l = 0;
        int r = lenNumber - 1;
        while (l < r) {
            int mid = r - (r - l) / 2;
            if (prefixSum[mid] >= mid) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
