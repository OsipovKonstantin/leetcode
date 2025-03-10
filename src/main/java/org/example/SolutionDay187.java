package org.example;

import java.util.*;

//    medium #sliding window
//    Time complexity is O(n), where n is the length of word string
//    Space complexity os O(1)
//    https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii
public class SolutionDay187 {
        public static long countOfSubstrings(String word, int k) {
            char[] cs = word.toCharArray();
            return atLeastK(cs, k) - atLeastK(cs, k+1);
        }

        private static long atLeastK(char[] cs, int k) {
            long ans = 0;
            int l = 0;
            Map<Character, Integer> vowelsMap = new HashMap<>();
            Set<Character> vowels = new HashSet<>(List.of('a','i','o','u','e'));
            int notVowels = 0;
            for(int r = 0; r < cs.length; r++) {
                char cur = cs[r];
                if(vowels.contains(cur)) {
                    vowelsMap.put(cur, vowelsMap.getOrDefault(cur, 0)+1);
                } else {
                    notVowels++;
                }
                while(vowelsMap.size()==5 && notVowels>=k) {
                    ans+=cs.length-r;
                    char prev = cs[l];
                    if(vowels.contains(prev)) {
                        if(vowelsMap.get(prev)==1) vowelsMap.remove(prev);
                        else vowelsMap.put(prev, vowelsMap.get(prev)-1);
                    } else {
                        notVowels--;
                    }
                    l++;
                }
            }
            return ans;
        }
}
