package org.example;

//    hard #dynamic programming #combinatorics. Tabulation approach without and with optimization of space complexity
//    Time complexity is O(n*m), where n is number of unique songs, m or goal is number of songs that person will listen
//    https://leetcode.com/problems/number-of-music-playlists
//    Your music player contains n different songs. You want to listen to goal songs (not necessarily different) during
//    your trip. To avoid boredom, you will create a playlist so that:
//    Every song is played at least once.
//    A song can only be played again only if k other songs have been played.
//    Given n, goal, and k, return the number of possible playlists that you can create. Since the answer can be very
//    large, return it modulo 109 + 7.
//    Example 1:
//    Input: n = 3, goal = 3, k = 1
//    Output: 6
//    Explanation: There are 6 possible playlists: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], and [3, 2, 1].
//    Example 2:
//    Input: n = 2, goal = 3, k = 0
//    Output: 6
//    Explanation: There are 6 possible playlists: [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 2, 1], [2, 1, 2], and [1, 2, 2].
//    Example 3:
//    Input: n = 2, goal = 3, k = 1
//    Output: 2
//    Explanation: There are 2 possible playlists: [1, 2, 1] and [2, 1, 2].
public class SolutionDay59Second {
    public static int numMusicPlaylists(int n, int goal, int k) {
        long mod = 1000000007;
        long[][] dp = new long[n + 1][goal + 1];
        dp[0][0] = 1;
        for (int row = 1; row < n + 1; row++) {
            dp[row][row] = (dp[row - 1][row - 1] * row) % mod;
            for (int col = row + 1; col < goal + 1; col++)
                dp[row][col] = ((dp[row - 1][col - 1] * row) % mod + (dp[row][col - 1] * Math.max(0, row - k)) % mod) % mod;
        }
        return (int) dp[n][goal];
    }
}

//with space optimization. Use 1D arrays prev and cur instead of 2D array dp
//    public int numMusicPlaylists(int n, int goal, int k) {
//        long mod = 1000000007;
//        long[] prev = new long[goal+1];
//        long[] cur = new long[goal+1];
//        prev[0] = 1;
//        for(int row = 1; row < n+1; row++) {
//            cur[row] = (prev[row-1]*row)%mod;
//            for(int col = row+1; col < goal+1; col++) {
//                cur[col] = ((prev[col-1]*row)%mod+(cur[col-1]*Math.max(0, row-k))%mod)%mod;
//            }
//            prev = cur;
//            cur = new long[goal+1];
//        }
//        return (int)prev[goal];
//    }