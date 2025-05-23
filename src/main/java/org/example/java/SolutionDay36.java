package org.example.java;

import java.util.*;

//    medium. #hashmap #arraylist #sorting
//    https://leetcode.com/problems/find-players-with-zero-or-one-losses
//    You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri
//    defeated player loseri in a match.
//    Return a list answer of size 2 where:
//    answer[0] is a list of all players that have not lost any matches.
//    answer[1] is a list of all players that have lost exactly one match.
//    The values in the two lists should be returned in increasing order.
//    Note:
//    You should only consider the players that have played at least one match.
//    The testcases will be generated such that no two matches will have the same outcome.
//    Example 1:
//    Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
//    Output: [[1,2,10],[4,5,7,8]]
//    Explanation:
//    Players 1, 2, and 10 have not lost any matches.
//    Players 4, 5, 7, and 8 each have lost one match.
//    Players 3, 6, and 9 each have lost two matches.
//    Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
//    Example 2:
//    Input: matches = [[2,3],[1,3],[5,4],[6,4]]
//    Output: [[1,2,5,6],[]]
//    Explanation:
//    Players 1, 2, 5, and 6 have not lost any matches.
//    Players 3 and 4 each have lost two matches.
//    Thus, answer[0] = [1,2,5,6] and answer[1] = [].
public class SolutionDay36 {
    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loseCounter = new HashMap<>();
        for (int[] match : matches) {
            if (!loseCounter.containsKey(match[0])) {
                loseCounter.put(match[0], 0);
            }
            if (!loseCounter.containsKey(match[1])) {
                loseCounter.put(match[1], 0);
            }
            loseCounter.put(match[1], loseCounter.get(match[1]) + 1);
        }
        List<Integer> onlyWin = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();
        for (Map.Entry<Integer, Integer> es : loseCounter.entrySet()) {
            if (es.getValue() == 0) {
                onlyWin.add(es.getKey());
            } else if (es.getValue() == 1) {
                oneLose.add(es.getKey());
            }
        }
        Collections.sort(onlyWin);
        Collections.sort(oneLose);
        return new ArrayList<>(List.of(onlyWin, oneLose));
    }
}
