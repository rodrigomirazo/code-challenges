package com.code.challenges.bonzzu;

import java.util.*;

/*
    Merge to sortered Arrays

    input:
    {1,3,5,10} {2,4,6,7,8,12}

    output:
    {1,2,3,4,5,6,7,8,10,12}
 */
public class MergeSortedArrays {

    static void main() {

        int[] input1 = {1,3,5,10};
        int[] input2 = {2,4,6,7,8,12};

        int[] arr = mergeArrays(input1, input2);
    }

    private static int[] mergeArrays(int[] input1, int[] input2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        /*
        for (int i = 0; i < input1.length; i++) {
            stack1.push(input1[i]);
        }
        */
        for (int i = input1.length - 1; i >= 0 ; i--) {
            stack1.push(input1[i]);
        }
        for (int i = input2.length - 1; i >= 0 ; i--) {
            stack2.push(input2[i]);
        }

        List<Integer> mergedList = new ArrayList<>();

        while (!stack1.empty() || !stack2.empty()) {
            if(!stack1.isEmpty() && stack1.peek() <= stack2.peek()) {
                mergedList.add(stack1.pop());
            } else if(!stack2.isEmpty()) {
                mergedList.add(stack2.pop());
            }
        }
        System.out.println(mergedList);
        return mergedList.stream().mapToInt(Integer::intValue).toArray();
    }
}
