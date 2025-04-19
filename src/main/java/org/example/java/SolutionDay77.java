package org.example.java;

//    medium (really hard) #backtracking with time complexity optimization
//    Time complexity is O(k^n), where k is number of kids and n is number of cookies
//    Space complexity is O(k+n), because we store kidsCookies with k elements and highest stack of recursion has n
//    elements
//    https://leetcode.com/problems/fair-distribution-of-cookies
//    You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag. You are
//    also given an integer k that denotes the number of children to distribute all the bags of cookies to. All the
//    cookies in the same bag must go to the same child and cannot be split up.
//    The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the
//    distribution.
//    Return the minimum unfairness of all distributions.
//    Example 1:
//    Input: cookies = [8,15,10,20,8], k = 2
//    Output: 31
//    Explanation: One optimal distribution is [8,15,8] and [10,20]
//    - The 1st child receives [8,15,8] which has a total of 8 + 15 + 8 = 31 cookies.
//    - The 2nd child receives [10,20] which has a total of 10 + 20 = 30 cookies.
//    The unfairness of the distribution is max(31,30) = 31.
//    It can be shown that there is no distribution with an unfairness less than 31.
//    Example 2:
//    Input: cookies = [6,1,3,2,2,4,1,2], k = 3
//    Output: 7
//    Explanation: One optimal distribution is [6,1], [3,2,2], and [4,1,2]
//    - The 1st child receives [6,1] which has a total of 6 + 1 = 7 cookies.
//    - The 2nd child receives [3,2,2] which has a total of 3 + 2 + 2 = 7 cookies.
//    - The 3rd child receives [4,1,2] which has a total of 4 + 1 + 2 = 7 cookies.
//    The unfairness of the distribution is max(7,7,7) = 7.
//    It can be shown that there is no distribution with an unfairness less than 7.
public class SolutionDay77 {
    public static int distributeCookies(int[] cookies, int k) {
        int[] kidsCookies = new int[k];
        return backtrack(kidsCookies, 0, cookies, k, k);
    }

    private static int backtrack(int[] kidsCookies, int index, int[] cookies, int kids, int zeroCount) {
        int n = cookies.length;
        if (n - index < zeroCount) return Integer.MAX_VALUE;
        if (index == n) {
            int max = 0;
            for (int i = 0; i < kids; i++)
                max = Math.max(max, kidsCookies[i]);
            return max;
        }
        int ans = Integer.MAX_VALUE;
        for (int kid = 0; kid < kids; kid++) {
            zeroCount -= kidsCookies[kid] == 0 ? 1 : 0;
            kidsCookies[kid] += cookies[index];
            ans = Math.min(ans, backtrack(kidsCookies, index + 1, cookies, kids, zeroCount));
            kidsCookies[kid] -= cookies[index];
            zeroCount += kidsCookies[kid] == 0 ? 1 : 0;
        }
        return ans;
    }
}
