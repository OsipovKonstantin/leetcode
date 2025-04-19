package org.example.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//    hard. #sorting #unique elements after sorting #binary search
//    You are given an integer array nums. In one operation, you can replace any element in nums with any integer.
//    nums is considered continuous if both of the following conditions are fulfilled:
//    All elements in nums are unique.
//    The difference between the maximum element and the minimum element in nums equals nums.length - 1.
//    For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.
//    Return the minimum number of operations to make nums continuous.
//    Example 1:
//    Input: nums = [4,2,5,3]
//    Output: 0
//    Explanation: nums is already continuous.
//    Example 2:
//    Input: nums = [1,2,3,5,6]
//    Output: 1
//    Explanation: One possible solution is to change the last element to 4.
//    The resulting array is [1,2,3,5,4], which is continuous.
//    Example 3:
//    Input: nums = [1,10,100,1000]
//    Output: 3
//    Explanation: One possible solution is to:
//    - Change the second element to 2.
//    - Change the third element to 3.
//    - Change the fourth element to 4.
//    The resulting array is [1,2,3,4], which is continuous.
public class SolutionDay37Fourth {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> numsList = new ArrayList<>();
        numsList.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                numsList.add(nums[i]);
            }
        }
        int m = numsList.size();
        int[] numsArr = new int[m];
        for (int i = 0; i < m; i++) {
            numsArr[i] = numsList.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < m; k++) {
            int target = numsArr[k] + n - 1;
            int len = findRight(numsArr, k, target) - k;
            ans = Math.min(ans, n - len);
        }
        return ans;
    }

    private static int findRight(int[] numsArr, int left, int target) {
        int right = numsArr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            int val = numsArr[mid];
            if (val > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
