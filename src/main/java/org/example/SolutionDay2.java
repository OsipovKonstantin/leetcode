package org.example;

//    https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
//    Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more
//    than 25% of the time, return that integer.
//    Example 1:
//    Input: arr = [1,2,2,6,6,6,6,7,10]
//    Output: 6
//    Example 2:
//    Input: arr = [1,1]
//    Output: 1
public class SolutionDay2 {
    public static int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] candidates_number = {n / 4, n / 2, n * 3 / 4};
        for (int i : candidates_number) {
            int target = arr[i];
            if (arr[lower_bound(arr, target) + n / 4] == target) {
                return target;
            }
        }
        return -1;
    }

    public static int lower_bound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
