package org.example.java;

//    medium #xor (bit manipulation)
//    Time complexity is O(n^2)
//    Space complexity is O(1)
//    https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
//    Given an array of integers arr.
//    We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
//    Let's define a and b as follows:
//    a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
//    b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
//    Note that ^ denotes the bitwise-xor operation.
//    Return the number of triplets (i, j and k) Where a == b.
//    Example 1:
//    Input: arr = [2,3,1,6,7]
//    Output: 4
//    Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
//    Example 2:
//    Input: arr = [1,1,1,1,1]
//    Output: 10
//    Constraints:
//    1 <= arr.length <= 300
//    1 <= arr[i] <= 108
public class SolutionDay138 {
    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int curXor = arr[i];
            for (int k = i + 1; k < n; k++) {
                curXor ^= arr[k];
                if (curXor == 0) ans += k - i;
            }
        }
        return ans;
    }
}
