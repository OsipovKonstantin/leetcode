package org.example.java;

//    easy #math
//    Time complexity is O(1),because the number of iterations is limited (no more than 10-20).
//    The operations make n one-digit very quickly, so we obtain the answer in O(1)
//    Space complexity is O(1)
//    https://leetcode.com/problems/happy-number
public class SolutionDay186Second {
    public static boolean isHappy(int n) {
        int sum = n;
        while (sum != 1 && sum != 7) {
            if (sum < 10) return false;
            int temp = 0;
            while (sum != 0) {
                temp += (int) Math.pow((sum % 10), 2);
                sum /= 10;
            }
            sum = temp;
        }
        return true;
    }
}
