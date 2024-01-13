package org.example;

//    hard. #greedy. Expanding from k left and right. Next expansion to bigger value.
//    For more detail real approach 3 in Editorial section
//    https://leetcode.com/problems/maximum-score-of-a-good-subarray/
//    You are given an array of integers nums (0-indexed) and an integer k.
//    The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1). A good subarray
//    is a subarray where i <= k <= j.
//    Return the maximum possible score of a good subarray.
//    Example 1:
//    Input: nums = [1,4,3,7,4,5], k = 3
//    Output: 15
//    Explanation: The optimal subarray is (1, 5) with a score of min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15.
//    Example 2:
//    Input: nums = [5,5,4,5,4,1,1,1], k = 0
//    Output: 20
//    Explanation: The optimal subarray is (0, 4) with a score of min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20.
public class SolutionDay34Second {
    public static int maximumScore(int[] nums, int k) {
        int ans = nums[k];
        int currMin = nums[k];
        int n = nums.length;
        int i = k;
        int j = k;
        while (i > 0 || j < n - 1) {
            if ((i - 1 < 0 ? 0 : nums[i - 1]) > (j + 1 > n - 1 ? 0 : nums[j + 1])) {
                i--;
                currMin = Math.min(currMin, nums[i]);
            } else {
                j++;
                currMin = Math.min(currMin, nums[j]);
            }
            ans = Math.max(ans, currMin * (j - i + 1));
        }
        return ans;
    }
}
