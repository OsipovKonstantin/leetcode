package org.example.java;

//    easy #two pointers
//    Time complexity is O(n1+n2), where n1 is size of array nums1, n2 is size of array nums2
//    Space complexity is O(1)
//    https://leetcode.com/problems/minimum-common-value/
//    Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to
//    both arrays. If there is no common integer amongst nums1 and nums2, return -1.
//    Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of
//    that integer.
//    Example 1:
//    Input: nums1 = [1,2,3], nums2 = [2,4]
//    Output: 2
//    Explanation: The smallest element common to both arrays is 2, so we return 2.
//    Example 2:
//    Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
//    Output: 2
//    Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
public class SolutionDay88Second {
    public static int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int start1 = 0;
        int start2 = 0;
        while (start1 < n1 && start2 < n2) {
            if (nums1[start1] > nums2[start2]) start2++;
            else if (nums1[start1] < nums2[start2]) start1++;
            else return nums1[start1];
        }
        return -1;
    }
}
