package org.example;

//    medium #prefix sum #counting
//    Time complexity is O(n), where n is the size of arr array
//    Space complexity is O(1)
//    https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum
public class SolutionDay174Second {
    public static int numOfSubarrays(int[] arr) {
        int len = arr.length;
        int odds = 0;
        int evens = 0;
        int curSum = 0;
        int count = 0;
        int mod = 1000000007;
        for (int i = 0; i < len; i++) {
            curSum += arr[i];
            if (curSum % 2 == 0) {
                count = (count + odds) % mod;
                evens++;
            } else {
                count = (count + evens + 1) % mod;
                odds++;
            }
        }
        return count;
    }
}
