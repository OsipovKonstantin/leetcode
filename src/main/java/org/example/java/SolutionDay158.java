package org.example.java;

import java.util.Arrays;

//    medium #binary search
//    Time complexity is O(n*(logn+logm)), where n is number of elements in position array and m is maximum value in
//    position array
//    Space complexity is O(logn) because of sorting
//    https://leetcode.com/problems/magnetic-force-between-two-balls
//    In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put
//    in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and
//    needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is
//    maximum.
//    Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
//    Given the integer array position and the integer m. Return the required force.
//    Example 1:
//    Input: position = [1,2,3,4,7], m = 3
//    Output: 3
//    Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs
//    [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
//    Example 2:
//    Input: position = [5,4,3,2,1,1000000000], m = 2
//    Output: 999999999
//    Explanation: We can use baskets 1 and 1000000000.
public class SolutionDay158 {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int start = 1;
        int end = position[n - 1];
        while (start < end) {
            int mid = end - (end - start) / 2;
            if (isValidDistance(position, m, mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static boolean isValidDistance(int[] position, int m, int mid) {
        int actualM = 1;
        int prevPosition = position[0];
        for (int i = 1; i < position.length; i++) {
            int curPosition = position[i];
            if (curPosition - prevPosition >= mid) {
                actualM++;
                prevPosition = curPosition;
            }
            if (actualM == m) return true;
        }
        return false;
    }
}
