package org.example;

import java.util.Arrays;
import java.util.List;

import static org.example.SolutionDay1.twoSum;
import static org.example.SolutionDay2.findSpecialInteger;
import static org.example.SolutionDay3.maxProduct;
import static org.example.SolutionDay4.numSpecial;
import static org.example.SolutionDay5.destCity;
import static org.example.SolutionDay6.isAnagram;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 6, 3, 10}, 9)));
        System.out.println(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(maxProduct(new int[]{1, 5, 4, 5}));
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(destCity(List.of(List.of("London", "New York"), List.of("New York", "Lima"), List.of("Lima", "Sao Paulo"))));
        System.out.println(isAnagram("anagram", "nagaram") + "; " + isAnagram("rat", "car"));
    }
}