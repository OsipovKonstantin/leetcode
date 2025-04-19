package org.example.java;

import java.util.HashMap;
import java.util.Map;

//    medium #counting sort. Second approach is priority queue or sorting
//    First approach has O(n) time complexity and space complexity O(n)
//    https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals
//    Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly
//    k elements.
//    Example 1:
//    Input: arr = [5,5,4], k = 1
//    Output: 1
//    Explanation: Remove the single 4, only 5 is left.
//    Example 2:
//    Input: arr = [4,3,1,1,3,3,2], k = 3
//    Output: 2
//    Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
public class SolutionDay68Second {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        int[] freqCounter = new int[n + 1];
        for (int freqVal : freq.values())
            freqCounter[freqVal]++;
        int ans = freq.size();
        for (int i = 1; i < n + 1; i++) {
            if (k >= freqCounter[i] * i) {
                k -= freqCounter[i] * i;
                ans -= freqCounter[i];
            } else {
                ans -= k / i;
                break;
            }
        }
        return ans;
    }
}

//    #priority queue Time complexity is O(nlogn)
//    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
//        Map<Integer, Integer> freq = new HashMap<>();
//        for (int num : arr)
//            freq.put(num, freq.getOrDefault(num, 0) + 1);
//        PriorityQueue<Integer> pq = new PriorityQueue<>(freq.values());
//        while (k > 0) {
//            if (pq.peek() <= k) k -= pq.poll();
//            else break;
//        }
//        return pq.size();
//    }