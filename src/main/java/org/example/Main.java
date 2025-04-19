package org.example;

import org.example.datastructures.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static org.example.Runes.solveExpression;
import static org.example.SolutionDay1.twoSum;
import static org.example.SolutionDay10.buyChoco;
import static org.example.SolutionDay100.reverseList;
import static org.example.SolutionDay101.isPalindrome;
import static org.example.SolutionDay102.reorderList;
import static org.example.SolutionDay103.findDuplicates;
import static org.example.SolutionDay104.firstMissingPositive;
import static org.example.SolutionDay105.maxSubarrayLength;
import static org.example.SolutionDay106.countSubarrays;
import static org.example.SolutionDay107.numSubarrayProductLessThanK;
import static org.example.SolutionDay108.subarraysWithKDistinct;
import static org.example.SolutionDay109.lengthOfLastWord;
import static org.example.SolutionDay11.maxWidthOfVerticalArea;
import static org.example.SolutionDay111.minRemoveToMakeValid;
import static org.example.SolutionDay112.makeGood;
import static org.example.SolutionDay113.checkValidString;
import static org.example.SolutionDay114.maxDepth;
import static org.example.SolutionDay115.countStudents;
import static org.example.SolutionDay116.deckRevealedIncreasing;
import static org.example.SolutionDay117.islandPerimeter;
import static org.example.SolutionDay118.sumNumbers;
import static org.example.SolutionDay119.trap;
import static org.example.SolutionDay12.maxScore;
import static org.example.SolutionDay120.findRelativeRanks;
import static org.example.SolutionDay121.maximumHappinessSum;
import static org.example.SolutionDay122.kthSmallestPrimeFraction;
import static org.example.SolutionDay123.mincostToHireWorkers;
import static org.example.SolutionDay124.largestLocal;
import static org.example.SolutionDay125.getMaximumGold;
import static org.example.SolutionDay126.maximumSafenessFactor;
import static org.example.SolutionDay127.evaluateTree;
import static org.example.SolutionDay128.removeLeafNodes;
import static org.example.SolutionDay129.maximumValueSum;
import static org.example.SolutionDay13.isPathCrossing;
import static org.example.SolutionDay130.subsetXORSum;
import static org.example.SolutionDay131.subsets;
import static org.example.SolutionDay134.checkRecord;
import static org.example.SolutionDay135.specialArray;
import static org.example.SolutionDay136.equalSubstring;
import static org.example.SolutionDay137.numSteps;
import static org.example.SolutionDay138.countTriplets;
import static org.example.SolutionDay14.minOperations;
import static org.example.SolutionDay140.scoreOfString;
import static org.example.SolutionDay141.reverseString;
import static org.example.SolutionDay142.appendCharacters;
import static org.example.SolutionDay144.commonChars;
import static org.example.SolutionDay145.isNStraightHand;
import static org.example.SolutionDay146.replaceWords;
import static org.example.SolutionDay147.checkSubarraySum;
import static org.example.SolutionDay148.subarraysDivByK;
import static org.example.SolutionDay149.heightChecker;
import static org.example.SolutionDay15.numDecodings;
import static org.example.SolutionDay150.relativeSortArray;
import static org.example.SolutionDay151.sortColors;
import static org.example.SolutionDay152.minMovesToSeat;
import static org.example.SolutionDay153.minIncrementForUnique;
import static org.example.SolutionDay154.findMaximizedCapital;
import static org.example.SolutionDay155.minPatches;
import static org.example.SolutionDay156.maxProfitAssignment;
import static org.example.SolutionDay157.minDays;
import static org.example.SolutionDay158.maxDistance;
import static org.example.SolutionDay159.maxSatisfied;
import static org.example.SolutionDay16.numRollsToTarget;
import static org.example.SolutionDay160.bstToGst;
import static org.example.SolutionDay161.balanceBST;
import static org.example.SolutionDay162.findCenter;
import static org.example.SolutionDay163.intersect;
import static org.example.SolutionDay163Second.threeConsecutiveOdds;
import static org.example.SolutionDay164.minDifference;
import static org.example.SolutionDay165.averageWaitingTime;
import static org.example.SolutionDay166.survivedRobotsHealths;
import static org.example.SolutionDay167.maximumGain;
import static org.example.SolutionDay168Second.removeElement;
import static org.example.SolutionDay168Third.removeDuplicates;
import static org.example.SolutionDay169Second.rotate;
import static org.example.SolutionDay17.minCost;
import static org.example.SolutionDay171.canJump;
import static org.example.SolutionDay171Second.recoverFromPreorder;
import static org.example.SolutionDay172.jump;
import static org.example.SolutionDay172Second.constructFromPrePost;
import static org.example.SolutionDay173.hIndex;
import static org.example.SolutionDay173Second.mostProfitablePath;
import static org.example.SolutionDay174.canCompleteCircuit;
import static org.example.SolutionDay174Second.numOfSubarrays;
import static org.example.SolutionDay175.romanToInt;
import static org.example.SolutionDay175Second.maxAbsoluteSum;
import static org.example.SolutionDay175Third.intToRoman;
import static org.example.SolutionDay176.longestCommonPrefix;
import static org.example.SolutionDay176Third.lenLongestFibSubseq;
import static org.example.SolutionDay177.convert;
import static org.example.SolutionDay177Second.strStr;
import static org.example.SolutionDay177Third.shortestCommonSupersequence;
import static org.example.SolutionDay178Third.applyOperations;
import static org.example.SolutionDay179.maxArea;
import static org.example.SolutionDay179Second.mergeArrays;
import static org.example.SolutionDay179Third.threeSum;
import static org.example.SolutionDay18.getLengthOfOptimalCompression;
import static org.example.SolutionDay180.lengthOfLongestSubstring;
import static org.example.SolutionDay180Second.pivotArray;
import static org.example.SolutionDay181.checkPowersOfThree;
import static org.example.SolutionDay181Second.isValidSudoku;
import static org.example.SolutionDay182.coloredCells;
import static org.example.SolutionDay182Second.spiralOrder;
import static org.example.SolutionDay183Second.findMissingAndRepeatedValues;
import static org.example.SolutionDay183Third.setZeroes;
import static org.example.SolutionDay184.closestPrimes;
import static org.example.SolutionDay184Second.gameOfLife;
import static org.example.SolutionDay185.minimumRecolors;
import static org.example.SolutionDay185Second.canConstruct;
import static org.example.SolutionDay185Third.wordPattern;
import static org.example.SolutionDay186.numberOfAlternatingGroups;
import static org.example.SolutionDay186Second.isHappy;
import static org.example.SolutionDay186Third.containsNearbyDuplicate;
import static org.example.SolutionDay187.countOfSubstrings;
import static org.example.SolutionDay187Second.longestConsecutive;
import static org.example.SolutionDay188.numberOfSubstrings;
import static org.example.SolutionDay188Second.summaryRanges;
import static org.example.SolutionDay189.maximumCount;
import static org.example.SolutionDay189Second.merge;
import static org.example.SolutionDay19.minDifficulty;
import static org.example.SolutionDay190.minZeroArray;
import static org.example.SolutionDay190Second.isValid;
import static org.example.SolutionDay191.maximumCandies;
import static org.example.SolutionDay191Second.simplifyPath;
import static org.example.SolutionDay192.minCapability;
import static org.example.SolutionDay193Second.repairCars;
import static org.example.SolutionDay194.longestNiceSubarray;
import static org.example.SolutionDay194Second.mergeTwoLists;
import static org.example.SolutionDay195Second.deleteDuplicates;
import static org.example.SolutionDay196.countDays;
import static org.example.SolutionDay196Second.rotateRight;
import static org.example.SolutionDay197.checkValidCuts;
import static org.example.SolutionDay198Second.invertTree;
import static org.example.SolutionDay199.minimumIndex;
import static org.example.SolutionDay199Second.isSymmetric;
import static org.example.SolutionDay2.findSpecialInteger;
import static org.example.SolutionDay20.makeEqual;
import static org.example.SolutionDay200.maxPoints;
import static org.example.SolutionDay200Second.buildTree;
import static org.example.SolutionDay202Second.connect;
import static org.example.SolutionDay203.mostPoints;
import static org.example.SolutionDay203Second.flatten;
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
import static org.example.SolutionDay37Fifth.searchRange;
import static org.example.SolutionDay37Third.fullBloomFlowers;
import static org.example.SolutionDay38.maxDotProduct;
import static org.example.SolutionDay38Fifth.majorityElement;
import static org.example.SolutionDay38Fourth.integerBreak;
import static org.example.SolutionDay38Second.uniqueOccurrences;
import static org.example.SolutionDay38Third.numOfArrays;
import static org.example.SolutionDay39.climbStairs;
import static org.example.SolutionDay39Fifth.find132pattern;
import static org.example.SolutionDay39Fourth.reverseWords;
import static org.example.SolutionDay39Second.numIdenticalPairs;
import static org.example.SolutionDay39Seventh.sortArrayByParity;
import static org.example.SolutionDay39Sixth.isMonotonic;
import static org.example.SolutionDay39Third.winnerOfGame;
import static org.example.SolutionDay4.numSpecial;
import static org.example.SolutionDay40.decodeAtIndex;
import static org.example.SolutionDay40Second.minFallingPathSum;
import static org.example.SolutionDay40Third.removeDuplicateLetters;
import static org.example.SolutionDay41.sumSubarrayMins;
import static org.example.SolutionDay41Fourth.longestStrChain;
import static org.example.SolutionDay41Second.findTheDifference;
import static org.example.SolutionDay41Third.champagneTower;
import static org.example.SolutionDay42.rob;
import static org.example.SolutionDay42Second.isSubsequence;
import static org.example.SolutionDay42Third.findMedianSortedArrays;
import static org.example.SolutionDay43.findDuplicate;
import static org.example.SolutionDay43Second.findErrorNums;
import static org.example.SolutionDay43Third.kWeakestRows;
import static org.example.SolutionDay44.shortestPathLength;
import static org.example.SolutionDay44Second.maxLength;
import static org.example.SolutionDay44Third.minimumEffortPath;
import static org.example.SolutionDay45.pseudoPalindromicPaths;
import static org.example.SolutionDay45Second.minCostConnectPoints;
import static org.example.SolutionDay45Third.findItinerary;
import static org.example.SolutionDay46.longestCommonSubsequence;
import static org.example.SolutionDay46Fifth.countOrders;
import static org.example.SolutionDay46Fourth.groupThePeople;
import static org.example.SolutionDay46Second.candy;
import static org.example.SolutionDay46Sixth.combinationSum4;
import static org.example.SolutionDay46Third.minDeletions;
import static org.example.SolutionDay47.findPaths;
import static org.example.SolutionDay47Second.generate;
import static org.example.SolutionDay47Third.reverseBetween;
import static org.example.SolutionDay48.kInversePairs;
import static org.example.SolutionDay48Second.splitListToParts;
import static org.example.SolutionDay48Third.copyRandomList;
import static org.example.SolutionDay49.hasCycle;
import static org.example.SolutionDay49Fourth.numSubmatrixSumTarget;
import static org.example.SolutionDay49Second.uniquePaths;
import static org.example.SolutionDay49Third.subarraySum;
import static org.example.SolutionDay5.destCity;
import static org.example.SolutionDay51Second.minExtraChar;
import static org.example.SolutionDay51Third.countBits;
import static org.example.SolutionDay52.minTaps;
import static org.example.SolutionDay52Fourth.bestClosingTime;
import static org.example.SolutionDay52Second.dailyTemperatures;
import static org.example.SolutionDay52Sixth.canCross;
import static org.example.SolutionDay52Third.minimumReplacement;
import static org.example.SolutionDay53.divideArray;
import static org.example.SolutionDay53Second.findLongestChain;
import static org.example.SolutionDay53Third.isInterleave;
import static org.example.SolutionDay54.sequentialDigits;
import static org.example.SolutionDay54Fifth.repeatedSubstringPattern;
import static org.example.SolutionDay54Fourth.convertToTitle;
import static org.example.SolutionDay54Second.fullJustify;
import static org.example.SolutionDay54Third.reorganizeString;
import static org.example.SolutionDay55.sortItems;
import static org.example.SolutionDay55Second.maxSumAfterPartitioning;
import static org.example.SolutionDay55Third.findCriticalAndPseudoCriticalEdges;
import static org.example.SolutionDay56.minWindow;
import static org.example.SolutionDay56Second.maximalNetworkRank;
import static org.example.SolutionDay56Third.updateMatrix;
import static org.example.SolutionDay57.maxSlidingWindow;
import static org.example.SolutionDay57Fifth.validPartition;
import static org.example.SolutionDay57Fourth.findKthLargest;
import static org.example.SolutionDay57Second.firstUniqChar;
import static org.example.SolutionDay57Seventh.change;
import static org.example.SolutionDay57Sixth.uniquePathsWithObstacles;
import static org.example.SolutionDay57Third.partition;
import static org.example.SolutionDay58.groupAnagrams;
import static org.example.SolutionDay58Second.search;
import static org.example.SolutionDay58Third.minimizeMax;
import static org.example.SolutionDay59.searchMatrix;
import static org.example.SolutionDay59Fourth.generateTrees;
import static org.example.SolutionDay59Third.frequencySort;
import static org.example.SolutionDay6.isAnagram;
import static org.example.SolutionDay60.wordBreak;
import static org.example.SolutionDay60Second.letterCombinations;
import static org.example.SolutionDay60Third.numSquares;
import static org.example.SolutionDay61.largestDivisibleSubset;
import static org.example.SolutionDay62.countSubstrings;
import static org.example.SolutionDay62Fifth.strangePrinter;
import static org.example.SolutionDay62Fourth.minimumDeleteSum;
import static org.example.SolutionDay62Second.permute;
import static org.example.SolutionDay62Third.combine;
import static org.example.SolutionDay63.cherryPickup;
import static org.example.SolutionDay63Second.soupServings;
import static org.example.SolutionDay63Third.predictTheWinner;
import static org.example.SolutionDay64.maxRunTime;
import static org.example.SolutionDay64Third.minSpeedOnTime;
import static org.example.SolutionDay65.peakIndexInMountainArray;
import static org.example.SolutionDay65Second.myPow;
import static org.example.SolutionDay65Third.firstPalindrome;
import static org.example.SolutionDay66.allPossibleFBT;
import static org.example.SolutionDay66Second.rearrangeArray;
import static org.example.SolutionDay66Third.knightProbability;
import static org.example.SolutionDay67.findNumberOfLIS;
import static org.example.SolutionDay67Second.asteroidCollision;
import static org.example.SolutionDay67Third.largestPerimeter;
import static org.example.SolutionDay68.eraseOverlapIntervals;
import static org.example.SolutionDay68Second.findLeastNumOfUniqueInts;
import static org.example.SolutionDay69.addTwoNumbers;
import static org.example.SolutionDay69Second.furthestBuilding;
import static org.example.SolutionDay69Third.smallestSufficientTeam;
import static org.example.SolutionDay70.maxValue;
import static org.example.SolutionDay70Second.mostBooked;
import static org.example.SolutionDay70Third.longestSubsequence;
import static org.example.SolutionDay71.canFinish;
import static org.example.SolutionDay71Second.isPowerOfTwo;
import static org.example.SolutionDay71Third.eventualSafeNodes;
import static org.example.SolutionDay72.distanceK;
import static org.example.SolutionDay72Second.missingNumber;
import static org.example.SolutionDay72Third.minDepth;
import static org.example.SolutionDay73.largestVariance;
import static org.example.SolutionDay73Second.rangeBitwiseAnd;
import static org.example.SolutionDay73Third.putMarbles;
import static org.example.SolutionDay74.maxConsecutiveAnswers;
import static org.example.SolutionDay74Second.findJudge;
import static org.example.SolutionDay74Third.minSubArrayLen;
import static org.example.SolutionDay75.longestSubarray;
import static org.example.SolutionDay75Second.findCheapestPrice;
import static org.example.SolutionDay75Third.singleNumber;
import static org.example.SolutionDay76.buddyStrings;
import static org.example.SolutionDay76Second.findAllPeople;
import static org.example.SolutionDay76Third.maximumRequests;
import static org.example.SolutionDay77.distributeCookies;
import static org.example.SolutionDay77Second.canTraverseAllPairs;
import static org.example.SolutionDay77Third.latestDayToCross;
import static org.example.SolutionDay78.shortestPathAllKeys;
import static org.example.SolutionDay78Second.maxProbability;
import static org.example.SolutionDay78Third.isSameTree;
import static org.example.SolutionDay79.kSmallestPairs;
import static org.example.SolutionDay79Second.diameterOfBinaryTree;
import static org.example.SolutionDay79Third.totalCost;
import static org.example.SolutionDay8.maxProductDifference;
import static org.example.SolutionDay80.countRoutes;
import static org.example.SolutionDay80Second.tallestBillboard;
import static org.example.SolutionDay80Third.findBottomLeftValue;
import static org.example.SolutionDay81.maximumOddBinaryNumber;
import static org.example.SolutionDay82.sortedSquares;
import static org.example.SolutionDay83.removeNthFromEnd;
import static org.example.SolutionDay84.bagOfTokensScore;
import static org.example.SolutionDay84Second.longestArithSeqLength;
import static org.example.SolutionDay84Third.maxProfit;
import static org.example.SolutionDay85.minimumLength;
import static org.example.SolutionDay85Third.getAverages;
import static org.example.SolutionDay86.countPaths;
import static org.example.SolutionDay86Second.largestAltitude;
import static org.example.SolutionDay87.middleNode;
import static org.example.SolutionDay88.maxFrequencyElements;
import static org.example.SolutionDay88Second.getCommon;
import static org.example.SolutionDay89.intersection;
import static org.example.SolutionDay9.imageSmoother;
import static org.example.SolutionDay90.customSortString;
import static org.example.SolutionDay91.removeZeroSumSublists;
import static org.example.SolutionDay92.pivotInteger;
import static org.example.SolutionDay93.numSubarraysWithSum;
import static org.example.SolutionDay94.productExceptSelf;
import static org.example.SolutionDay95.findMaxLength;
import static org.example.SolutionDay96.insert;
import static org.example.SolutionDay97.findMinArrowShots;
import static org.example.SolutionDay98.leastInterval;
import static org.example.SolutionDay99.mergeInBetween;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Instant start = Instant.now();

        System.out.println(Arrays.toString(twoSum(new int[]{1, 6, 3, 10}, 9)));
        System.out.println(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(maxProduct(new int[]{1, 5, 4, 5}));
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(destCity(List.of(List.of("London", "New York"), List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo"))));
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
        System.out.println(Arrays.deepToString(imageSmoother(new int[][]{{100, 200, 100}, {200, 50, 200},
                {100, 200, 100}})));
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
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null),
                        null))));
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
        System.out.println(checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2},
                new int[]{2, 3, 5}));
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
        System.out.println(jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100,
                70, 60}));

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
        System.out.println(String.format("%s, %s, %s, %s, %s, %s", seatOne, seatTwo, seatThree, seatFour, seatFive,
                seatSix));
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
        System.out.println(minimumTime(5, new int[][]{{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}},
                new int[]{1, 2, 3, 4, 5}));
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
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(numOfArrays(2, 3, 1));
        System.out.println(integerBreak(10));
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        SolutionDay38Sixth myHashMap = new SolutionDay38Sixth();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        int day38param1 = myHashMap.get(1);
        int day38param2 = myHashMap.get(3);
        myHashMap.put(2, 1);
        int day38param3 = myHashMap.get(2);
        myHashMap.remove(2);
        int day38param4 = myHashMap.get(2);
        System.out.println(String.format("%d, %d, %d, %d", day38param1, day38param2, day38param3, day38param4));

        System.out.println(climbStairs(3));
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(winnerOfGame("ABBBBBBBAAA"));
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(decodeAtIndex("leet2code3", 10));
        System.out.println(minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(champagneTower(2, 1, 1));
        System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(SolutionDay42Fourth.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{
                {1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}}, 3)));
        System.out.println(shortestPathLength(new int[][]{{1, 2, 3}, {0}, {0}, {0}}));
        System.out.println(maxLength(List.of("cha", "r", "act", "ers")));
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
        System.out.println(pseudoPalindromicPaths(new TreeNode(2,
                new TreeNode(3, new TreeNode(3), new TreeNode(1)),
                new TreeNode(1, null, new TreeNode(1)))));
        System.out.println(minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));

        System.out.println(findItinerary(List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"),
                List.of("SFO", "SJC"), List.of("LHR", "SFO"))));
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(candy(new int[]{1, 0, 2}));
        System.out.println(minDeletions("ceabaacb"));
        System.out.println(groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
        System.out.println(countOrders(3));
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(findPaths(2, 2, 2, 0, 0));
        System.out.println(generate(5));

        ListNode listNode = new ListNode(5);
        listNode = new ListNode(4, listNode);
        listNode = new ListNode(3, listNode);
        listNode = new ListNode(2, listNode);
        listNode = new ListNode(1, listNode);
        StringBuilder sb = new StringBuilder();
        sb.append(listNode.val + " ");
        ListNode pointer = listNode;
        while (pointer.next != null) {
            pointer = pointer.next;
            sb.append(pointer.val + " ");
        }
        reverseBetween(listNode, 2, 4);
        StringBuilder reversedBetweenSb = new StringBuilder();
        reversedBetweenSb.append(listNode.val + " ");
        pointer = listNode;
        while (pointer.next != null) {
            pointer = pointer.next;
            reversedBetweenSb.append(pointer.val + " ");
        }
        System.out.println(sb + " " + reversedBetweenSb);

        System.out.println(kInversePairs(3, 1));

        ListNode[] linkedLists = splitListToParts(listNode, 3);
        List<List<Integer>> linkedListsVal = new ArrayList<>();
        for (int i = 0; i < linkedLists.length; i++) {
            linkedListsVal.add(new ArrayList<>());
            ListNode cur = linkedLists[i];
            while (cur != null) {
                linkedListsVal.get(i).add(cur.val);
                cur = cur.next;
            }
        }
        System.out.println(linkedListsVal);

        NodeWithRandom nwr = new NodeWithRandom(5);
        nwr.next = new NodeWithRandom(4);
        nwr.random = nwr.next;
        NodeWithRandom newNwr = copyRandomList(nwr);
        newNwr.random = null;
        System.out.println(nwr.equals(newNwr));
        System.out.println(hasCycle(listNode));
        System.out.println(uniquePaths(3, 7));
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(numSubmatrixSumTarget(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0));

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int int1 = myQueue.peek();
        int int2 = myQueue.pop();
        boolean boolean1 = myQueue.empty();
        System.out.println(int1 + " " + int2 + " " + boolean1);
        System.out.println(minExtraChar("sayhelloworld", new String[]{"hello", "world"}));
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(minTaps(5, new int[]{3, 4, 1, 1, 0, 0}));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(minimumReplacement(new int[]{3, 9, 3}));
        System.out.println(bestClosingTime("YYNY"));

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int myStackInt1 = myStack.top();
        int myStackInt2 = myStack.pop();
        boolean myStackBoolean = myStack.empty();
        System.out.println(myStackInt1 + " " + myStackInt2 + " " + myStackBoolean);

        System.out.println(canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(Arrays.deepToString(divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)));
        System.out.println(findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(sequentialDigits(100, 300));
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                16));
        System.out.println(reorganizeString("aab"));
        System.out.println(convertToTitle(701));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(Arrays.toString(sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, List.of(List.of(),
                List.of(6), List.of(5), List.of(6), List.of(3, 6), List.of(), List.of(), List.of()))));
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
        System.out.println(findCriticalAndPseudoCriticalEdges(5,
                new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}}));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}));
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(firstUniqChar("loveleetcode"));

        System.out.println(partition(new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2,
                new ListNode(1))))), 3).asList());
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(validPartition(new int[]{4, 4, 4, 5, 6}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(change(5, new int[]{1, 2, 5}));
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(SolutionDay58Fourth.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(frequencySort("tree"));
        System.out.println(generateTrees(3).stream().map(TreeNode::asList).collect(Collectors.toList()));
        System.out.println(wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(letterCombinations("23"));
        System.out.println(numSquares(12));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(countSubstrings("aaa"));
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(combine(4, 2));
        System.out.println(minimumDeleteSum("sea", "eat"));
        System.out.println(strangePrinter("aaabbb"));
        System.out.println(cherryPickup(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}));
        System.out.println(soupServings(100));
        System.out.println(predictTheWinner(new int[]{1, 5, 2}));
        System.out.println(maxRunTime(2, new int[]{3, 3, 3}));
        System.out.println(SolutionDay64Second.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(myPow(2, 10));
        System.out.println(firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"}));
        System.out.println(allPossibleFBT(3).stream().map(tn -> tn.asList()).collect(Collectors.toList()));
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
        System.out.println(knightProbability(3, 2, 0, 0));
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int lru1 = lruCache.get(1);
        lruCache.put(3, 3);
        int lru2 = lruCache.get(2);
        lruCache.put(4, 4);
        int lru3 = lruCache.get(1);
        int lru4 = lruCache.get(3);
        int lru5 = lruCache.get(3);
        System.out.println(String.format("%s %s %s %s %s", lru1, lru2, lru3, lru4, lru5));
        System.out.println(addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))).asList());
        System.out.println(furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println(Arrays.toString(smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"},
                List.of(List.of("java"), List.of("nodejs"), List.of("nodejs", "reactjs")))));
        System.out.println(maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}}, 2));
        System.out.println(mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}));
        System.out.println(longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(isPowerOfTwo(16));
        System.out.println(eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));

        TreeNode target = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7),
                new TreeNode(4)));
        TreeNode root = new TreeNode(3, target, new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(distanceK(root, target, 2));
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(minDepth(new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(largestVariance("aababbb"));
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(putMarbles(new int[]{1, 3, 5, 1}, 2));
        System.out.println(maxConsecutiveAnswers("TTFF", 2));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(buddyStrings("ba", "ab"));
        System.out.println(findAllPeople(5, new int[][]{{3, 4, 2}, {1, 2, 1}, {2, 3, 1}}, 1));
        System.out.println(maximumRequests(3, new int[][]{{0, 0}, {1, 2}, {2, 1}}));
        System.out.println(distributeCookies(new int[]{8, 15, 10, 20, 8}, 2));
        System.out.println(canTraverseAllPairs(new int[]{2, 3, 6}));
        System.out.println(latestDayToCross(2, 2, new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}}));
        System.out.println(shortestPathAllKeys(new String[]{"@..aA", "..B#.", "....b"}));
        System.out.println(maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2},
                0, 2));

        System.out.println(isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(diameterOfBinaryTree(new TreeNode(1, new TreeNode(2,
                new TreeNode(4), new TreeNode(5)), new TreeNode(3))));
        System.out.println(totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
        System.out.println(countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5));
        System.out.println(tallestBillboard(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(findBottomLeftValue(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(maximumOddBinaryNumber("0101"));
        System.out.println(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5))))), 2).asList());
        System.out.println(bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
        System.out.println(longestArithSeqLength(new int[]{3, 6, 9, 12}));
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(SolutionDay85Second.minCost(new int[]{1, 3, 5, 2}, new int[]{2, 3, 1, 14}));
        System.out.println(Arrays.toString(getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3)));
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(countPaths(new int[][]{{1, 1}, {3, 4}}));
        System.out.println(middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5)))))).asList());
        System.out.println(maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
        System.out.println(getCommon(new int[]{1, 2, 3}, new int[]{2, 4}));
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(customSortString("cba", "abcd"));
        System.out.println(removeZeroSumSublists(new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(-3, new ListNode(4)))))).asList());
        System.out.println(pivotInteger(8));
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(mergeInBetween(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(5, new ListNode(6))))))), 2, 5,
                new ListNode(1000000,
                        new ListNode(1000001, new ListNode(1000002, new ListNode(1000003,
                                new ListNode(1000004)))))).asList());
        System.out.println(reverseList(new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4,
                        new ListNode(5)))))).asList());
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2,
                new ListNode(1))))));

        ListNode listNode102 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5)))));
        reorderList(listNode102);
        System.out.println(listNode102.asList());
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
        System.out.println(countSubarrays(new int[]{1, 4, 2, 1}, 3));
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(lengthOfLastWord("Hello world"));
        System.out.println(SolutionDay110.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(checkValidString("(*))"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
        System.out.println(islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
        System.out.println(sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
        System.out.println(maximumHappinessSum(new int[]{1, 2, 3}, 2));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
        System.out.println(Arrays.deepToString(largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4},
                {6, 2, 2, 2}})));
        System.out.println(getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
        System.out.println(maximumSafenessFactor(Arrays.asList(Arrays.asList(0, 0, 1), Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 0))));
        System.out.println(evaluateTree(new TreeNode(0)));
        System.out.println(removeLeafNodes(new TreeNode(1, new TreeNode(2, new TreeNode(2,
                new TreeNode(2, null, null), null), null), null), 2).asList());
        System.out.println(maximumValueSum(new int[]{2, 3}, 7, new int[][]{{0, 1}}));
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(SolutionDay132.partition("aab"));
        System.out.println(SolutionDay133.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(checkRecord(2));
        System.out.println(specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(numSteps("1101"));
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(Arrays.toString(SolutionDay139.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(scoreOfString("zaz"));
        char[] s = "Hello".toCharArray();
        reverseString(s);
        System.out.println(s);
        System.out.println(appendCharacters("coaching", "coding"));
        System.out.println(SolutionDay143.longestPalindrome("abccccdd"));
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"),
                "the cattle was rattled by the battery"));
        System.out.println(checkSubarraySum(new int[]{23, 6, 4, 7}, 13));
        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6})));

        int[] sortingColors = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(sortingColors);
        System.out.println(Arrays.toString(sortingColors));
        System.out.println(minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
        System.out.println(minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        System.out.println(minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50},
                new int[]{4, 5, 6, 7}));
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(solveExpression("-?56373--9216=-?47157"));
        System.out.println(maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
        System.out.println(bstToGst(new TreeNode(0, null, new TreeNode(1))).asList());
        System.out.println(balanceBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))).asList());
        System.out.println(findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
        System.out.println(SolutionDay163Third.maxNumEdgesToRemove(4,
                new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}}));
        System.out.println(minDifference(new int[]{1, 5, 0, 10, 14}));
        System.out.println(averageWaitingTime(new int[][]{{5, 2}, {5, 4}, {10, 3}, {20, 1}}));
        System.out.println(survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL"));
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));

        int[] nums168 = new int[]{1, 2, 3, 0, 0, 0};
        SolutionDay168.merge(nums168, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums168));

        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 2));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(SolutionDay169.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));

        int[] nums169 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums169, 3);
        System.out.println(Arrays.toString(nums169));

        SolutionDay170 findElements = new SolutionDay170(new TreeNode(-1, null, new TreeNode(-1)));
        System.out.println(findElements.find(1) + ", " + findElements.find(2));

        System.out.println(SolutionDay170Second.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(SolutionDay170Third.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));

        System.out.println(recoverFromPreorder("1-2--3--4-5--6--7").asList());

        Square square = new Square(5);
        square.setHeight(10);
        System.out.println(square.getArea());
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7},
                new int[]{4, 5, 2, 6, 7, 3, 1}).asList());
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(mostProfitablePath(new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}}, 3, new int[]{-2, 4, 2, -4, 6}));
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}));
        System.out.println(intToRoman(1994));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(SolutionDay176Second.reverseWords("a good   example"));
        System.out.println(lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(shortestCommonSupersequence("abac", "cab"));
        System.out.println(SolutionDay178.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(Arrays.toString(SolutionDay178Second.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(Arrays.deepToString(mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}},
                new int[][]{{1, 4}, {3, 2}, {4, 1}})));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(Arrays.toString(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
        System.out.println(checkPowersOfThree(12));
        System.out.println(isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
        System.out.println(coloredCells(2));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SolutionDay183.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})));

        int[][] matrix183Third = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix183Third);
        System.out.println(Arrays.deepToString(matrix183Third));

        System.out.println(Arrays.toString(closestPrimes(10, 19)));

        int[][] matrix184Second = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(matrix184Second);
        System.out.println(Arrays.deepToString(matrix184Second));

        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));
        System.out.println(isHappy(19));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        SqlExecutor.execute("SolutionDay188Third.sql");
        SqlExecutor.execute("SolutionDay188Fourth.sql");
        System.out.println(maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        SqlExecutor.execute("SolutionDay189Third.sql");
        System.out.println(minZeroArray(new int[]{2, 0, 2}, new int[][]{{0, 2, 1}, {0, 2, 1}, {1, 1, 3}}));
        System.out.println(isValid("()[]{}"));
        SqlExecutor.execute("SolutionDay190Third.sql");
        System.out.println(maximumCandies(new int[]{5, 8, 6}, 3));
        System.out.println(simplifyPath("/home/user/Documents///..//Pictures/"));
        SqlExecutor.execute("SolutionDay191Third.sql");
        System.out.println(minCapability(new int[]{2, 3, 5, 9}, 2));

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        SqlExecutor.execute("SolutionDay192Third.sql");
        SqlExecutor.execute("SolutionDay193.sql");
        System.out.println(repairCars(new int[]{4, 2, 3, 1}, 10));
        System.out.println(SolutionDay193Third.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))).asList());
        System.out.println(longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
        System.out.println(mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))).asList());
        SqlExecutor.execute("SolutionDay194Third.sql");
        System.out.println(SolutionDay195.minOperations(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1,
                new ListNode(2, new ListNode(3)))))).asList());
        SqlExecutor.execute("SolutionDay195Third.sql");

        System.out.println(countDays(10, new int[][]{{5, 7}, {1, 3}, {9, 10}}));
        System.out.println(rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5))))), 2).asList());
        SqlExecutor.execute("SolutionDay196Third.sql");
        System.out.println(checkValidCuts(5, new int[][]{{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}}));
        System.out.println(SolutionDay197Second.maxDepth(new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        SqlExecutor.execute("SolutionDay197Third.sql");
        System.out.println(SolutionDay198.minOperations(new int[][]{{2, 4}, {6, 8}}, 2));
        System.out.println(invertTree(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)))).asList());
        SqlExecutor.execute("SolutionDay198Third.sql");
        System.out.println(minimumIndex(List.of(1, 2, 2, 2)));
        System.out.println(isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3),
                new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
        SqlExecutor.execute("SolutionDay199Third.sql");
        System.out.println(Arrays.toString(maxPoints(new int[][]{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}}, new int[]{5, 6, 2})));
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}).asList());
        SqlExecutor.execute("SolutionDay200Third.sql");
        System.out.println(SolutionDay201.maximumScore(List.of(8, 3, 9, 3, 8), 2));
        System.out.println(SolutionDay201Second.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}).asList());
        SqlExecutor.execute("SolutionDay201Third.sql");
        System.out.println(SolutionDay202.putMarbles(new int[]{1, 3, 5, 1}, 2));
        System.out.println(connect(new TreeNodeWithNext(1,
                new TreeNodeWithNext(2, new TreeNodeWithNext(4), new TreeNodeWithNext(5), null),
                new TreeNodeWithNext(3, null, new TreeNodeWithNext(7), null), null)).asList());
        SqlExecutor.execute("SolutionDay202Third.sql");
        System.out.println(mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));

        TreeNode treeNode203Second = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        flatten(treeNode203Second);
        System.out.println(treeNode203Second.asList());

        SqlExecutor.execute("SolutionDay203Third.sql");
        System.out.println(SolutionDay204.Companion.maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        System.out.println(SolutionDay205.Companion.lcaDeepestLeaves(new TreeNode(0,
                new TreeNode(1, null, new TreeNode(2)), new TreeNode(3))).asList());
        System.out.println(SolutionDay205Second.Companion.hasPathSum(new TreeNode(1, new TreeNode(2),
                new TreeNode(3)), 5));
        SqlExecutor.execute("SolutionDay205Third.sql");
        System.out.println(SolutionDay206.Companion.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(SolutionDay206Second.Companion.countNodes(new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null))));
        SqlExecutor.execute("SolutionDay206Third.sql");

        TreeNode treeNode207 = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9),
                new TreeNode(20)));
        InOrderBSTIterator iterator207 = new InOrderBSTIterator(treeNode207);
        System.out.println(iterator207.next());
        System.out.println(iterator207.next());
        System.out.println(iterator207.hasNext());
        System.out.println(iterator207.next());
        System.out.println(iterator207.hasNext());
        System.out.println(iterator207.next());
        System.out.println(iterator207.hasNext());

        SqlExecutor.execute("SolutionDay207Second.sql");
        System.out.println(SolutionDay207Third.Companion.minOperations(new int[]{5, 2, 5, 4, 5}, 2));
        System.out.println(SolutionDay208.Companion.countSymmetricIntegers(1, 100));

        TreeNode treeNode208Second = new TreeNode(1, new TreeNode(2), null);
        System.out.println(Objects.requireNonNull(SolutionDay208Second.Companion.lowestCommonAncestor(treeNode208Second,
                treeNode208Second.left, treeNode208Second)).val);

        SqlExecutor.execute("SolutionDay208Third.sql");
        System.out.println(SolutionDay209.Companion.minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}));
        System.out.println(SolutionDay209Second.Companion.rightSideView(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(4)))));
        SqlExecutor.execute("SolutionDay209Third.sql");
        System.out.println(SolutionDay210.Companion.countGoodNumbers(1));
        System.out.println(Arrays.toString(SolutionDay210Second.Companion.averageOfLevels(new TreeNode(3,
                new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))))));
        SqlExecutor.execute("SolutionDay210Third.sql");
        System.out.println(SolutionDay211.Companion.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
        System.out.println(SolutionDay211Second.Companion.levelOrder(new TreeNode(3,
                new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        SqlExecutor.execute("SolutionDay211Third.sql");
        System.out.println(SolutionDay212.Companion.zigzagLevelOrder(new TreeNode(3,
                new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(SolutionDay212Second.Companion.getMinimumDifference(new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6))));
        SqlExecutor.execute("SolutionDay212Third.sql");
        System.out.println(SolutionDay213.Companion.countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
        System.out.println(SolutionDay213Second.Companion.kthSmallest(new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1));
        SqlExecutor.execute("SolutionDay213Third.sql");
        System.out.println(SolutionDay214.Companion.countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2));
        System.out.println(SolutionDay214Second.Companion.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        SqlExecutor.execute("SolutionDay214Third.sql");
        System.out.println(SolutionDay215.Companion.countAndSay(4));
        System.out.println(SolutionDay215Second.Companion.numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        SqlExecutor.execute("SolutionDay215Third.sql");
        System.out.println(SolutionDay216.Companion.countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));

        Instant end = Instant.now();
        System.out.println(String.format("длительность всех задач в миллисекундах %d",
                Duration.between(start, end).toMillis()));
    }
}