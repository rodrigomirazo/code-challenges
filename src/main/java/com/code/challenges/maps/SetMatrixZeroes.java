package com.code.challenges.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetMatrixZeroes {

    /**
     * Statement:
     *
     * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
     *
     * Example 1:
     * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * Output: [[1,0,1],[0,0,0],[1,0,1]]
     *
     * Example 2:
     * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     */

    static void main() {
        /** Example Image: src/main/resources/set_matrix_zeroes.png **/

        int[][] case1 = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] case2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        System.out.println("Case 1: "); setZeroes(case1);
        System.out.println();
        System.out.println("Case 2: "); setZeroes(case2);
    }

    public static void setZeroes(int[][] matrix) {

        // Collect Zero's cordanates in a Map
        // Search for Every Zero using a nested For
        // Map <i'n, [j1, j2]>

        Map<Integer, List<Integer>> zeroMap = new HashMap<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                //
                if(matrix[i][j] == 0) {
                    // validate if it is already contained
                    if(zeroMap.containsKey(i)) {
                        zeroMap.get(i).add(j);
                    } else {
                        List<Integer> rows = new ArrayList<>();
                        rows.add(j);
                        zeroMap.put(i, rows);
                    }
                }
            }
        }
        for(Map.Entry<Integer, List<Integer>> zeroEntry: zeroMap.entrySet() ) {

            for(int j = 0; j < matrix[zeroEntry.getKey()].length; j++) {
                matrix[zeroEntry.getKey()][j] = 0;
            }

            for(Integer value: zeroEntry.getValue()) {
                for(int j = 0; j < matrix.length; j++) {
                    matrix[j][value] = 0;
                }
            }
        }
        String output = "[";
        for(int i = 0; i < matrix.length; i++) {

            output = output + "[";
            for(int j = 0; j < matrix[i].length; j++) {
                output = output + matrix[i][j] + ",";
            }
            output = output.substring(0, output.length()-1) + "]";
        }
        output = output + "]";
        System.out.print(output);
    }
}
