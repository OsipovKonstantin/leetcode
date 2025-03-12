package org.example;

//    easy #binary search
//    Time complexity is O(logn), where n is the size of nums array
//    Space complexity is O(1)
//    https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer
public class SolutionDay189 {
    public static int maximumCount(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= 0) l = mid + 1;
            else r = mid;
        }
        int positives = len - l;
        l = -1;
        r = len - 1;
        while (l < r) {
            int mid = r - (r - l) / 2;
            if (nums[mid] >= 0) r = mid - 1;
            else l = mid;
        }
        int negatives = l + 1;
        return Math.max(positives, negatives);
    }
}
