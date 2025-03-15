package org.example.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

//    medium solution day 192 second #design If there is no elements top and getMin methods return -1
//    Time complexity is O(1) for each operation
//    Space complexity is O(n), where n is the number of elements in stack
//    https://leetcode.com/problems/min-stack
public class MinStack {
    Deque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        int prevMin = stack.isEmpty() ? val : stack.peek()[1];
        stack.push(new int[]{val, Math.min(val, prevMin)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek()[0];
    }

    public int getMin() {
        return stack.isEmpty() ? -1 : stack.peek()[1];
    }
}
