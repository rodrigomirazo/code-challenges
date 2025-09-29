package com.code.challenges.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /**
     * Statement
     *
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * Example 1:
     *
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * Example 2:
     *
     * Input: n = 1
     * Output: ["()"]
     */

    static void main() {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        permute(result, "", 0, 0, n);

        return result;
    }

    private static void permute(List<String> result, String parenthesisConcat, int leftCount, int rightCount, int n) {
        if(n*2 == parenthesisConcat.length()) {
            result.add(parenthesisConcat);
            return;
        }
        if(leftCount < n) {
            permute(result, parenthesisConcat + "(", leftCount+1, rightCount, n);
        }
        if(leftCount > rightCount) {
            permute(result, parenthesisConcat + ")", leftCount, rightCount+1, n);
        }
    }
}
