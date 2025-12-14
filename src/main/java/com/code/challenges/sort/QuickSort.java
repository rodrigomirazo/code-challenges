package com.code.challenges.sort;

import com.code.challenges.divideAndConquer.MergeKLists;

import java.util.Arrays;

public class QuickSort {

    static void main() {

        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Unsorted array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Choose the last element as the pivot
        int pivot = arr[high];
        int smallerIndex = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                smallerIndex++;

                // Swap arr[i] and arr[j]
                int temp = arr[smallerIndex];
                arr[smallerIndex] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[smallerIndex + 1];
        arr[smallerIndex + 1] = arr[high];
        arr[high] = temp;

        return smallerIndex + 1;
    }
}
