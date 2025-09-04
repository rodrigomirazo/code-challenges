package com.code.challenges.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsPalindromeOrPermutation {

    public static void main(String[] args) {

        System.out.println("Is Palindrome: " + isPalindrome("aaabbz"));
    }

    private static boolean isPalindrome(String palindrome) {

        /* Statement:
            A Palindrome should be able to ve reversed and de read equallly
            Example: 'aaabb' is Palindrome => 'baaab'
            So a Palindrome can have at Most one char that can be repeated as None
        */

        /* The Plan:

        1. Initialize an Empty Map that will contain the letters and the times that each Char is Repeated
        2. Validate if the "At most One none count is Valid"
        3. Return vlaidation
        */

        // 1.
        Map<Character, Integer> charMapper = new HashMap<>();
        for (int i = 0; i < palindrome.length(); i++) {
            // Validate if it's already added
            if(charMapper.containsKey(palindrome.charAt(i))) {
                // get value and increase by one
                charMapper.compute(
                        palindrome.charAt(i),
                        (k, times) -> times + 1
                );
            } else {
                charMapper.put(palindrome.charAt(i), 1);
            }
        }

        // 2.
        List<Integer> charNoneList = charMapper.values().stream().filter(val -> val % 2 != 0).toList();
        System.out.println(charNoneList);

        return charNoneList.size() <= 1;
    }
}
