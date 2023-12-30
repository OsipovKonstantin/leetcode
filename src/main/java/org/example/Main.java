package org.example;

import java.util.Arrays;
import java.util.List;

import static org.example.SolutionDay1.twoSum;
import static org.example.SolutionDay10.buyChoco;
import static org.example.SolutionDay11.maxWidthOfVerticalArea;
import static org.example.SolutionDay12.maxScore;
import static org.example.SolutionDay13.isPathCrossing;
import static org.example.SolutionDay14.minOperations;
import static org.example.SolutionDay15.numDecodings;
import static org.example.SolutionDay16.numRollsToTarget;
import static org.example.SolutionDay17.minCost;
import static org.example.SolutionDay18.getLengthOfOptimalCompression;
import static org.example.SolutionDay19.minDifficulty;
import static org.example.SolutionDay2.findSpecialInteger;
import static org.example.SolutionDay20.makeEqual;
import static org.example.SolutionDay20Eighth.largestGoodInteger;
import static org.example.SolutionDay20Fifth.largestOddNumber;
import static org.example.SolutionDay20Fourth.tree2str;
import static org.example.SolutionDay20Second.transpose;
import static org.example.SolutionDay20Seventh.numberOfMatches;
import static org.example.SolutionDay20Sixth.totalMoney;
import static org.example.SolutionDay20Third.inorderTraversal;
import static org.example.SolutionDay3.maxProduct;
import static org.example.SolutionDay4.numSpecial;
import static org.example.SolutionDay5.destCity;
import static org.example.SolutionDay6.isAnagram;
import static org.example.SolutionDay8.maxProductDifference;
import static org.example.SolutionDay9.imageSmoother;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 6, 3, 10}, 9)));
        System.out.println(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(maxProduct(new int[]{1, 5, 4, 5}));
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(destCity(List.of(List.of("London", "New York"), List.of("New York", "Lima"), List.of("Lima", "Sao Paulo"))));
        System.out.println(isAnagram("anagram", "nagaram") + "; " + isAnagram("rat", "car"));

        SolutionDay7FoodRatings foodRatings = new SolutionDay7FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        System.out.print(foodRatings.highestRated("korean") + "; ");
        System.out.print(foodRatings.highestRated("japanese") + "; ");
        foodRatings.changeRating("sushi", 16);
        System.out.print(foodRatings.highestRated("japanese") + "; ");
        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese"));
        System.out.println(maxProductDifference(new int[]{5, 6, 2, 7, 4}));
        System.out.println(Arrays.deepToString(imageSmoother(new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}})));
        System.out.println(buyChoco(new int[]{3, 2, 3}, 3));
        System.out.println(maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
        System.out.println(maxScore("1111"));
        System.out.println(isPathCrossing("NESWW"));
        System.out.println(minOperations("0100"));
        System.out.println(numDecodings("226"));
        System.out.println(numRollsToTarget(2, 6, 7));
        System.out.println(minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        System.out.println(getLengthOfOptimalCompression("aabbaa", 2));
        System.out.println(minDifficulty(new int[]{1, 7, 1, 7, 1}, 3));
        System.out.println(makeEqual(new String[]{"abc", "aabc", "bc"}));
        System.out.println(Arrays.deepToString(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));
        System.out.println(inorderTraversal(
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null))));
        System.out.println(tree2str(
                new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), null),
                        new TreeNode(3, null, null))));
        System.out.println(largestOddNumber("52"));
        System.out.println(totalMoney(20));
        System.out.println(numberOfMatches(14));
        System.out.println(largestGoodInteger("6777133339"));
    }
}