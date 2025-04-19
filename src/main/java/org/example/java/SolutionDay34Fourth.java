package org.example.java;

import org.example.datastructures.NestedInteger;

import java.util.*;

//    medium. #Design (create iterator for interface NestedInteger)
//    You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements
//    may also be integers or other lists. Implement an iterator to flatten it.
//    Implement the NestedIterator class:
//    NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
//    int next() Returns the next integer in the nested list.
//    boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
//    Your code will be tested with the following pseudocode:
//    initialize iterator with nestedList
//    res = []
//    while iterator.hasNext()
//        append iterator.next() to the end of res
//    return res
//    If res matches the expected flattened list, then your code will be judged as correct.
//    Example 1:
//    Input: nestedList = [[1,1],2,[1,1]]
//    Output: [1,1,2,1,1]
//    Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next
//    should be: [1,1,2,1,1].
//    Example 2:
//    Input: nestedList = [1,[4,[6]]]
//    Output: [1,4,6]
//    Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next
//    should be: [1,4,6].
public class SolutionDay34Fourth implements Iterator<Integer> {
    Deque<NestedInteger> q;

    public SolutionDay34Fourth(List<NestedInteger> nestedList) {
        q = new ArrayDeque<>();
        for (NestedInteger ni : nestedList) {
            q.offer(ni);
        }
    }

    @Override
    public Integer next() {
        resolve();
        return q.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        resolve();
        return !q.isEmpty();
    }

    private void resolve() {
        while (!q.isEmpty() && !q.peek().isInteger()) {
            List<NestedInteger> list = q.poll().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                q.offerFirst(list.get(i));
            }
        }
    }
}