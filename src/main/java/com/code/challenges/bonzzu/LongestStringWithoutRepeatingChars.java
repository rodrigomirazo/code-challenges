package com.code.challenges.bonzzu;

// Find the length of the longest substring T that contains at most k distinct characters.

// Given a string s, find the length of the longest
// substring
//  without repeating characters.
//  Input: s = "pwwkew"
// Output: 3

// Output: 3
// Output: 0
// Output: 1
// Output: 7
// Output: 4

public class LongestStringWithoutRepeatingChars {

    private static final String[] testCases = new String[]{"pwwkew", "", "a", "abcdefg", "abcddcba"};

    static void main() {

        for(String testCase : testCases) {
            System.out.println("Case: " + longestString(testCase));
        }
        //System.out.println("Case: " + longestString("abcdefg"));
    }

    private static int longestString(String sequence) {

        // the counter
        int counter = 0;
        StringBuilder temp = new StringBuilder();

        char[] charArr = sequence.toCharArray();
        for (int i = 0; i < charArr.length; i++) {

            for (int j = i; j < charArr.length; j++) {
                if (temp.indexOf(charArr[j] + "") == -1) {
                    temp.append(charArr[j]);
                } else {

                    // String Repeated
                    if (temp.length() > counter) {
                        counter = temp.length();
                    }
                    temp = new StringBuilder();
                }
            }
            // String Repeated
            if (temp.length() > counter) {
                counter = temp.length();
            }
            temp = new StringBuilder();
        }
        return counter;
    }
}
