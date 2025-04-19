package org.example.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    medium #trie
//    Time complexity is O(n*m+l), where n is number of words in dictionary, m is average length of word in dictionary,
//    l is length of sentence
//    Space complexity is (n*m+l)
//    https://leetcode.com/problems/replace-words
//    In English, we have a concept called root, which can be followed by some other word to form another longer word
//    - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form
//    a derivative "helpful".
//    Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all
//    the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root,
//    replace it with the root that has the shortest length.
//    Return the sentence after the replacement.
//    Example 1:
//    Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
//    Output: "the cat was rat by the bat"
//    Example 2:
//    Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//    Output: "a a b c"
public class SolutionDay146 {
    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie2 root = new Trie2();
        for (String word : dictionary) {
            root.insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            ans.append(root.getShort(words[i]));
            if (i != words.length - 1) ans.append(" ");

        }
        return ans.toString();
    }

}

class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> children;

    public TrieNode() {
        isEnd = false;
        children = new HashMap<>();
    }
}

class Trie2 {
    TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur.children.computeIfAbsent(c, key -> new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }

    public String getShort(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                return word;
            }
            cur = cur.children.get(c);
            if (cur.isEnd) return word.substring(0, i + 1);
        }
        return word;
    }
}
