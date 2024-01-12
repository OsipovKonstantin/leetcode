package org.example;

//    easy. #string; #counting vowels #one pass
//    https://leetcode.com/problems/determine-if-string-halves-are-alike
//    You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the
//    first half and b be the second half.
//    Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
//    Notice that s contains uppercase and lowercase letters.
//    Return true if a and b are alike. Otherwise, return false.
//    Example 1:
//    Input: s = "book"
//    Output: true
//    Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
//    Example 2:
//    Input: s = "textbook"
//    Output: false
//    Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
//Notice that the vowel o is counted twice.
public class SolutionDay33 {
    public static boolean halvesAreAlike(String s) {
        int diffVowels = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (checkVowel(chars[i])) {
                diffVowels++;
            }
            if (checkVowel(chars[n - i - 1])) {
                diffVowels--;
            }
        }
        return diffVowels == 0;
    }

    private static boolean checkVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
