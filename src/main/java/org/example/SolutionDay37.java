package org.example;

//    hard. #binary search. In this task we implement binary search 3 times. Overall time complexity - 4*O(logn)
//    https://leetcode.com/problems/find-in-mountain-array
//    (This problem is an interactive problem.)
//    You may recall that an array arr is a mountain array if and only if:
//    arr.length >= 3
//    There exists some i with 0 < i < arr.length - 1 such that:
//    arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//    arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//    Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such
//    an index does not exist, return -1.
//    You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
//    MountainArray.get(k) returns the element of the array at index k (0-indexed).
//    MountainArray.length() returns the length of the array.
//    Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that
//    attempt to circumvent the judge will result in disqualification.
//    Example 1:
//    Input: array = [1,2,3,4,5,3,1], target = 3
//    Output: 2
//    Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
//    Example 2:
//    Input: array = [0,1,2,4,2,1], target = 3
//    Output: -1
//    Explanation: 3 does not exist in the array, so we return -1.
public class SolutionDay37 {
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int mostLeft = 0;
        int len = mountainArr.length();
        int mostRight = len - 1;
        int peakIndex = findPeak(mountainArr, mostLeft, mostRight);
        int leftIndex = findTargetLeft(mountainArr, mostLeft, peakIndex, target);
        return leftIndex != -1 ? leftIndex : findTargetRight(mountainArr, peakIndex, mostRight, target);
    }

    private static int findPeak(MountainArray ma, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (ma.get(mid) < ma.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int findTargetLeft(MountainArray ma, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = ma.get(mid);
            if (val == target) {
                return mid;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int findTargetRight(MountainArray ma, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = ma.get(mid);
            if (val == target) {
                return mid;
            } else if (val > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

interface MountainArray {
    int get(int index);

    int length();
}

class MountainArrayImpl implements MountainArray {
    private int[] array;

    public MountainArrayImpl(int[] array) {
        this.array = array;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int length() {
        return array.length;
    }
}
