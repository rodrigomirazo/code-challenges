package com.code.challenges.google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.aot.hint.TypeReference.listOf;

public class MaximumAreaFormerLand {
    /**
     * A farmer wants to farm their land with the maximum area where good land is present.
     * The “land” is represented as a matrix with 1s and 0s, where 1s mean good land and 0s mean bad land.
     * The farmer only want to farm in a square of good land with the maximum area.
     * Please help the farmer to find the maximum area of the land they can farm in good land.
     * 0, 1, 1, 0, 1
     * 1, 1, 0, 1, 0
     * 0, 1, 1, 1, 0
     * 1, 1, 1, 1, 0
     * 1, 1, 1, 1, 1
     * 0, 0, 0, 0, 0
     */
    static int[][] matrix;
    static Map<List<Integer>, Integer> areaLimits = new HashMap<>();

    public static void main(String[] args) {

        matrix = new int[][] {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        System.out.println(getMaxArea());
    }

    private static int getMaxArea() {
        // continue with following Nodes
        if(matrix.length == 0)
            return 0;

        // dynamic Programming
        int[][] dp = new int[matrix.length][matrix[matrix.length-1].length];
        int maxSide = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[j].length; j++) {
                if (matrix[i][j] == 1) {

                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        System.out.println(" dp[i - 1][j] => " + dp[i - 1][j] + " |  dp[i][j - 1] => " + dp[i][j - 1]+ " ||| dp[i - 1][j - 1]) => " + dp[i - 1][j - 1]);
                        System.out.println(" Math.min = " + Math.min( Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]));

                        dp[i][j] = 1 + Math.min( Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                        System.out.println();
                    }
                    System.out.println(" Math.max = " + dp[i][j]);
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[j].length; j++) {
                System.out.println("[" + i + ", " + j + "] = " + dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}
