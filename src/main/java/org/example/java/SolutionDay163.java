package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    easy #array
//    Time complexity is O(n+m), where n is length of nums1 and m is length of nums2
//    Space complexity is O(1001+min(n, m))
//    https://leetcode.com/problems/intersection-of-two-arrays-ii
//    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
//    appear as many times as it shows in both arrays and you may return the result in any order.
//    Example 1:
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2,2]
//    Example 2:
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [4,9]
//    Explanation: [9,4] is also accepted.
public class SolutionDay163 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] temp = new int[1001];
        List<Integer> ansList = new ArrayList<>();
        for (int num : nums1) temp[num]++;
        for (int num : nums2) {
            if (temp[num] > 0) {
                temp[num]--;
                ansList.add(num);
            }
        }
        return ansList.stream().mapToInt(i -> i).toArray();
    }
}
