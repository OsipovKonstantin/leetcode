package org.example;

//    hard #dynamic programming
//    Time complexity is O(m*n*min(m,n)), where m is the length of str1 string and n is the length of str2 string
//    Space complexity is O(m*n)
//    https://leetcode.com/problems/shortest-common-supersequence
public class SolutionDay177Third {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int rows = str1.length();
        int cols = str2.length();
        String[] prevRow = new String[cols + 1];
        String[] curRow = new String[cols + 1];
        for (int col = cols; col >= 0; col--) {
            prevRow[col] = str2.substring(col);
        }
        for (int row = rows - 1; row >= 0; row--) {
            curRow = new String[cols + 1];
            curRow[cols] = str1.substring(row);
            for (int col = cols - 1; col >= 0; col--) {
                if (str1.charAt(row) == str2.charAt(col)) curRow[col] = str1.charAt(row) + prevRow[col + 1];
                else if (curRow[col + 1].length() > prevRow[col].length()) {
                    curRow[col] = str1.charAt(row) + prevRow[col];
                } else curRow[col] = str2.charAt(col) + curRow[col + 1];
            }
            prevRow = curRow;
        }
        return curRow[0];
    }
}
