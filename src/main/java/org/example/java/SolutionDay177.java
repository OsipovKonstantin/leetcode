package org.example.java;

//    medium #string builder
//    Time complexity is O(n+m), where n is number of rows and m is the length of string
//    Space complexity is O(m)
//    https://leetcode.com/problems/zigzag-conversion
public class SolutionDay177 {
    public static String convert(String s, int numRows) {
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }
        char[] cs = s.toCharArray();
        int increment = 1;
        int curRow = 0;
        for (char c : cs) {
            arr[curRow].append(c);
            if (curRow == 0 && increment == -1) increment *= -1;
            else if (curRow == numRows - 1 && increment == 1) increment *= -1;
            if (numRows != 1) curRow += increment;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : arr) {
            ans.append(sb);
        }
        return ans.toString();
    }
}
