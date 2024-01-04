package org.example;

//    medium. Cantor's diagonal argument - there is a new unique number for sequence if it differ from each number by 1 digit
//    https://leetcode.com/problems/find-unique-binary-string
//    Given an array of strings nums containing n unique binary strings each of length n, return a binary string of
//    length n that does not appear in nums. If there are multiple answers, you may return any of them.
//    Example 1:
//    Input: nums = ["01","10"]
//    Output: "11"
//    Explanation: "11" does not appear in nums. "00" would also be correct.
//    Example 2:
//    Input: nums = ["00","01"]
//    Output: "11"
//    Explanation: "11" does not appear in nums. "10" would also be correct.
//    Example 3:
//    Input: nums = ["111","011","001"]
//    Output: "101"
//    Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
public class SolutionDay25Fourth {
    public static String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}
