package org.example.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//medium. List + Stack for traversal
//https://leetcode.com/problems/diagonal-traverse-ii
//Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
//Example 1:
//Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,4,2,7,5,3,8,6,9]
//Example 2:
//Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
//Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
public class SolutionDay23Sixth {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Stack<Integer>> resList = new ArrayList<>();
        int resSize = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (resList.size() <= i + j) {
                    resList.add(new Stack<>());
                }
                resSize++;
                resList.get(i + j).push(list.get(j));
            }
        }
        int[] res = new int[resSize];
        int pointer = 0;
        for (Stack<Integer> s : resList) {
            while (!s.empty()) {
                res[pointer] = s.pop();
                pointer++;
            }
        }
        return res;
    }
}
