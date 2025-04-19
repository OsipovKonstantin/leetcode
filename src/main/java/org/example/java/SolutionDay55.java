package org.example.java;

import java.util.*;

//    hard (really hard, but comments in code help to understand intuition) #topological sort
//    Spent 4 hours to do it. If you want to understand topological sort, you should try another task, not this one!
//    It is too long and there is a combination of two topological sorts (by item and by group)
//    https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies
//    There are n items each belonging to zero or one of m groups where group[i] is the group that the i-th item
//    belongs to and it's equal to -1 if the i-th item belongs to no group. The items and the groups are zero indexed.
//    A group can have no item belonging to it.
//    Return a sorted list of the items such that:
//    The items that belong to the same group are next to each other in the sorted list.
//    There are some relations between these items where beforeItems[i] is a list containing all the items that should
//    come before the i-th item in the sorted array (to the left of the i-th item).
//    Return any solution if there is more than one solution and return an empty list if there is no solution.
//    Example 1:
//    Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
//    Output: [6,3,4,1,5,2,0,7]
//    Example 2:
//    Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
//    Output: []
//    Explanation: This is the same as example 1 except that 4 needs to be before 6 in the sorted list.
public class SolutionDay55 {
    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        int[] itemIndegrees = new int[n];
        int groupSize = m;
        for (int i = 0; i < n; i++)
            if (group[i] == -1) group[i] = groupSize++;
        Set<Integer> groups = new HashSet<>();
        for (int element : group) {
            groups.add(element);
        }
        groupSize = groups.size();
        Map<Integer, Integer> groupIndegrees = new HashMap<>();
        //create item and group graphs
        for (int j = 0; j < n; j++) {
            if (beforeItems.get(j).size() == 0) continue;
            List<Integer> befores = beforeItems.get(j);
            for (int before : befores) {
                itemGraph.computeIfAbsent(before, key -> new ArrayList<>()).add(j);
                if (group[before] != group[j]
                        && (!groupGraph.containsKey(group[before])
                        || !groupGraph.get(group[before]).contains((Integer) group[j]))) {
                    groupGraph.computeIfAbsent(group[before], key -> new ArrayList<>()).add(group[j]);
                }
            }
        }

        //fill item and group indegrees
        for (List<Integer> itemList : itemGraph.values())
            for (int curItem : itemList)
                itemIndegrees[curItem]++;
        for (int curGroup : groups) {
            groupIndegrees.put(curGroup, 0);
        }
        for (List<Integer> groupList : groupGraph.values())
            for (int curGroup : groupList)
                groupIndegrees.put(curGroup, groupIndegrees.get(curGroup) + 1);

        //use item graph and indegrees to make a sorted list of items
        int[] sortedItems = new int[n];
        Arrays.fill(sortedItems, -1);
        int firstCounter = 0;
        Set<Integer> itemVisited = new HashSet<>();
        boolean found = true;
        while (found) {
            found = false;
            for (int k = 0; k < n; k++) {
                if (itemIndegrees[k] == 0 && !itemVisited.contains(k)) {
                    sortedItems[firstCounter] = k;
                    firstCounter++;
                    itemVisited.add(k);
                    found = true;
                    if (itemGraph.containsKey(k))
                        for (int curItem : itemGraph.get(k))
                            itemIndegrees[curItem]--;
                }
            }
            if (found == false) break;
        }
        for (int item : sortedItems) {
            if (item == -1) {
                return new int[]{};
            }
        }

        //use group graph and indegrees to make a sorted list of groups
        int[] sortedGroups = new int[groupSize];
        Arrays.fill(sortedGroups, -1);
        int secondCounter = 0;
        Set<Integer> groupVisited = new HashSet<>();
        found = true;
        while (found) {
            found = false;
            for (int element : groups) {
                if (groupIndegrees.get(element) == 0 && !groupVisited.contains(element)) {
                    sortedGroups[secondCounter] = element;
                    secondCounter++;
                    groupVisited.add(element);
                    found = true;
                    if (groupGraph.containsKey(element)) {
                        for (int curGroup : groupGraph.get(element)) {
                            groupIndegrees.put(curGroup, groupIndegrees.get(curGroup) - 1);
                        }
                    }
                }
            }
            if (found == false) break;
        }
        for (int element : sortedGroups) {
            if (element == -1) {
                return new int[]{};
            }
        }

        //create map, where key - group id, value - list of sorted items
        Map<Integer, List<Integer>> groupSortedItems = new HashMap<>();
        for (int currentItem : sortedItems) {
            groupSortedItems.computeIfAbsent(group[currentItem], key -> new ArrayList<>()).add(currentItem);
        }


        //iterate by groups and get for each group sorted items, add them to final array
        int[] ans = new int[n];
        int counter = 0;
        for (int e = 0; e < groupSize; e++) {
            int curGroup = sortedGroups[e];
            for (int curItem : groupSortedItems.get(curGroup)) {
                ans[counter] = curItem;
                counter++;
            }
        }
        return ans;
    }
}