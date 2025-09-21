package com.code.challenges.others;

import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToInteger {

    /*
        Statement:

        Convert a given Roman number into an Integer.
        Example 2: XLV => 45
        Example 2: MMDCCXLIV => 2744
    */
    static String I = "I";
    static String V = "V";
    static String X = "X";//10
    static String L = "L";//50
    static String C = "C";//100
    static String D = "D";//500
    static String M = "M";//1,000

    public static void main(String[] args) {
        toInteger("XLV");
    }

    private static int toInteger(String romanNumber) {
        Map<String, Integer> romanValues = new HashMap<>();
        romanValues.put(I, 1);
        romanValues.put(V, 5);
        romanValues.put(X, 10);
        romanValues.put(L, 50);
        romanValues.put(C, 100);
        romanValues.put(D, 500);
        romanValues.put(M, 1000);

        // 1. Iterate String from left to right
        // 2. Relate each String character to the Key-Value of the Map
        // 3. each Iteration will 'increase the Counter Variable'
        // 4. There is going to be one condition
        //      a. if 'for i' is greater than Zero and Previous Roman Letter is Greater than the Previous One
        //      b. Decrease Previous and current char (2 times previous one)
        //          40 => XL => 10 + 50 + (-10 * 2) = 40

        int increase = 0;
        for (int i = 0; i < romanNumber.length(); i++) {

            if(i > 0 && romanValues.get(romanNumber.charAt(i)+"") > romanValues.get(romanNumber.charAt(i-1)+"")) {
                // IX -> Increase = x(10) - 2*( I(1) )
                increase = increase + romanValues.get(romanNumber.charAt(i)+"") - romanValues.get(romanNumber.charAt(i-1)+"") * 2;
            } else {
                increase = increase + romanValues.get(romanNumber.charAt(i) + "");
            }
        }

        System.out.println("Integer is: " + increase);
        return increase;
    }
}
