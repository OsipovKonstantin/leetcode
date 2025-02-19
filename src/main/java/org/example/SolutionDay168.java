package org.example;

//    easy #two pointers
//    Time complexity is O(m+n) where m is size of nums1 array and n is size of nums2 array
//    Space complexity is O(m+n) because of array nums with size m+n
//    https://leetcode.com/problems/merge-sorted-array/description/
public class SolutionDay168 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[n+m];
        int firstIndex = 0;
        int secondIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(firstIndex==m) {
                nums[i]=nums2[secondIndex++];
                continue;
            }
            if(secondIndex==n) {
                nums[i]=nums1[firstIndex++];
                continue;
            }
            if(nums1[firstIndex]>=nums2[secondIndex]) {
                nums[i]=nums2[secondIndex++];
            } else {
                nums[i]=nums1[firstIndex++];
            }
        }
        for(int i = 0; i < n+m; i++) {
            nums1[i]=nums[i];
        }
    }
}
