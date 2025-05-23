package org.example.java;

//    easy. Math.max, Math.min, Math.abs
//    https://leetcode.com/problems/minimum-time-visiting-all-points
//    On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in
//    seconds to visit all the points in the order given by points.
//    You can move according to these rules:
//    In 1 second, you can either:
//    move vertically by one unit,
//    move horizontally by one unit, or
//    move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
//    You have to visit the points in the same order as they appear in the array.
//    You are allowed to pass through points that appear later in the order, but these do not count as visits.
//    Example 1:
//    Input: points = [[1,1],[3,4],[-1,0]]
//    Output: 7
//    Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
//    Time from [1,1] to [3,4] = 3 seconds
//    Time from [3,4] to [-1,0] = 4 seconds
//    Total time = 7 seconds
//    Example 2:
//    Input: points = [[3,2],[-2,2]]
//    Output: 5
public class SolutionDay20Ninh {
    public static int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int dx = Math.abs(points[i][0] - points[i + 1][0]);
            int dy = Math.abs(points[i][1] - points[i + 1][1]);
            //    Math.max(dx, dy) - movement diagonally plus vertically or horizontally
            //    More simply is Math.min(dx, dy) + Math.abs(dx-dy),
            //    where Math.min(dx, dy) diagonally, Math.abs(dx-dy) vertically or horizontally
            res += Math.max(dx, dy);
        }
        return res;
    }
}
