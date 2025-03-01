package org.example;

//    medium #two pointers
//    Time complexity is O(n), where n is the size of numbers array
//    Space complexity is O(1)
//    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
public class SolutionDay178Second {
    public static int[] twoSum(int[] numbers, int target) {
        int f = 0;
        int l = numbers.length - 1;
        while (f < l) {
            int sum = numbers[f] + numbers[l];
            if (sum > target) l--;
            else if (sum < target) f++;
            else return new int[]{f + 1, l + 1};
        }
        return new int[]{0, 0};
    }
}
