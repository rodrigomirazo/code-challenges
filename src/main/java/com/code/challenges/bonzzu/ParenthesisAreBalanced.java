package com.code.challenges.bonzzu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 *
 * Given an expression string exp, write a program to examine whether the pairs and the
 * orders of “{“, “}”, “(“, “)”, “[“, “]” are correct.
 *
 * Example:
 *
 * Input: exp = “()[]{}{[()()]()}”
 * Output: Balanced
 *
 * Input: exp = “[(])”
 * Output: Not Balanced
 *
 * Input: exp = “[({}])”
 * Output: Not Balanced
 */
public class ParenthesisAreBalanced {

    static void main(String[] args) throws IOException {
        String exp = new String("[()]{}{[()()]()}");
        System.out.println("Output  : " + isBalanced(exp));
        System.out.println("Expected: true");
        System.out.println("--------------");
        exp = new String("[(])");
        System.out.println("Output  : " + isBalanced(exp));
        System.out.println("Expected: false");
        System.out.println("--------------");
        exp = new String("[({}])");
        System.out.println("Output  : " + isBalanced(exp));
        System.out.println("Expected: false");
        System.out.println("--------------");
        exp = new String("[({");
        System.out.println("Output  : " + isBalanced(exp));
        System.out.println("Expected: false");
        System.out.println("--------------");
        exp = new String("}])");
        System.out.println("Output  : " + isBalanced(exp));
        System.out.println("Expected: false");
        System.out.println("--------------");
    }

    private static boolean isBalanced(String input) {

        Stack<Character> stackChrs = new Stack<>();

        char[] inputChrs = input.toCharArray();

        for(int i = 0; i < inputChrs.length ; i++) {

            if(inputChrs[i] == '(' || inputChrs[i] == '[' || inputChrs[i] == '{') {
                stackChrs.push(inputChrs[i]);
            } else {
                if(!stackChrs.isEmpty()) {
                    char prevChar = stackChrs.pop();
                    char currentChar = inputChrs[i];

                    if(     prevChar == '(' && currentChar != ')' ||
                            prevChar == '{' && currentChar != '}' ||
                            prevChar == '[' && currentChar != ']' ) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stackChrs.isEmpty();
    }
}

















