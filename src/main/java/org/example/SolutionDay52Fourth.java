package org.example;

//    medium #prefix sum
//    https://leetcode.com/problems/minimum-penalty-for-a-shop
//     You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of
//     characters 'N' and 'Y':
//    if the ith character is 'Y', it means that customers come at the ith hour
//    whereas 'N' indicates that no customers come at the ith hour.
//    If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
//    For every hour when the shop is open and no customers come, the penalty increases by 1.
//    For every hour when the shop is closed and customers come, the penalty increases by 1.
//    Return the earliest hour at which the shop must be closed to incur a minimum penalty.
//    Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.
//    Example 1:
//    Input: customers = "YYNY"
//    Output: 2
//    Explanation:
//    - Closing the shop at the 0th hour incurs in 1+1+0+1 = 3 penalty.
//    - Closing the shop at the 1st hour incurs in 0+1+0+1 = 2 penalty.
//    - Closing the shop at the 2nd hour incurs in 0+0+0+1 = 1 penalty.
//    - Closing the shop at the 3rd hour incurs in 0+0+1+1 = 2 penalty.
//    - Closing the shop at the 4th hour incurs in 0+0+1+0 = 1 penalty.
//    Closing the shop at 2nd or 4th hour gives a minimum penalty. Since 2 is earlier, the optimal closing time is 2.
//    Example 2:
//    Input: customers = "NNNNN"
//    Output: 0
//    Explanation: It is best to close the shop at the 0th hour as no customers arrive.
//    Example 3:
//    Input: customers = "YYYY"
//    Output: 4
//    Explanation: It is best to close the shop at the 4th hour as customers arrive at each hour.
public class SolutionDay52Fourth {
    public static int bestClosingTime(String customers) {
        int n = customers.length();
        char[] cs = customers.toCharArray();
        int[] penaltyClose = new int[n + 1];
        int[] penaltyOpen = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            penaltyClose[i] = penaltyClose[i + 1] + (cs[i] == 'Y' ? 1 : 0);
        }

        for (int j = 1; j < n + 1; j++) {
            penaltyOpen[j] = penaltyOpen[j - 1] + (cs[j - 1] == 'N' ? 1 : 0);
        }
        int closingHour = 0;
        int penalty = Integer.MAX_VALUE;
        for (int k = 0; k < n + 1; k++) {
            if (penalty > penaltyOpen[k] + penaltyClose[k]) {
                penalty = penaltyOpen[k] + penaltyClose[k];
                closingHour = k;
            }
        }
        return closingHour;
    }
}
