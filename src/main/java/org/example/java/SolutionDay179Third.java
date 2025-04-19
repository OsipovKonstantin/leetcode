package org.example.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//medium #sorting #two pointers
//Time complexity is O(nlogn+n^2) or O(n^2), where n is the size of nums array.
//O(nlogn) comes from the sorting and O(n^2) is due to the 2 loops
//The space complexity is O(logn)
//because, by default, in Java, Arrays.soft uses QuickSort which has a space complexity of O(logn)
public class SolutionDay179Third {
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            int first = nums[i];
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int second = nums[start];
                int third = nums[end];
                int sum = first + second + third;
                if (sum == 0) {
                    ans.add(List.of(first, second, third));
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
            while (i < len - 2 && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }
}
