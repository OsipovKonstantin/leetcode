package org.example;

//    hard #binary search-like (recursion). Understood solution at editorial and rewrote in myself
//    https://leetcode.com/problems/median-of-two-sorted-arrays
//    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//    The overall run time complexity should be O(log (m+n)).
//    Example 1:
//    Input: nums1 = [1,3], nums2 = [2]
//    Output: 2.00000
//    Explanation: merged array = [1,2,3] and median is 2.
//    Example 2:
//    Input: nums1 = [1,2], nums2 = [3,4]
//    Output: 2.50000
//    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
public class SolutionDay42Third {
    public static double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        int k;
        int aLeft = 0;
        int aRight = n1 - 1;
        int bLeft = 0;
        int bRight = n2 - 1;
        if (n % 2 == 1) {
            k = n / 2 + 1;
            return findMedian(a, b, k, aLeft, aRight, bLeft, bRight);
        } else {
            k = n / 2;
            return (double) (findMedian(a, b, k, aLeft, aRight, bLeft, bRight) + findMedian(a, b, k + 1, aLeft, aRight, bLeft, bRight)) / 2;
        }
    }

    private static int findMedian(int[] a, int[] b, int k, int aLeft, int aRight, int bLeft, int bRight) {
        if (aLeft > aRight) {
            return b[bLeft + k - 1];
        }
        if (bLeft > bRight) {
            return a[aLeft + k - 1];
        }
        int aMid = (aLeft + aRight) / 2;
        int bMid = (bLeft + bRight) / 2;
        int aMidVal = a[aMid];
        int bMidVal = b[bMid];
        int halfLen = ((aRight - aLeft) + (bRight - bLeft) + 2) / 2;
        if (k > halfLen) {
            if (aMidVal > bMidVal) {
                return findMedian(a, b, k - (bMid - bLeft) - 1, aLeft, aRight, bMid + 1, bRight);
            } else {
                return findMedian(a, b, k - (aMid - aLeft) - 1, aMid + 1, aRight, bLeft, bRight);
            }
        } else {
            if (aMidVal > bMidVal) {
                return findMedian(a, b, k, aLeft, aMid == aRight ? aMid - 1 : aMid, bLeft, bRight);
            } else {
                return findMedian(a, b, k, aLeft, aRight, bLeft, bMid == bRight ? bMid - 1 : bMid);
            }
        }
    }
}
