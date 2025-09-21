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

        List<int[]> lists = List.of(nums1, nums2);

        List<Double> doubles = new ArrayList<>();
        for(int[] array : lists) {
            for(int numb : array) {
                doubles.add(parseDouble(numb + ""));
            }
        }

        if(doubles.isEmpty()) {
            return 0.0;
        }

        List<Double> doublesSoported = doubles.stream().sorted().toList();

        System.out.println("doublesSoported: " + doublesSoported);

        Double median;
        if(doublesSoported.size() % 2 == 0) {
            // size = 4 => 4/2 - 1 = 2 - 1 = 1
            // size = 4 => 4/2 + 1 = 2 + 1 = 2
            int medianIndex1 = doublesSoported.size()/2 - 1;
            int medianIndex2 = doublesSoported.size()/2;
            System.out.println("medianIndex1: " + medianIndex1);
            System.out.println("medianIndex2: " + medianIndex2);
            median = (doublesSoported.get(medianIndex1) + doublesSoported.get(medianIndex2))/2;
        } else {
            int medianIndex = doublesSoported.size()/2;
            System.out.println("medianIndex: " + medianIndex);
            median = doublesSoported.get(medianIndex);
        }
        return median;
    }
}
