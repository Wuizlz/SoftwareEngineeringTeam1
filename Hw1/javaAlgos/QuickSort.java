/*
 * Name: Daniel Briseno
 * Professor: Dr. Dai
 * Course: CS416 - Software Engineering
 * Date: Feb 13, 2026
 *
 * File: QuickSort.java
 * Description:
 *   Implements the Quick Sort algorithm for sorting an integer array in ascending order.
 */

import java.util.Arrays;

public class QuickSort {

    /**
     * Sorts the given array in ascending order using Quick Sort.
     *
     * Quick Sort is a divide-and-conquer algorithm:
     * 1) Choose a pivot element.
     * 2) Partition the array so elements <= pivot are on the left, and elements > pivot are on the right.
     * 3) Recursively sort the left and right partitions.
     *
     * Notes:
     * - This implementation uses the "Lomuto partition scheme" (pivot = last element).
     *
     * Time Complexity:
     *   - Average/Best: O(n log n)
     *   - Worst: O(n^2) (can happen with poor pivot choices, e.g., already sorted data)
     * Space Complexity:
     *   - O(log n) average recursion depth (worst-case O(n))
     *
     * @param arr the array to be sorted (modified in-place)
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Nothing to sort
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // Recursive helper to sort arr[low..high]
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after pivot
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array using the last element as pivot (Lomuto partition scheme).
     *
     * After partitioning:
     * - pivot is placed in its final sorted position
     * - all elements <= pivot are to the left
     * - all elements > pivot are to the right
     *
     * @return the final pivot index
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];   // Choose the last element as pivot
        int i = low - 1;         // Index of smaller element

        // Move elements <= pivot to the front portion
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in the correct position by swapping arr[i+1] and arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Example driver to demonstrate Quick Sort.
     * You can remove or modify this main method depending on assignment requirements.
     */
    public static void main(String[] args) {
        int[] data = { 10, 7, 8, 9, 1, 5, 0, -4, 10 };

        System.out.println("Before: " + Arrays.toString(data));
        quickSort(data);
        System.out.println("After:  " + Arrays.toString(data));
    }
}
