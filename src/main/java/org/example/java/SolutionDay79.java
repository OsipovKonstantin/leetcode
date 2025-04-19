package org.example.java;

import com.github.javaparser.utils.Pair;

import java.util.*;

//    medium #priority queue. Time complexity is O(min(k, n*m)*log(min(k, n*m))), where k is number of output pairs,
//    n is number of elements in nums1, m is number of elements in nums2
//    Space complexity is O(min(k, m*n)). Seen require such space and queue can enlarge because we poll 1 element and
//    offer 2 each time
//    https://leetcode.com/problems/find-k-pairs-with-smallest-sums
//    You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
//    Define a pair (u, v) which consists of one element from the first array and one element from the second array.
//    Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
//    Example 1:
//    Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//    Output: [[1,2],[1,4],[1,6]]
//    Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],
//    [11,4],[11,6]
//    Example 2:
//    Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//    Output: [[1,1],[1,1]]
//    Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],
//    [2,3]
public class SolutionDay79 {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        Set<Pair<Integer, Integer>> seen = new HashSet<>();
        seen.add(new Pair(0, 0));
        List<List<Integer>> ans = new ArrayList<>();
        while (k-- > 0) {
            int[] cur = pq.poll();
            int i1 = cur[1];
            int i2 = cur[2];
            ans.add(List.of(nums1[i1], nums2[i2]));
            Pair<Integer, Integer> next1 = new Pair(i1 + 1, i2);
            if (i1 + 1 < n && !seen.contains(next1)) {
                pq.offer(new int[]{nums1[i1 + 1] + nums2[i2], i1 + 1, i2});
                seen.add(next1);
            }
            Pair<Integer, Integer> next2 = new Pair(i1, i2 + 1);
            if (i2 + 1 < m && !seen.contains(next2)) {
                pq.offer(new int[]{nums1[i1] + nums2[i2 + 1], i1, i2 + 1});
                seen.add(next2);
            }
        }
        return ans;
    }
}
