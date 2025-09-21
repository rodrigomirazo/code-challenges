package com.code.challenges.others;

public class ConvertIntegerToRomanNumber {

    /*
        Statement:

        Convert a given integer into a Roman Number.
        Example 2: 45 => XLV
        Example 2: 1234 => MCCXXXIV
     */
    static String I = "I";
    static String V = "V";
    static String X = "X";//10
    static String L = "L";//50
    static String C = "C";//100
    static String D = "D";//500
    static String M = "M";//1,000

    static void main(String[] args) {
        Integer number = 45;

        System.out.println(toRomanNumber(number));
    }

    private static String toRomanNumber(Integer number) {
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens  = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};

        // 1234
        // hundreds => 1234 / 10 => 123 => 12 % 10 => 3
        return thousands[number/1000] + hundreds[ (number/100)%10] + tens[(number/10)%10] + units[number%10];
    }

}










