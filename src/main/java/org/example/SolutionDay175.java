package org.example;

//    easy #logic Switch-case is 80 times faster than if-else in this solution (2 ms compare to 158 ms)
//    Time complexity is O(n), where n is the length of s string
//    Space complexity is O(1)
//    https://leetcode.com/problems/roman-to-integer
public class SolutionDay175 {
    public static int romanToInt(String s) {
        int len = s.length();
        int ans = 0;
        int prevVal = 0;
        for (int i = len - 1; i >= 0; i--) {
            int curVal = toInteger(s.charAt(i));
            if (curVal < prevVal) ans -= curVal;
            else ans += curVal;
            prevVal = curVal;
        }
        return ans;
    }

    public static int toInteger(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
