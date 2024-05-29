package org.example;

//    medium #string
//    Time complexity is O(n)
//    Space complexity is O(n)
//    https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
//    Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under
//    the following rules:
//    If the current number is even, you have to divide it by 2.
//    If the current number is odd, you have to add 1 to it.
//    It is guaranteed that you can always reach one for all test cases.
//    Example 1:
//    Input: s = "1101"
//    Output: 6
//    Explanation: "1101" corressponds to number 13 in their decimal representation.
//    Step 1) 13 is odd, add 1 and obtain 14.
//    Step 2) 14 is even, divide by 2 and obtain 7.
//    Step 3) 7 is odd, add 1 and obtain 8.
//    Step 4) 8 is even, divide by 2 and obtain 4.
//    Step 5) 4 is even, divide by 2 and obtain 2.
//    Step 6) 2 is even, divide by 2 and obtain 1.
//    Example 2:
//    Input: s = "10"
//    Output: 1
//    Explanation: "10" corressponds to number 2 in their decimal representation.
//    Step 1) 2 is even, divide by 2 and obtain 1.
//    Example 3:
//    Input: s = "1"
//    Output: 0
public class SolutionDay137 {
    public static int numSteps(String s) {
        if (s.length() == 1) return 0;
        if (!s.substring(1).contains("1")) return s.length() - 1;
        boolean seenOne = false;
        char[] cs = s.toCharArray();
        int ans = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (seenOne) {
                if (cs[i] == '0') ans += 2;
                else ans++;
            } else {
                if (cs[i] == '0') ans++;
                else {
                    seenOne = true;
                    ans += 2;
                }
            }
        }
        return ans;
    }
}
