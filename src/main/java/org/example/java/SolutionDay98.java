package org.example.java;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//    medium #priorityqueue #queue
//    Time complexity is O(nlog26) or O(n) if we take 26 as constant, where n is number of tasks, 26 is number of chars
//    Space complexity is O(52) or O(1), because queue may store maximum 26 pairs
//    https://leetcode.com/problems/task-scheduler
//    You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or
//    interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint:
//    identical tasks must be separated by at least n intervals due to cooling time.
//    Return the minimum number of intervals required to complete all tasks.
//    Example 1:
//    Input: tasks = ["A","A","A","B","B","B"], n = 2
//    Output: 8
//    Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
//    After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd
//    interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have
//    passed.
//    Example 2:
//    Input: tasks = ["A","C","A","B","D","B"], n = 1
//    Output: 6
//    Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
//    With a cooling interval of 1, you can repeat a task after just one other task.
//    Example 3:
//    Input: tasks = ["A","A","A", "B","B","B"], n = 3
//    Output: 10
//    Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
//    There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice
//    between repetitions of these tasks.
public class SolutionDay98 {
    public static int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        if (n == 0) return m;
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> q = new LinkedList<>();
        for (int f : freq)
            if (f > 0)
                pq.offer(f);
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            if (!q.isEmpty() && q.peek()[1] <= time)
                pq.offer(q.poll()[0]);
            time++;
            if (!pq.isEmpty()) {
                int nextFreq = pq.poll() - 1;
                if (nextFreq > 0)
                    q.offer(new int[]{nextFreq, time + n});
            }
        }
        return time;
    }
}
