package com.code.challenges.bonzzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description Given an array of intervals, merge the overlapping ones.
 * ==
 * Input: [[1,3],[2,6],[8,10],[11,15]]
 * Output: [[1,6],[8,10],[11,15]]
 * ==
 * Input: [[1,4],[0,4]]
 * Output: [[0,4]]
 * ==
 * Input: [[1,4],[8,10],[0,4]]
 */
public class NumbersOverlappingAndMerge {

    public static int[][] merge(int[][] intervals) {
        // Edge case: if the array is empty or has only one interval, no merging is needed
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort the intervals by their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Create a list to hold the merged intervals
        List<int[]> merged = new ArrayList<>();

        // Grab the first interval to start comparing
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // Step 3: Iterate through the intervals
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // They overlap! Merge them by taking the maximum end time.
                // Example: [1, 3] and [2, 6] becomes [1, 6]
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // They don't overlap! Add the new interval to our tracking variable
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // Step 4: Convert the List back to a 2D array and return
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] input1 = {{1, 3}, {2, 6}, {8, 10}, {11, 15}};
        int[][] input2 = {{1, 4}, {0, 4}};
        int[][] input3 = {{1, 4}, {8, 10}, {0, 4}};

        System.out.println("Output 1: " + Arrays.deepToString(merge(input1)));
        // Expected: [[1, 6], [8, 10], [11, 15]]

        System.out.println("Output 2: " + Arrays.deepToString(merge(input2)));
        // Expected: [[0, 4]]

        System.out.println("Output 3: " + Arrays.deepToString(merge(input3)));
        // Expected: [[0, 4], [8, 10]]
    }

}
