package org.example.java;

//    medium #math
//    Time complexity is O(logn), where n is input number
//    Space complexity is O(1)
//    https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three
public class SolutionDay181 {
    public static boolean checkPowersOfThree(int n) {
        boolean[] seen = new boolean[17];
        while (n != 0) {
            int val = 1;
            int count = 0;
            while (val * 3 <= n) {
                val *= 3;
                count++;
            }
            if (seen[count]) return false;
            n -= val;
            seen[count] = true;
        }
        return true;
    }
}
