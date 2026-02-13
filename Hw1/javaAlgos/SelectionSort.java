/*
 * Name: Daniel Briseno
 * Professor: Dr. Dai
 * Course: CS416 - Software Engineering
 * Date: Feb 13, 2026
 *
 * File: SelectionSort.java
 * Description:
 *   Implements the Selection Sort algorithm for sorting an integer array in ascending order.
 */

import java.util.Arrays;

public class SelectionSort {

    /**
     * Sorts the given array in ascending order using Selection Sort.
     *
     * Selection Sort works by repeatedly selecting the smallest element from the
     * unsorted portion of the array and swapping it into its correct position.
     *
     * Time Complexity:
     *   - Worst/Average/Best: O(n^2)
     * Space Complexity:
     *   - O(1) (in-place)
     *
     * @param arr the array to be sorted (modified in-place)
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Nothing to sort
        }

        int n = arr.length;

        // Move the boundary of the unsorted subarray one index at a time.
        for (int i = 0; i < n - 1; i++) {

            // Assume the first unsorted element is the smallest.
            int minIndex = i;

            // Find the index of the smallest element in the remaining unsorted portion.
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first unsorted element (if needed).
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * Example driver to demonstrate Selection Sort.
     * You can remove or modify this main method depending on assignment requirements.
     */
    public static void main(String[] args) {
        int[] data = { 64, 25, 12, 22, 11, 0, -5 };

        System.out.println("Before: " + Arrays.toString(data));
        selectionSort(data);
        System.out.println("After:  " + Arrays.toString(data));
    }
}
