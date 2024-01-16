package org.example;

import java.util.ArrayList;
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
import static org.example.SolutionDay20Ninh.minTimeToVisitAllPoints;
import static org.example.SolutionDay20Second.transpose;
import static org.example.SolutionDay20Seventh.numberOfMatches;
import static org.example.SolutionDay20Sixth.totalMoney;
import static org.example.SolutionDay20Tenth.countCharacters;
import static org.example.SolutionDay20Third.inorderTraversal;
import static org.example.SolutionDay21.maxLengthBetweenEqualCharacters;
import static org.example.SolutionDay21Fourth.hammingWeight;
import static org.example.SolutionDay21Second.arrayStringsAreEqual;
import static org.example.SolutionDay21Third.minimumOneBitOperations;
import static org.example.SolutionDay22.findContentChildren;
import static org.example.SolutionDay22Second.numberOfWays;
import static org.example.SolutionDay22Third.knightDialer;
import static org.example.SolutionDay23.largestSubmatrix;
import static org.example.SolutionDay23Fifth.checkArithmeticSubarrays;
import static org.example.SolutionDay23Fourth.maxCoins;
import static org.example.SolutionDay23Second.findMatrix;
import static org.example.SolutionDay23Sixth.findDiagonalOrder;
import static org.example.SolutionDay23Third.getSumAbsoluteDifferences;
import static org.example.SolutionDay24.numberOfBeams;
import static org.example.SolutionDay24Fourth.reductionOperations;
import static org.example.SolutionDay24Second.countNicePairs;
import static org.example.SolutionDay24Third.garbageCollection;
import static org.example.SolutionDay25.maxFrequency;
import static org.example.SolutionDay25Fifth.maximumElementAfterDecrementingAndRearranging;
import static org.example.SolutionDay25Fourth.findDifferentBinaryString;
import static org.example.SolutionDay25Sixth.countPalindromicSubsequence;
import static org.example.SolutionDay25Third.minPairSum;
import static org.example.SolutionDay26.sortVowels;
import static org.example.SolutionDay26Second.lengthOfLIS;
import static org.example.SolutionDay26Third.numBusesToDestination;
import static org.example.SolutionDay27.jobScheduling;
import static org.example.SolutionDay28.restoreArray;
import static org.example.SolutionDay28Fifth.eliminateMaximum;
import static org.example.SolutionDay28Fourth.isReachableAtTime;
import static org.example.SolutionDay28Second.numberOfArithmeticSlices;
import static org.example.SolutionDay28Third.countHomogenous;
import static org.example.SolutionDay29.rangeSumBST;
import static org.example.SolutionDay29Eighth.sortByBits;
import static org.example.SolutionDay29Fifth.averageOfSubtree;
import static org.example.SolutionDay29Fourth.buildArray;
import static org.example.SolutionDay29Second.getWinner;
import static org.example.SolutionDay29Seventh.findArray;
import static org.example.SolutionDay29Sixth.findMode;
import static org.example.SolutionDay29Third.getLastMoment;
import static org.example.SolutionDay3.maxProduct;
import static org.example.SolutionDay30.leafSimilar;
import static org.example.SolutionDay30Fourth.longestPalindrome;
import static org.example.SolutionDay30Second.poorPigs;
import static org.example.SolutionDay30Third.countVowelPermutation;
import static org.example.SolutionDay31.amountOfTime;
import static org.example.SolutionDay32.maxAncestorDiff;
import static org.example.SolutionDay32Second.numFactoredBinaryTrees;
import static org.example.SolutionDay33.halvesAreAlike;
import static org.example.SolutionDay33Fourth.isPowerOfFour;
import static org.example.SolutionDay33Second.kthGrammar;
import static org.example.SolutionDay33Third.largestValues;
import static org.example.SolutionDay34.minSteps;
import static org.example.SolutionDay34Fifth.backspaceCompare;
import static org.example.SolutionDay34Second.maximumScore;
import static org.example.SolutionDay34Third.constrainedSubsetSum;
import static org.example.SolutionDay35.minimumTime;
import static org.example.SolutionDay35Fifth.getRow;
import static org.example.SolutionDay35Fourth.onesMinusZeros;
import static org.example.SolutionDay35Second.closeStrings;
import static org.example.SolutionDay35Third.validateBinaryTreeNodes;
import static org.example.SolutionDay36.findWinners;
import static org.example.SolutionDay36Fourth.minCostClimbingStairs;
import static org.example.SolutionDay36Second.numWays;
import static org.example.SolutionDay36Third.paintWalls;
import static org.example.SolutionDay37.findInMountainArray;
import static org.example.SolutionDay37Third.fullBloomFlowers;
import static org.example.SolutionDay4.numSpecial;
import static org.example.SolutionDay5.destCity;
import static org.example.SolutionDay6.isAnagram;
import static org.example.SolutionDay8.maxProductDifference;
import static org.example.SolutionDay9.imageSmoother;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

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
        System.out.println(minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
        System.out.println(countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
        System.out.println(maxLengthBetweenEqualCharacters("abca"));
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(minimumOneBitOperations(6));
        System.out.println(hammingWeight(-3));
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(numberOfWays("SSPPSPSPPPPSSSPSPPSPPSPPSS"));
        System.out.println(knightDialer(3131));
        System.out.println(largestSubmatrix(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}}));
        System.out.println(findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10})));
        System.out.println(maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
        System.out.println(checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
        System.out.println(Arrays.toString(findDiagonalOrder(List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7),
                List.of(8), List.of(9, 10, 11), List.of(12, 13, 14, 15, 16)))));
        System.out.println(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
        System.out.println(countNicePairs(new int[]{13, 10, 35, 24, 76}));
        System.out.println(garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}));
        System.out.println(reductionOperations(new int[]{1, 1, 2, 2, 3}));
        System.out.println(maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(SolutionDay25Second.minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
        System.out.println(minPairSum(new int[]{3, 5, 2, 3}));
        System.out.println(findDifferentBinaryString(new String[]{"111", "011", "001"}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 100}));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
        System.out.println(sortVowels("lEetcOde"));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
        System.out.println(jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));

        SolutionDay27Second.Graph graph =
                new SolutionDay27Second.Graph(4, new int[][]{{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}});
        int firstPath = graph.shortestPath(3, 2);
        int secondPath = graph.shortestPath(0, 3);
        graph.addEdge(new int[]{1, 3, 4});
        int thirdPath = graph.shortestPath(0, 3);
        System.out.println(firstPath + " " + secondPath + " " + thirdPath);

        System.out.println(Arrays.toString(restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}})));
        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
        System.out.println(countHomogenous("abbcccaa"));
        System.out.println(isReachableAtTime(2, 4, 7, 7, 6));
        System.out.println(eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));

        SolutionDay28Sixth seatManager = new SolutionDay28Sixth(5);
        int seatOne = seatManager.reserve();
        int seatTwo = seatManager.reserve();
        seatManager.unreserve(2);
        int seatThree = seatManager.reserve();
        int seatFour = seatManager.reserve();
        int seatFive = seatManager.reserve();
        int seatSix = seatManager.reserve();
        seatManager.unreserve(5);
        System.out.println(String.format("%s, %s, %s, %s, %s, %s", seatOne, seatTwo, seatThree, seatFour, seatFive, seatSix));
        System.out.println(rangeSumBST(new TreeNode(10,
                new TreeNode(5, new TreeNode(3), new TreeNode(7)),
                new TreeNode(15, null, new TreeNode(18))), 7, 15));

        System.out.println(getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(getLastMoment(4, new int[]{4, 3}, new int[]{0, 1}));
        System.out.println(buildArray(new int[]{1, 3}, 3));
        System.out.println(averageOfSubtree(new TreeNode(4,
                new TreeNode(8, new TreeNode(0), new TreeNode(1)),
                new TreeNode(5, null, new TreeNode(6)))));
        System.out.println(Arrays.toString(
                findMode(new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null)))));
        System.out.println(Arrays.toString(findArray(new int[]{5, 2, 0, 3, 1})));
        System.out.println(Arrays.toString(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(leafSimilar(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(3), new TreeNode(2))));
        System.out.println(poorPigs(1000, 15, 60));
        System.out.println(countVowelPermutation(5));
        System.out.println(longestPalindrome("bananas"));
        System.out.println(amountOfTime(new TreeNode(1, new TreeNode(5, null,
                new TreeNode(4, new TreeNode(9), new TreeNode(2))),
                new TreeNode(3, new TreeNode(10), new TreeNode(6))), 3));
        System.out.println(maxAncestorDiff(new TreeNode(1, null,
                new TreeNode(2, null,
                        new TreeNode(0, new TreeNode(3), null)))));
        System.out.println(numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
        System.out.println(halvesAreAlike("textbook"));
        System.out.println(kthGrammar(2, 2));
        System.out.println(largestValues(new TreeNode(1,
                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9)))));
        System.out.println(isPowerOfFour(5));
        System.out.println(minSteps("leetcode", "practice"));
        System.out.println(maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3));
        System.out.println(constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));

        List<NestedInteger> nestedIntegerList = Arrays.asList(
                new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(1),
                        new NestedIntegerImpl(1))), new NestedIntegerImpl(2),
                new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(1),
                        new NestedIntegerImpl(1))));
        SolutionDay34Fourth nestedIterator = new SolutionDay34Fourth(nestedIntegerList);
        List<Integer> integerList = new ArrayList<>();
        while (nestedIterator.hasNext())
            integerList.add(nestedIterator.next());
        System.out.println(integerList);

        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(minimumTime(5, new int[][]{{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(closeStrings("cabbba", "abbccc"));
        System.out.println(validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}));
        System.out.println(Arrays.deepToString(onesMinusZeros(new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 1}})));
        System.out.println(getRow(3));
        System.out.println(findWinners(
                new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}}));
        System.out.println(numWays(3, 2));
        System.out.println(paintWalls(new int[]{2, 3, 4, 2}, new int[]{1, 1, 1, 1}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(findInMountainArray(3, new MountainArrayImpl(new int[]{1, 2, 3, 4, 5, 3, 1})));

        SolutionDay37Second randomizedSet = new SolutionDay37Second();
        boolean param1 = randomizedSet.insert(1);
        boolean param2 = randomizedSet.remove(2);
        boolean param3 = randomizedSet.insert(2);
        int param4 = randomizedSet.getRandom();
        boolean param5 = randomizedSet.remove(1);
        boolean param6 = randomizedSet.insert(2);
        int param7 = randomizedSet.getRandom();
        System.out.println(String.format("%b, %b, %b, %d, %b, %b, %d",
                param1, param2, param3, param4, param5, param6, param7));

        System.out.println(Arrays.toString(fullBloomFlowers(
                new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}}, new int[]{2, 3, 7, 11})));
        System.out.println(SolutionDay37Fourth.minOperations(new int[]{1, 2, 3, 5, 6}));

        long end = System.currentTimeMillis();
        System.out.println(String.format("длительность всех задач в миллисекундах %d", end - start));
    }
}