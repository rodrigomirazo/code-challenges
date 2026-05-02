package com.code.challenges.bonzzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*+
    Expandir la cadena segun el siguiente patron:
    3[abc2[de]] = abcdedeabcdedeabcdede
 */
public class ExpandString {
    public static void main(String[] args) {
        String input = "3[abc2[de]]";
        System.out.println("Input: " + input);
        System.out.println("Output: " + expandDepthFirst(input));
    }

    public static String expandDepthFirst(String originalString) {
        char[] charArray = originalString.toCharArray();
        Stack<Character> charStack = new Stack<>();

        int index = 0;
        while(index < charArray.length) {

            if(Character.isDigit(charArray[index])) {
                //getDigit
                int digit = Integer.parseInt(charArray[index]+"");

                //1. Recur until find a char "]"
                int substringLength = 0;
                while (charArray[substringLength] != ']') {

                    //  3[abc2[de]]
                    if(Character.isDigit( charArray[substringLength] )) {
                        charStack = new Stack<>();
                        substringLength++;
                    } else {
                        charStack.push(charArray[substringLength]);
                    }
                    substringLength++;
                }
                String multiplyString = multiplyString(charStack, digit);

                originalString = originalString.substring(0, (substringLength - charStack.size()) - 2 )
                        + multiplyString
                        + originalString.substring(substringLength + 1);

                charArray = originalString.toCharArray();
            } else {
                index++;
            }
        }

        return originalString;
    }

    private static String expandString2(String input) {
        StringBuilder sb = new StringBuilder();
        String[] spList = input.split("]");

        for(int i=0; i<spList.length; i++) {
            int repeat = Integer.parseInt(spList[i].split("\\[")[0]);
            String s = spList[i].split("\\[")[1];
            for(int j=0; j<repeat; j++) {
                sb.append(s);
            }
        }

        return sb.toString();
    }

    private static String multiplyString(Stack<Character> stack, int number) {
        String result = stack.stream().toList().stream().map(Object::toString).collect(Collectors.joining());
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < number; i++) {
            st.append(result);
        }
        return st.toString();
    }

}
