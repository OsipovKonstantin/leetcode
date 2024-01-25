package org.example;

//    hard (really easy) #array. We traverse 2 ways to find answer
//    https://leetcode.com/problems/candy
//    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
//    You are giving candies to these children subjected to the following requirements:
//    Each child must have at least one candy.
//    Children with a higher rating get more candies than their neighbors.
//    Return the minimum number of candies you need to have to distribute the candies to the children.
//    Example 1:
//    Input: ratings = [1,0,2]
//    Output: 5
//    Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
//    Example 2:
//    Input: ratings = [1,2,2]
//    Output: 4
//    Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//    The third child gets 1 candy because it satisfies the above two conditions.
public class SolutionDay46Second {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 0;
        }
        int ans = n + left[n - 1];
        int right = 0;
        for (int j = n - 2; j >= 0; j--) {
            right = ratings[j] > ratings[j + 1] ? right + 1 : 0;
            ans += Math.max(left[j], right);
        }
        return ans;
    }
}