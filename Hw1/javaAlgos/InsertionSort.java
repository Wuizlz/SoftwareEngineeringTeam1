/*
 * Name: Daniel Briseno
 * Professor: Dr. Dai
 * Course: CS416 - Software Engineering
 * Date: Feb 13, 2026
 *
 * File: InsertionSort.java
 * Description:
 *   Implements the Insertion Sort algorithm for sorting an integer array in ascending order.
 */

import java.util.Arrays;

public class InsertionSort {

    /**
     * Sorts the given array in ascending order using Insertion Sort.
     *
     * Insertion Sort builds a sorted portion of the array one element at a time.
     * For each element, it shifts larger elements in the sorted portion to the right
     * and inserts the current element into its correct position.
     *
     * Time Complexity:
     *   - Worst/Average: O(n^2)
     *   - Best (already sorted): O(n)
     * Space Complexity:
     *   - O(1) (in-place)
     *
     * @param arr the array to be sorted (modified in-place)
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Nothing to sort
        }

        // Start from the second element since a single-element "sorted" list is already sorted.
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];      // The element we want to insert into the sorted portion.
            int j = i - 1;         // Index of the last element in the sorted portion.

            // Shift elements that are greater than key one position to the right.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the key into the correct position.
            arr[j + 1] = key;
        }
    }

    /**
     * Example driver to demonstrate Insertion Sort.
     * You can remove or modify this main method depending on assignment requirements.
     */
    public static void main(String[] args) {
        int[] data = { 9, 5, 1, 4, 3, 0, -2 };

        System.out.println("Before: " + Arrays.toString(data));
        insertionSort(data);
        System.out.println("After:  " + Arrays.toString(data));
    }
}
