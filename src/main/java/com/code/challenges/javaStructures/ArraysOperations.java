package com.code.challenges.javaStructures;

import java.util.Arrays;

public class ArraysOperations {

    static void main() {
        int[] numbers = {10, 20, 30};
        //loop
        for (int number : numbers) {
            System.out.println(number);
        }
        //length
        int elements = numbers.length;
        // Copy
        int[] source = {1, 2, 3};
        int[] destination2 = Arrays.copyOf(source, source.length);
        //sort
        Arrays.sort(numbers);
        //search
        int index = Arrays.binarySearch(numbers, 3);
    }
}
