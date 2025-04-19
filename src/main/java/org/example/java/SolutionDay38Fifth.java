package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    medium. #Boyer-Moore Majority Vote Algorithm (Алгоритм большинства голосов Бойера-Мура, опубликованный в 1981 году.
//    Назван в честь двух американских учёных, разработавших алгоритм). Time complexity O(n), space complexity O(1)!
//    https://leetcode.com/problems/majority-element-ii
//    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//    Example 1:
//    Input: nums = [3,2,3]
//    Output: [3]
//    Example 2:
//    Input: nums = [1]
//    Output: [1]
//    Example 3:
//    Input: nums = [1,2]
//    Output: [1,2]
public class SolutionDay38Fifth {
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0;
        int count2 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2++;
            } else if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (count1 > n / 3) {
            ans.add(candidate1);
        }
        if (count2 > n / 3) {
            ans.add(candidate2);
        }
        return ans;
    }
}
