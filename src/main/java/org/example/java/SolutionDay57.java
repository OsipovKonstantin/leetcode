package org.example.java;

import java.util.ArrayDeque;
import java.util.Deque;

//    hard (really medium) #monotonic increasing queue #priority queue
//    Two solutions. Solution with monotonic queue works 2 times faster than priority queue
//    Time complexity is O(n), where n is size of array nums
//    Space complexity is O(1), if we don't count answer (int[] ans)
//    https://leetcode.com/problems/sliding-window-maximum
//    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
//    the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
//    by one position.
//    Return the max sliding window.
//    Example 1:
//    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//    Output: [3,3,5,5,6,7]
//    Explanation:
//    Window position                Max
//    ---------------               -----
//    [1  3  -1] -3  5  3  6  7       3
//     1 [3  -1  -3] 5  3  6  7       3
//     1  3 [-1  -3  5] 3  6  7       5
//     1  3  -1 [-3  5  3] 6  7       5
//     1  3  -1  -3 [5  3  6] 7       6
//     1  3  -1  -3  5 [3  6  7]      7
//    Example 2:
//    Input: nums = [1], k = 1
//    Output: [1]
public class SolutionDay57 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if (deque.isEmpty() || nums[deque.peekFirst()] < nums[i]) {
                deque.offerFirst(i);
            } else {
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
        }
        for (int start = 0; start + k - 1 < n; start++) {
            int end = start + k - 1;
            while (!deque.isEmpty() && deque.peekFirst() < start) {
                deque.pollFirst();
            }
            if (deque.isEmpty() || nums[deque.peekFirst()] < nums[end]) {
                deque.offerFirst(end);
            } else {
                while (deque.peekLast() < start || nums[deque.peekLast()] < nums[end]) {
                    deque.pollLast();
                }
                deque.offerLast(end);
            }
            ans[start] = nums[deque.peekFirst()];
        }
        return ans;
    }
}

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        int[] ans= new int[n-k+1];
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[1]-a[1]);
//        for(int i=0; i<k-1;i++){
//            pq.offer(new int[]{i, nums[i]});
//        }
//        for(int start = 0; start+k-1<n; start++){
//            int end=start+k-1;
//            pq.offer(new int[]{end, nums[end]});
//            while(pq.peek()[0]<start){
//                pq.poll();
//            }
//            ans[start]=pq.peek()[1];
//        }
//        return ans;
//    }
