package org.example;

//    easy. Pointers instead of StringBuilders. Space complexity O(1)
//    https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent
//    Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false
//    otherwise.
//    A string is represented by an array if the array elements concatenated in order forms the string.
//    Example 1:
//    Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
//    Output: true
//    Explanation:
//    word1 represents string "ab" + "c" -> "abc"
//    word2 represents string "a" + "bc" -> "abc"
//    The strings are the same, so return true.
//    Example 2:
//    Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
//    Output: false
//    Example 3:
//    Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//    Output: true
public class SolutionDay21Second {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int word1Pointer = 0;
        int word2Pointer = 0;
        int string1Pointer = 0;
        int string2Pointer = 0;
        while (word1Pointer < word1.length && word2Pointer < word2.length) {
            if (word1[word1Pointer].charAt(string1Pointer) != word2[word2Pointer].charAt(string2Pointer)) {
                return false;
            }
            string1Pointer++;
            string2Pointer++;
            if (string1Pointer == word1[word1Pointer].length()) {
                word1Pointer++;
                string1Pointer = 0;
            }
            if (string2Pointer == word2[word2Pointer].length()) {
                word2Pointer++;
                string2Pointer = 0;
            }
        }
        return word1Pointer == word1.length && word2Pointer == word2.length;
    }
}
