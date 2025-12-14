package com.code.challenges.arrays;

public class ContainerWithMostWater {

    /**
     * Statement
     *
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Return the maximum amount of water a container can store.
     *
     * Notice that you may not slant the container.
     *
     * Find Image here: src/main/resources/water_container.png
     */

    static void main() {
        // Find Image here
        String imageReference = "src/main/resources/water_container.png";

        int[] case1 = {1,8,6,2,5,4,8,3,7};
        int[] case2 = {1,1};

        System.out.println("Max Area Case 1: " + maxArea(case1));
        System.out.println("Max Area Case 2: " + maxArea(case2));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0; i < height.length; i++) {

            for(int j = 0; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int base = j - i;
                if(minHeight > 0 && base > 0) {
                    int currentArea = minHeight * base;
                    if(maxArea < currentArea) {
                        maxArea = currentArea;
                    }
                }
            }
        }

        return maxArea;
    }
}
