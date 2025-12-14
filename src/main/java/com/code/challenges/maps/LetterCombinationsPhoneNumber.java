package com.code.challenges.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
    /**
     * Statement:
     *
     * Given a string containing digits from 2-9 inclusive,
     * return all possible letter combinations that the number could represent.
     * Return the answer in any order.
     * A mapping of digits to letters (just like on the telephone buttons)
     * is given below. Note that 1 does not map to any letters.
     *
     * Example 1:
     *
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Example 2:
     *
     * Input: digits = ""
     * Output: []
     *
     * Example 3:
     *
     * Input: digits = "2"
     * Output: ["a","b","c"]
     */

    static void main() {
        /** Phone image: ```src/main/resources/phone_key_board.png``` **/
        System.out.println("Case 1: " + letterCombinations("23"));
        System.out.println("Case 2: " + letterCombinations(""));
        System.out.println("Case 3: " + letterCombinations("2"));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> phoneKeys = new HashMap<>();
        phoneKeys.put(2,"abc");
        phoneKeys.put(3,"def");
        phoneKeys.put(4,"ghi");
        phoneKeys.put(5,"jkl");
        phoneKeys.put(6,"mno");
        phoneKeys.put(7,"pqrs");
        phoneKeys.put(8,"tuv");
        phoneKeys.put(9,"wxyz");

        // convert String into Digits
        // having a nested Loop =>
        // example having 2 numbers for( First number) { for (second number) { } }

        List<String> result = new ArrayList<>();
        permute(result, 0, "", digits, phoneKeys);

        return result;
    }

    private static void permute(List<String> result, int depth, String combination, String digits, Map<Integer, String> phoneKeys) {
        if(depth == digits.length()) {
            result.add(combination);
            return;
        }

        // case => 23
        // => case Depth is `0` I need to get digit `2` => "abc"
        String keyLetters = phoneKeys.get( Integer.parseInt( digits.charAt(depth) + "") );
        for(int i = 0; i < keyLetters.length(); i++) {
            char charToPermute = keyLetters.charAt(i);
            permute(result, depth + 1, combination + charToPermute, digits, phoneKeys);
        }

    }
}
