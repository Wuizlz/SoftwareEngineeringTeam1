/*
 * Name: Daniel Briseno
 * Professor: Dr. Dai
 * Course: CS416 - Software Engineering
 * Date: Feb 13, 2026
 *
 * File: MergeSort.java
 * Description:
 *   Implements the Merge Sort algorithm for sorting an integer array in ascending order.
 */

import java.util.Arrays;

public class MergeSort {

    /**
     * Sorts the given array in ascending order using Merge Sort.
     *
     * Merge Sort is a divide-and-conquer algorithm:
     * 1) Divide the array into two halves.
     * 2) Recursively sort each half.
     * 3) Merge the two sorted halves back together.
     *
     * Time Complexity:
     *   - Worst/Average/Best: O(n log n)
     * Space Complexity:
     *   - O(n) (requires extra array for merging)
     *
     * @param arr the array to be sorted (modified in-place)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Nothing to sort
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    // Recursive helper that sorts arr[left..right]
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return; // Base case: one element
        }

        int mid = left + (right - left) / 2;

        // Sort left half
        mergeSort(arr, left, mid);

        // Sort right half
        mergeSort(arr, mid + 1, right);

        // Merge sorted halves
        merge(arr, left, mid, right);
    }

    // Merges two sorted subarrays: arr[left..mid] and arr[mid+1..right]
    private static void merge(int[] arr, int left, int mid, int right) {

        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Temporary arrays to hold the split halves
        int[] L = new int[leftSize];
        int[] R = new int[rightSize];

        // Copy data into temp arrays
        for (int i = 0; i < leftSize; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;     // index into L
        int j = 0;     // index into R
        int k = left;  // index into arr

        // Merge while both arrays have elements left
        while (i < leftSize && j < rightSize) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of L
        while (i < leftSize) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements of R
        while (j < rightSize) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Example driver to demonstrate Merge Sort.
     * You can remove or modify this main method depending on assignment requirements.
     */
    public static void main(String[] args) {
        int[] data = { 38, 27, 43, 3, 9, 82, 10, 0, -7 };

        System.out.println("Before: " + Arrays.toString(data));
        mergeSort(data);
        System.out.println("After:  " + Arrays.toString(data));
    }
}
