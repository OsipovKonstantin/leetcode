package org.example;

import java.util.List;

//    medium #Boyer-Moore majority vote algorithm #prefix sum
//    Time complexity is O(n), where n is the size of nums list
//    Space complexity is O(1)
//    https://leetcode.com/problems/minimum-index-of-a-valid-split
public class SolutionDay199 {
    public static int minimumIndex(List<Integer> nums) {
        int len = nums.size();
        int threshold = len % 2 == 0 ? len / 2 + 1 : len / 2 + 2;
        int dominant = -1;
        int counter = 0;
        for (Integer num : nums) {
            if (counter == 0) {
                dominant = num;
                counter++;
            } else if (num == dominant) {
                counter++;
            } else {
                counter--;
            }
        }

        int counterEnd = 0;
        for (int num : nums) if (num == dominant) counterEnd++;
        if (counterEnd < threshold) return -1;
        int counterStart = 0;
        for (int i = 0; i < len; i++) {
            counterEnd -= nums.get(i) == dominant ? 1 : 0;
            counterStart += nums.get(i) == dominant ? 1 : 0;
            if (counterStart > (i + 1) / 2 && counterEnd > (len - i - 1) / 2) return i;
        }
        return -1;
    }
}
