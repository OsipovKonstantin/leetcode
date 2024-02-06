package org.example;

import java.util.Arrays;

//    medium (genius solution) #binary search (minimum max difference) #greedy (sorting)
//    Time complexity is O(n*logm+ n*logn), where n is number of elements in array nums,
//    m is maximum difference between pair (10^9). Space complexity is O(n) because of sorting array nums with length n
//    Second solution that get Time Limit Exceeded is dynamic programming bottom-up tabulation approach. Time complexity
//    of it is O(n*p), where n is number of elements in array nums and p is second parameter in task. Anyway this
//    solution is slower
//    https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs
//    You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the
//    maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the
//    p pairs.
//    Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where
//    |x| represents the absolute value of x.
//    Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.
//    Example 1:
//    Input: nums = [10,1,2,7,1,3], p = 2
//    Output: 1
//    Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices
//    2 and 5.
//    The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.
//    Example 2:
//    Input: nums = [4,2,1,2], p = 1
//    Output: 0
//    Explanation: Let the indices 1 and 3 form a pair. The difference of that pair is |2 - 2| = 0, which is the minimum
//    we can attain.
public class SolutionDay58Third {
    public static int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = 1000000000;
        int ans = 1000000000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, mid, p)) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    private static boolean isValid(int[] nums, int maxDiff, int p) {
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (Math.abs(nums[i + 1] - nums[i]) <= maxDiff) {
                count++;
                i += 2;
            } else i += 1;
            if (count == p) return true;
        }
        return false;
    }
}

//    public int minimizeMax(int[] nums, int p) {
//        int n = nums.length;
//        Arrays.sort(nums);
//        int[] prev = new int[n];
//        int[] cur = new int[n];
//        for(int i = 1; i <= p; i++) {
//            for(int j = i*2-1; j < n; j++){
//                cur[j] = Math.min(j>i*2-1?cur[j-1]:Integer.MAX_VALUE, Math.max(i>1?prev[j-2]:Integer.MIN_VALUE,
//                Math.abs(nums[j]-nums[j-1])));
//            }
//            prev = cur;
//            cur = new int[n];
//        }
//        return prev[n-1];
//    }
