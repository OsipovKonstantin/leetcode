package org.example;

import java.util.Arrays;

//    easy. Array custom comparator; Integer.bitCount; stream for primitives and their wrap (int[] and Integer[])
//    https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits
//    You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in
//    their binary representation and in case of two or more integers have the same number of 1's you have to sort
//    them in ascending order.
//    Return the array after sorting it.
//    Example 1:
//    Input: arr = [0,1,2,3,4,5,6,7,8]
//    Output: [0,1,2,4,8,3,5,6,7]
//    Explantion: [0] is the only integer with 0 bits.
//    [1,2,4,8] all have 1 bit.
//    [3,5,6] have 2 bits.
//    [7] has 3 bits.
//    The sorted array by bits is [0,1,2,4,8,3,5,6,7]
//    Example 2:
//    Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
//    Output: [1,2,4,8,16,32,64,128,256,512,1024]
//    Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
public class SolutionDay29Eighth {
    public static int[] sortByBits(int[] arr) {
        Integer[] ansInteger = Arrays.stream(arr).boxed().toArray(size -> new Integer[size]);
        Arrays.sort(ansInteger, (i1, i2) -> {
            int diff = Integer.bitCount(i1) - Integer.bitCount(i2);
            return diff != 0 ? diff : i1 - i2;
        });
        return Arrays.stream(ansInteger).mapToInt(i -> i).toArray();
    }
}
