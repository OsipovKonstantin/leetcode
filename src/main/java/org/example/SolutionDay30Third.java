package org.example;

//    hard. Dynamic programming with pointers instead of 2D array is 3 times faster and save (n-1)*5 space
//    https://leetcode.com/problems/count-vowels-permutation
//    Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
//    Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
//    Each vowel 'a' may only be followed by an 'e'.
//    Each vowel 'e' may only be followed by an 'a' or an 'i'.
//    Each vowel 'i' may not be followed by another 'i'.
//    Each vowel 'o' may only be followed by an 'i' or a 'u'.
//    Each vowel 'u' may only be followed by an 'a'.
//    Since the answer may be too large, return it modulo 10^9 + 7.
//    Example 1:
//    Input: n = 1
//    Output: 5
//    Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
//    Example 2:
//    Input: n = 2
//    Output: 10
//    Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
//    Example 3:
//    Input: n = 5
//    Output: 68
public class SolutionDay30Third {
    public static int countVowelPermutation(int n) {
        int mod = 1000000007;
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        for (int k = 1; k < n; k++) {
            int tempA = a;
            int tempE = e;
            int tempI = i;
            int tempO = o;
            int tempU = u;
            a = tempE;
            e = (tempA + tempI) % mod;
            i = (((tempA + tempE) % mod + tempO) % mod + tempU) % mod;
            o = (tempI + tempU) % mod;
            u = tempA;
        }
        return ((((a + e) % mod + i) % mod + o) % mod + u) % mod;
    }
}
/**
 * quantity of A in word with k+1 length is equal number of E in word with length k
 * E in word with length k+1 = number of vowel A in word with previous length k + number of vowel I in word with length k
 * and so on
 **/
