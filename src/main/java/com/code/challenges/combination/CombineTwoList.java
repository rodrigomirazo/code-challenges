package com.code.challenges.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineTwoList {

    /**
     * Statement:
     *
     * Generate all permutations of given array of elements
     * Example 1: ["ab", "cd"] => [abcd, cdab]
     * Example 2: ["ab", "cd", "ef"] => [abcdef, abefcd, cdabef, cdefab, efabcd, efcdab]
     *
     */
    static void main() {
        List<List<String>> lists = List.of(
                List.of("ab", "cd", "ef")
        );
        List<String> result = new ArrayList<>();
        generatePermutations(lists, result, 0, "");
        //System.out.println(result);

        /**
         * Other permutation
         */
        List<String> singleList = List.of("ab", "cd");
        List<String> singleListResult = new ArrayList<>();
        generatePermutationsSingleList(singleList, singleListResult, 0, "");

        System.out.println(singleListResult);
    }

    static void generatePermutationsSingleList(List<String> lists, List<String> result, int depth, String current) {
        if (depth == lists.size()) {
            List<String> currentToList = Arrays.stream(current.substring(1).split("_")).toList();
            if(currentToList.containsAll(lists)) {
                result.add(current.replaceAll("_", ""));
            }
            return;
        }
        for (int i = 0; i < lists.size(); i++) {
            generatePermutationsSingleList(lists, result, depth + 1, current + "_" + lists.get(i));
        }
    }

    static void generatePermutations(List<List<String>> lists, List<String> result, int depth, String current) {
        if (depth == lists.size()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < lists.get(depth).size(); i++) {
            generatePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
        }
    }
}
