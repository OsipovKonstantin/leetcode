package org.example.java;

import java.util.PriorityQueue;

//    medium #priority queue
//    Time complexity is O(n), space complexity is O(k), where n is size of nums and k is second param in this task
//    Solution with sorting is slower because time complexity of sorting is O(n*logn)
//    https://leetcode.com/problems/kth-largest-element-in-an-array
//    Given an integer array nums and an integer k, return the kth largest element in the array.
//    Note that it is the kth largest element in the sorted order, not the kth distinct element.
//    Can you solve it without sorting?
//    Example 1:
//    Input: nums = [3,2,1,5,6,4], k = 2
//    Output: 5
//    Example 2:
//    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//    Output: 4
public class SolutionDay57Fourth {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
    }
}
