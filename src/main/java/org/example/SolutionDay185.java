package org.example;

//    easy #string #sliding window
//    Time complexity is O(n), where n is the length of blocks string
//    Space complexity is O(n) due to the cs array
//    https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks
public class SolutionDay185 {
    public static int minimumRecolors(String blocks, int k) {
        char[] cs = blocks.toCharArray();
        int minW = 0;
        int start = 0;
        int curW = 0;
        for (int end = 0; end < cs.length; end++) {
            if (end < k) {
                if (cs[end] == 'W') curW++;
                minW = curW;
                continue;
            }
            if (cs[start] == 'W') curW--;
            start++;
            if (cs[end] == 'W') curW++;
            minW = Math.min(minW, curW);
        }
        return minW;
    }
}
