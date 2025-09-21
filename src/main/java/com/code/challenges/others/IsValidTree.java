package com.code.challenges.others;

import java.util.Arrays;
import java.util.List;

public class IsValidTree {

    public static void main(String[] args) {

        String[] arr = new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        TreeConstructor(arr);
    }

    private static String TreeConstructor(String[] strArr) {
        // code goes here
        // example: (1, 2) => (i1, i2)
        // iterate thhrough 'i2' and validate if every i2 is "child" of anything
        // if not it means he is a "Root"
        // so ate elast we must have a root, if more than 2 roots, it means Tree is invalid

        List<String> listOfParents = Arrays.stream(strArr).map( str ->
                str.replace("(", "")
                        .replace(")", "")
                        .split(",")[1]).toList();

        List<String> listOfChilds = Arrays.stream(strArr).map( str ->
                str.replace("(", "")
                        .replace(")", "")
                        .split(",")[0]).toList();

        // O(n) complexity
        for(String parent: listOfParents) {

        }

        System.out.println(listOfParents);
        System.out.println(listOfChilds);

        return strArr[0];
    }
}
