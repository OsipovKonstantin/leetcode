package org.example;

//    easy #array
//    Time complexity is O(n), where n is length of arr
//    Space complexity is O(1)
//    https://leetcode.com/problems/three-consecutive-odds
//    Given an integer array arr, return true if there are three consecutive odd numbers in the array.
//    Otherwise, return false.
//    Example 1:
//    Input: arr = [2,6,4,1]
//    Output: false
//    Explanation: There are no three consecutive odds.
//    Example 2:
//    Input: arr = [1,2,34,3,4,5,7,23,12]
//    Output: true
//    Explanation: [5,7,23] are three consecutive odds.
public class SolutionDay163Second {
    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 1) count++;
            else count = 0;
            if (count == 3) return true;
        }
        return false;
    }
}
