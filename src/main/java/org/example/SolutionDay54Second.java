package org.example;

import java.util.ArrayList;
import java.util.List;

//    hard(really medium) #simulation
//    https://leetcode.com/problems/text-justification
//    Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth
//    characters and is fully (left and right) justified.
//    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
//    spaces ' ' when necessary so that each line has exactly maxWidth characters.
//    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does
//    not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the
//    right.
//    For the last line of text, it should be left-justified, and no extra space is inserted between words.
//    Note:
//    A word is defined as a character sequence consisting of non-space characters only.
//    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//    The input array words contains at least one word.
//    Example 1:
//    Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
//    Output:
//    [
//       "This    is    an",
//       "example  of text",
//       "justification.  "
//    ]
//    Example 2:
//    Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
//    Output:
//    [
//      "What   must   be",
//      "acknowledgment  ",
//      "shall be        "
//    ]
//    Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be
//    left-justified instead of fully-justified.
//    Note that the second line is also left-justified because it contains only one word.
//    Example 3:
//    Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art",
//    "is","everything","else","we","do"], maxWidth = 20
//    Output:
//    [
//      "Science  is  what we",
//      "understand      well",
//      "enough to explain to",
//      "a  computer.  Art is",
//      "everything  else  we",
//      "do                  "
//    ]
public class SolutionDay54Second {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        List<String> temp = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (counter + words[i].length() > maxWidth) {
                int extraSpaces = maxWidth;
                for (String word : temp) {
                    extraSpaces = extraSpaces - word.length();
                }
                for (int j = 0; j < temp.size() - 1; j++) {
                    sb.append(temp.get(j));
                    int curSpaces = extraSpaces / (temp.size() - 1 - j) + (extraSpaces % (temp.size() - 1 - j) == 0 ? 0 : 1);
                    extraSpaces -= curSpaces;
                    for (int k = 0; k < curSpaces; k++) {
                        sb.append(" ");
                    }
                }
                sb.append(temp.get(temp.size() - 1));
                if (extraSpaces > 0) {
                    for (int o = 0; o < extraSpaces; o++) {
                        sb.append(" ");
                    }
                }
                ans.add(sb.toString());
                sb = new StringBuilder();
                temp = new ArrayList<>();
                counter = 0;
            }
            temp.add(words[i]);
            counter += words[i].length() + 1;
        }
        if (temp.size() != 0) {
            for (int l = 0; l < temp.size() - 1; l++) {
                sb.append(temp.get(l) + " ");
            }
            sb.append(temp.get(temp.size() - 1));
            int leftExtraSpaces = maxWidth - sb.length();
            for (int h = 0; h < leftExtraSpaces; h++) {
                sb.append(" ");
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
