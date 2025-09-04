package com.code.challenges.others;

public class ConvertIntegerToRomanNumber {

    /*
        I (1), V (5), X (10), L (50), C (100), D (500), and M (1,000)
     */
    static String I = "I";
    static String V = "V";
    static String X = "X";//10
    static String L = "L";//50
    static String C = "C";//100
    static String D = "D";//500
    static String M = "M";//1,000

    public static void main(String[] args) {
        Integer number = 1234;

        System.out.println(toRomanNumber(number));
    }

    private static String toRomanNumber(Integer number) {
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens  = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};

        // 1234
        // hundreds => 1234 / 10 => 123 => 12 % 10 => 3
        System.out.println((number)%10);
        return thousands[number/1000] + hundreds[ (number/100)%10] + tens[(number/10)%10] + units[number%10];
    }

}










