package org.example.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//    hard. #PriorityQueue for keeping actual size of blooming flowers for each time
//    #sorting with saving order (we access number of blooming flowers for people using peopleMap).
//    Time complexity O(n⋅logn+m⋅(logn+logm)). Space complexity O(n+m), where n - flowers, m - people
//    Before i used only map for storing time and number of flowers but that algo was very slow
//    https://leetcode.com/problems/number-of-flowers-in-full-bloom
//    You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will
//    be in full bloom from starti to endi (inclusive). You are also given a 0-indexed integer array people of size n,
//    where people[i] is the time that the ith person will arrive to see the flowers.
//    Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom when
//    the ith person arrives.
//    Example 1:
//    Input: flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
//    Output: [1,2,2,2]
//    Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
//    For each person, we return the number of flowers in full bloom during their arrival.
//    Example 2:
//    Input: flowers = [[1,10],[3,3]], people = [3,3,2]
//    Output: [2,2,1]
//    Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
//    For each person, we return the number of flowers in full bloom during their arrival.
public class SolutionDay37Third {
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Map<Integer, Integer> peopleMap = new HashMap<>();
        int[] sortedPeopleTime = people.clone();
        Arrays.sort(sortedPeopleTime);
        Arrays.sort(flowers, (f1, f2) -> f1[0] - f2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (int time : sortedPeopleTime) {
            while (i < flowers.length && flowers[i][0] <= time) {
                pq.offer(flowers[i][1]);
                i++;
            }
            while (!pq.isEmpty() && pq.peek() < time) {
                pq.remove();
            }
            peopleMap.put(time, pq.size());
        }
        int n = people.length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            ans[j] = peopleMap.get(people[j]);
        }
        return ans;
    }
}
