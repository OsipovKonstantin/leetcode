package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    medium #math
//    Time complexity is O(right*log(log(right)))
//    Space complexity is O(right)
//    https://leetcode.com/problems/closest-prime-numbers-in-range
public class SolutionDay184 {
    public static int[] closestPrimes(int left, int right) {
        boolean[] notPrime = new boolean[right + 1];
        notPrime[1] = true;
        for (int i = 2; i <= (int) Math.sqrt(right); i++) {
            if (notPrime[i]) continue;
            for (int j = i * 2; j < right + 1; j += i) {
                notPrime[j] = true;
            }
        }
        List<Integer> primes = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (!notPrime[i]) primes.add(i);
        }

        int size = primes.size();
        if (size < 2) return new int[]{-1, -1};

        int minDiff = Integer.MAX_VALUE;
        int index = 0;
        int start = 0;
        while (start < size - 1) {
            int diff = primes.get(start + 1) - primes.get(start);
            if (minDiff > diff) {
                minDiff = diff;
                index = start;
            }
            start++;
        }
        return new int[]{primes.get(index), primes.get(index + 1)};
    }
}
