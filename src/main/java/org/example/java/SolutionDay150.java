package org.example.java;

//    easy #array #counting sort
//    Time complexity is O(m+n+1001), where n is length of arr1, m is length of arr2, 1001 is size of freq array
//    Space complexity is O(n+1001)
//    https://leetcode.com/problems/relative-sort-array
//    Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
//    Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that
//    do not appear in arr2 should be placed at the end of arr1 in ascending order.
//    Example 1:
//    Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//    Output: [2,2,2,1,4,3,3,9,6,7,19]
//    Example 2:
//    Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//    Output: [22,28,8,6,17,44]
public class SolutionDay150 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] freq = new int[1001];
        for (int el : arr1) freq[el]++;
        int[] ans = new int[n];
        int index = 0;
        for (int el : arr2) while (freq[el]-- > 0) ans[index++] = el;
        for (int i = 0; i <= 1000; i++) while (freq[i]-- > 0) ans[index++] = i;
        return ans;
    }
}
