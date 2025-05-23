package org.example.java;

//    medium #binary search Time complexity is O(logn), space complexity is O(1)
//    https://leetcode.com/problems/peak-index-in-a-mountain-array
//    An array arr is a mountain if the following properties hold:
//    arr.length >= 3
//    There exists some i with 0 < i < arr.length - 1 such that:
//    arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//    arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//    Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1]
//    > ... > arr[arr.length - 1].
//    You must solve it in O(log(arr.length)) time complexity.
//    Example 1:
//    Input: arr = [0,1,0]
//    Output: 1
//    Example 2:
//    Input: arr = [0,2,1,0]
//    Output: 1
//    Example 3:
//    Input: arr = [0,10,5,2]
//    Output: 1
public class SolutionDay65 {
    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1;
        int right = n - 2;
        while (left < right) {
            int target = left + (right - left) / 2;
            if (arr[target] > arr[target + 1]) {
                right = target;
            } else left = target + 1;
        }
        return left;
    }
}
