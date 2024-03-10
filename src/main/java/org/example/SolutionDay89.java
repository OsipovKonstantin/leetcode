package org.example;

import java.util.HashSet;
import java.util.Set;

//    easy #Array
//    Time complexity is O(n+m), where n is number of elements in nums1, m is number of elements in nums2
//    Space complexity is O(min(n, m))
//    https://leetcode.com/problems/intersection-of-two-arrays
//    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
//    be unique and you may return the result in any order.
//    Example 1:
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2]
//    Example 2:
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [9,4]
//    Explanation: [4,9] is also accepted.
public class SolutionDay89 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        boolean[] hasInFirst = new boolean[1001];
        Set<Integer> unique = new HashSet<>();
        for (int num : nums1) if (!hasInFirst[num]) hasInFirst[num] = true;
        for (int num : nums2) if (hasInFirst[num]) unique.add(num);
        int[] ans = new int[unique.size()];
        int i = 0;
        for (int num : unique) ans[i++] = num;
        return ans;
    }
}
