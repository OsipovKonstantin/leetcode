package org.example.java;

//    medium #binary search
//    Time complexity is O(n*logn*logk), where n is number of elements in arr, k is maximum number in arr
//    Space complexity is O(1)
//    https://leetcode.com/problems/k-th-smallest-prime-fraction
//    You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique.
//    You are also given an integer k.
//    For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
//    Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where
//    answer[0] == arr[i] and answer[1] == arr[j].
//    Example 1:
//    Input: arr = [1,2,3,5], k = 3
//    Output: [2,5]
//    Explanation: The fractions to be considered in sorted order are:
//    1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
//    The third fraction is 2/5.
//    Example 2:
//    Input: arr = [1,7], k = 1
//    Output: [1,7]
public class SolutionDay122 {
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0;
        double right = 1;
        while (left < right) {
            double mid = right - (right - left) / 2;
            int fAns = 0;
            int sAns = 0;
            double maxRatio = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                int l = i + 1;
                int r = n;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if ((double) arr[i] / arr[m] >= mid) l = m + 1;
                    else r = m;
                }
                count += (n - l);
                if (l == n) break;
                double curRatio = (double) arr[i] / arr[l];
                if (curRatio > maxRatio) {
                    fAns = arr[i];
                    sAns = arr[l];
                    maxRatio = curRatio;
                }
            }
            if (count == k) return new int[]{fAns, sAns};
            else if (count > k) right = mid;
            else left = mid;
        }
        return new int[]{};
    }
}
