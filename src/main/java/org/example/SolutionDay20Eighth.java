package org.example;

//    easy. String
//    https://leetcode.com/problems/largest-3-same-digit-number-in-string
//    You are given a string num representing a large integer. An integer is good if it meets the following conditions:
//    It is a substring of num with length 3.
//    It consists of only one unique digit.
//    Return the maximum good integer as a string or an empty string "" if no such integer exists.
//    Note:
//    A substring is a contiguous sequence of characters within a string.
//    There may be leading zeroes in num or a good integer.
//    Example 1:
//    Input: num = "6777133339"
//    Output: "777"
//    Explanation: There are two distinct good integers: "777" and "333".
//    "777" is the largest, so we return "777".
//    Example 2:
//    Input: num = "2300019"
//    Output: "000"
//    Explanation: "000" is the only good integer.
//    Example 3:
//    Input: num = "42352338"
//    Output: ""
//    Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
public class SolutionDay20Eighth {
    public static String largestGoodInteger(String num) {
        int n = num.length();
        char[] charArray = num.toCharArray();
        String res = "";
        for (int i = 0; i < n - 2; i++) {
            if (charArray[i] != charArray[i + 1])
                continue;
            if (charArray[i] != charArray[i + 2])
                continue;
            if (res.equals(""))
                res = num.substring(i, i + 3);
            else
                res = res.charAt(0) < num.charAt(i) ? num.substring(i, i + 3) : res;
            i += 2;
        }
        return res;
    }
}
