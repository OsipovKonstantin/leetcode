package org.example;

//    easy #reminder of division(%)
//    https://leetcode.com/problems/excel-sheet-column-title
//    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
//    For example:
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//    Example 1:
//    Input: columnNumber = 1
//    Output: "A"
//    Example 2:
//    Input: columnNumber = 28
//    Output: "AB"
//    Example 3:
//    Input: columnNumber = 701
//    Output: "ZY"
public class SolutionDay54Fourth {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int curNumber = columnNumber;
        while (curNumber != 0) {
            char c = (char) (curNumber % 26 == 0 ? 'Z' : curNumber % 26 - 1 + 'A');
            sb.append(c);
            curNumber = curNumber / 26 - (curNumber % 26 == 0 ? 1 : 0);
        }
        return sb.reverse().toString();
    }
}
