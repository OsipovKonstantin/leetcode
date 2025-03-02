package org.example;

public class SolutionDay179Second {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int f = 0;
        int s = 0;
        int count = 0;
        while (f < len1 || s < len2) {
            if (f == len1) {
                while (s < len2) {
                    s++;
                    count++;
                }
                break;
            } else if (s == len2) {
                while (f < len1) {
                    f++;
                    count++;
                }
                break;
            }
            int fId = nums1[f][0];
            int sId = nums2[s][0];
            if (fId == sId) {
                f++;
                s++;
            } else if (fId > sId) s++;
            else f++;
            count++;
        }
        f = 0;
        s = 0;
        int[][] ans = new int[count][2];
        count = 0;
        while (f < len1 || s < len2) {
            if (f == len1) {
                while (s < len2) {
                    ans[count][0] = nums2[s][0];
                    ans[count][1] = nums2[s][1];
                    s++;
                    count++;
                }
                break;
            } else if (s == len2) {
                while (f < len1) {
                    ans[count][0] = nums1[f][0];
                    ans[count][1] = nums1[f][1];
                    f++;
                    count++;
                }
                break;
            }
            int fId = nums1[f][0];
            int fVal = nums1[f][1];
            int sId = nums2[s][0];
            int sVal = nums2[s][1];
            if (fId == sId) {
                ans[count][0] = fId;
                ans[count][1] = fVal + sVal;
                f++;
                s++;
            } else if (fId > sId) {
                ans[count][0] = sId;
                ans[count][1] = sVal;
                s++;
            } else {
                ans[count][0] = fId;
                ans[count][1] = fVal;
                f++;
            }
            count++;
        }
        return ans;
    }
}
