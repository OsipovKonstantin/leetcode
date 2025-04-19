package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    medium #Math.
//    What we use during this task: Math.pow, counting digits in the integer and getting the first digit of a number.
//    Time complexity is O(n*m), where n is the number of output numbers and m is the number of digits in the end value.
//    Space complexity is O(1) because the output data usually doesn't need to be taken into account
//    https://leetcode.com/problems/sequential-digits
//    An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
//    Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
//    Example 1:
//    Input: low = 100, high = 300
//    Output: [123,234]
//    Example 2:
//    Input: low = 1000, high = 13000
//    Output: [1234,2345,3456,4567,5678,6789,12345]
public class SolutionDay54 {
    public static List<Integer> sequentialDigits(int low, int high) {
        int[] startParams = getFirstDigitAndNumOfDigits(low);
        int firstDigit = startParams[0];
        int powOfTen = startParams[1];

        int cur = firstDigit * (int) Math.pow(10, powOfTen);
        List<Integer> ans = new ArrayList<>();
        while (cur < high) {
            if (firstDigit == 10 || firstDigit + powOfTen > 9) {
                firstDigit = 1;
                powOfTen++;
                cur = firstDigit * (int) Math.pow(10, powOfTen);
            }
            cur = firstDigit;
            for (int i = 1; i <= powOfTen; i++) {
                cur = cur * 10 + firstDigit + i;
            }
            if (cur >= low && cur <= high) {
                ans.add(cur);
            }
            firstDigit++;
        }
        return ans;
    }

    private static int[] getFirstDigitAndNumOfDigits(int num) {
        int digits = 0;
        int firstDigit = num;
        while (firstDigit >= 10) {
            firstDigit /= 10;
            digits++;
        }
        return new int[]{firstDigit, digits};
    }
}