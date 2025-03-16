package org.example;

//    medium #binary search
//    Time complexity is O(nlog(Long.MAX_VALUE)), where n is the size of ranks array
//    Space complexity is O(1)
//    https://leetcode.com/problems/minimum-time-to-repair-cars
public class SolutionDay193Second {
    public static long repairCars(int[] ranks, int cars) {
        long min = 0;
        long max = Long.MAX_VALUE;
        while (min < max) {
            long mid = min + (max - min) / 2;
            if (isValid(ranks, cars, mid)) max = mid;
            else min = mid + 1;
        }
        return min;
    }

    private static boolean isValid(int[] ranks, int cars, long minutes) {
        long repairedCars = 0;
        for (int rank : ranks) {
            repairedCars += (long) Math.sqrt((double) minutes / rank);
        }
        return repairedCars >= cars;
    }
}
