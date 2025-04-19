package org.example.java;

//    medium #binary search
//    Time complexity is O(nlogn), where n is the size of candies array
//    Space complexity is O(1)
//    https://leetcode.com/problems/maximum-candies-allocated-to-k-children
public class SolutionDay191 {
    public static int maximumCandies(int[] candies, long k) {
        int max = 0;
        for (int pill : candies) {
            max = Math.max(max, pill);
        }
        int min = 0;
        while (min < max) {
            int mid = max - (max - min) / 2;
            if (isValid(candies, k, mid)) min = mid;
            else max = mid - 1;
        }
        return min;
    }

    private static boolean isValid(int[] candies, long k, int curPile) {
        long children = 0;
        for (int pile : candies) {
            children += pile / curPile;
        }
        return children >= k;
    }
}
