package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    hard  #bitmask (solution of this task only with bitmask) #dynamic programming. Recursive approach with memoization
//    Time complexity is O(2^n) or so. Space complexity is O(2^n) to store 1D array memo
//    https://leetcode.com/problems/smallest-sufficient-team
//    In a project, you have a list of required skills req_skills, and a list of people. The ith person people[i]
//    contains a list of skills that the person has.
//    Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least
//    one person in the team who has that skill. We can represent these teams by the index of each person.
//    For example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
//    Return any sufficient team of the smallest possible size, represented by the index of each person. You may return
//    the answer in any order.
//    It is guaranteed an answer exists.
//    Example 1:
//    Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
//    Output: [0,2]
//    Example 2:
//    Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],
//    ["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
//    Output: [1,2]
public class SolutionDay69Third {
    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        long n = req_skills.length;
        long m = people.size();
        Map<String, Long> requiredMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            requiredMap.put(req_skills[i], 1L << i);
        Map<Long, Integer> peopleMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            List<String> person = people.get(i);
            int bitSkills = 0;
            for (int j = 0; j < person.size(); j++) {
                String skill = person.get(j);
                bitSkills += requiredMap.get(skill);
            }
            peopleMap.put(1L << i, bitSkills);
        }
        long[] memo = new long[1 << n];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        long bitAns = traverse((1 << n) - 1, peopleMap, memo);
        int[] ans = new int[Long.bitCount(bitAns)];
        int pointer = 0;
        for (int i = 0; i < m; i++) {
            if (((bitAns >> i) & 1) == 1) {
                ans[pointer] = i;
                pointer++;
            }
        }
        return ans;
    }

    private static long traverse(int bitSkills, Map<Long, Integer> peopleMap, long[] memo) {
        if (memo[bitSkills] != -1) return memo[bitSkills];
        long team = (1L << peopleMap.size()) - 1;
        for (Map.Entry<Long, Integer> es : peopleMap.entrySet()) {
            int nextBitSkills = bitSkills & ~es.getValue();
            if (nextBitSkills == bitSkills) continue;
            long biggerTeam = es.getKey() + traverse(nextBitSkills, peopleMap, memo);
            team = Long.bitCount(team) < Long.bitCount(biggerTeam) ? team : biggerTeam;
        }
        memo[bitSkills] = team;
        return memo[bitSkills];
    }
}
