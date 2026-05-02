package com.code.challenges.bonzzu;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {


    static String I = "I";
    static String V = "V";
    static String X = "X";//10
    static String L = "L";//50
    static String C = "C";//100
    static String D = "D";//500
    static String M = "M";//1,000

    static void main() {

        //System.out.println("case 1: XXVII => " + romanToInt("XXVII"));
        //System.out.println("case 2: XCIX => " + romanToInt("XCIX"));

        System.out.println("case 1: 2200 => " + intToRoman(2222));
    }

    private static int romanToInt(String romanNumber) {
        // XXVII
        // XCIX => 99 > XC (10 - 100), IX (1 - 10)

        Map<String, Integer> romanIntMap = new HashMap<>();
        romanIntMap.put(I, 1);
        romanIntMap.put(V, 5);
        romanIntMap.put(X, 10);
        romanIntMap.put(L, 50);
        romanIntMap.put(C, 100);
        romanIntMap.put(D, 500);
        romanIntMap.put(M, 1000);

        char[] charArray = romanNumber.toCharArray();
        int total = romanIntMap.get(Character.toString(charArray[0]));

        for (int i = 1; i < charArray.length; i++) {
            // total = 10
            int currentInt = romanIntMap.get(Character.toString(charArray[i])); // c = 100
            int prevInt = romanIntMap.get(Character.toString(charArray[i-1])); // x = 10
            if(currentInt > prevInt) {
                total = total + currentInt - (prevInt*2); // 10 + 100 - 20
            } else {
                total = total + currentInt;
            }
            System.out.println(total);
        }
        return total;
    }

    private static String intToRoman(int number) {
        // XXVIIw
        // XCIX => 99 > XC (10 - 100), IX (1 - 10)

        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};

        return thousands[(number/1000)] + hundreds[ (number%1000)/100 ] + tens[ (number%100)/10 ] + units[ (number%10) ];
    }

}








