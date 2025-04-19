package org.example.java;

//    medium #string builder
//    Time complexity is O(1), because max value for num in task description is 3999
//    Space complexity is O(1)
//    https://leetcode.com/problems/integer-to-roman
public class SolutionDay175Third {
    public static String intToRoman(int num) {
        int digits = countDigits(num);
        StringBuilder ans = new StringBuilder();
        while (digits > 0) {
            int curDigit = num / (int) Math.pow(10, digits - 1);
            ans.append(toRoman(curDigit, digits));
            num -= curDigit * Math.pow(10, digits - 1);
            digits--;
        }
        return ans.toString();
    }

    public static int countDigits(int num) {
        if (num >= 1000) return 4;
        if (num >= 100) return 3;
        if (num >= 10) return 2;
        return 1;
    }

    public static String toRoman(int number, int digits) {
        if (digits == 4) return "M".repeat(number);

        if (number == 9) {
            if (digits == 3) return "CM";
            else if (digits == 2) return "XC";
            else if (digits == 1) return "IX";
        } else if (number == 4) {
            if (digits == 3) return "CD";
            else if (digits == 2) return "XL";
            else if (digits == 1) return "IV";
        } else if (number / 5 == 1) {
            if (digits == 3) return "D" + ("C".repeat(number - 5));
            else if (digits == 2) return "L" + ("X".repeat(number - 5));
            else if (digits == 1) return "V" + ("I".repeat(number - 5));
        } else {
            if (digits == 3) return "C".repeat(number);
            else if (digits == 2) return "X".repeat(number);
            else if (digits == 1) return "I".repeat(number);
        }
        return "";
    }
}
