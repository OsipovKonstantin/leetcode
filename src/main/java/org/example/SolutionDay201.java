package org.example;

import java.util.*;

//    hard #prime number #priority queue #monotonic decreasing stack
//    Time complexity is O(n*(sqrt(m)+logn)), where n is the size of the list nums
//    and m is the maximum value in the list nums
//    Space complexity is O(n)
//    https://leetcode.com/problems/apply-operations-to-maximize-score
public class SolutionDay201 {
    public static int maximumScore(List<Integer> nums, int k) {
        List<Integer> primeScores = new ArrayList<>();
        int len = nums.size();
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                primeScores.add(map.get(num));
                continue;
            }
            int temp = num;
            int score = 0;
            for (int i = 2; i < Math.sqrt(num) + 1; i++) {
                if (num % i == 0) {
                    score++;
                    while (num % i == 0) num /= i;
                }
            }
            if (num > 1) score++;
            map.put(temp, score);
            primeScores.add(score);
        }

        // find left and right boundaries for each primeScore. Each primeScore is maximum in range of indexes.
        // This range is between left and right boundaries, here exclusively
        int[] leftBoundary = new int[len];
        int[] rightBoundary = new int[len];
        Arrays.fill(leftBoundary, -1);
        Arrays.fill(rightBoundary, len);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int score = primeScores.get(i);
            while (!deque.isEmpty() && primeScores.get(deque.peek()) < score) {
                int index = deque.pop();
                rightBoundary[index] = i;
            }
            if (!deque.isEmpty()) {
                leftBoundary[i] = deque.peek();
            }
            deque.push(i);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int) (b[0] - a[0]));
        for (int i = 0; i < len; i++) {
            long val = nums.get(i);
            long leftCount = i - leftBoundary[i];
            long rightCount = rightBoundary[i] - i;
            long subarrays = leftCount * rightCount;
            pq.offer(new long[]{val, subarrays});
        }

        long ans = 1;
        while (k > 0) {
            long[] cur = pq.poll();
            long val = cur[0];
            long subarrays = cur[1];
            long operations = Math.min(subarrays, k);
            k -= operations;
            ans = (ans * power(val, operations, mod)) % mod;
        }
        return (int) ans;
    }

    private static long power(long val, long operations, int mod) {
        long score = 1;
        while (operations > 0) {
            if (operations % 2 == 1) {
                score = (score * val) % mod;
            }
            operations /= 2;
            val = (val * val) % mod;
        }
        return score;
    }
}
