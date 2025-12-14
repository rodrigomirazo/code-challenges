package com.code.challenges.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Double.parseDouble;

public class MedianOfTwoSortedArrays {

    /**
     * Median of Two Sorted Arrays
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     *
     * Example 1:
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     * Example 2:
     *
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     */

    static void main() {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(" Median is: " + findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] mergedArray = new int[(nums1.length + nums2.length)];
        int index1 = 0, index2 = 0;
        for(int i = 0 ; i < (nums1.length + nums2.length) ; i++) {

            // limit arr1 has been reached
            if(index1 >= nums1.length) {
                mergedArray[i] = nums2[index2];
                index2++;
            } else if(index2 >= nums2.length) {
                mergedArray[i] = nums1[index1];
                index1++;
            } else if(nums1[index1] < nums2[index2]) {
                mergedArray[i] = nums1[index1];
                index1++;
            } else {
                mergedArray[i] = nums2[index2];
                index2++;
            }
        }
        System.out.println(Arrays.toString(mergedArray));

        Double median;
        // Par
        if( mergedArray.length % 2 == 0) {
            int midIndex1 = (mergedArray.length - 1)/2;
            int midIndex2 = midIndex1 + 1;
            System.out.println("midIndex1 = " + midIndex1);
            System.out.println("midIndex2 = " + midIndex2);

            median = ( (double) mergedArray[midIndex1] + (double) mergedArray[midIndex2]);
            System.out.println("median = " + median);
        } else {
            int midIndex = mergedArray.length/2;
            median = (double) mergedArray[midIndex];
            System.out.println("median = " + median);
        }

        return median;
    }
}
