package org.example.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//    easy #queue #array
//    https://leetcode.com/problems/set-mismatch
//    You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some
//    error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one
//    number and loss of another number.
//    You are given an integer array nums representing the data status of this set after the error.
//    Find the number that occurs twice and the number that is missing and return them in the form of an array.
//    Example 1:
//    Input: nums = [1,2,2,4]
//    Output: [2,3]
//    Example 2:
//    Input: nums = [1,1]
//    Output: [1,2]
public class SolutionDay43Second {
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] counter = new int[n + 1];
        for (int num : nums) {
            counter[num]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (counter[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (counter[nums[i]] > 1) {
                ans.add(nums[i]);
                counter[nums[i]]--;
                ans.add(q.poll());
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
