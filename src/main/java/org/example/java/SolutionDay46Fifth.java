package org.example.java;

//    hard (really medium) #combinatoric (combination)
//    https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options
//    Given n orders, each order consists of a pickup and a delivery service.
//    Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
//    Since the answer may be too large, return it modulo 10^9 + 7.
//    Example 1:
//    Input: n = 1
//    Output: 1
//    Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
//    Example 2:
//    Input: n = 2
//    Output: 6
//    Explanation: All possible orders:
//    (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
//    This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
//    Example 3:
//    Input: n = 3
//    Output: 90
public class SolutionDay46Fifth {
    public static int countOrders(int n) {
        int mod = 1000000007;
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            int combination = i * 2 * (i * 2 - 1) / 2;
            ans = (ans * combination) % mod;
        }
        return (int) ans;
    }
}
