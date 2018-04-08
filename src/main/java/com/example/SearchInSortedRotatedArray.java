package com.example;

import java.util.Arrays;

public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        SearchInSortedRotatedArray searchInSortedRotatedArray = new SearchInSortedRotatedArray();
        int[] sortedRotatedArray = new int[]{3, 4, 5, 1, 2};
        int n = sortedRotatedArray.length;
        int keyToSearch = 4;
        int pivot = searchInSortedRotatedArray.findPivot(sortedRotatedArray);
        System.out.println("pivot is: " + pivot);
        if (pivot != -1) {
            if (sortedRotatedArray[pivot] == keyToSearch) {
                System.out.println(keyToSearch + " is found at: " + pivot);
            } else if (sortedRotatedArray[0] > keyToSearch) {
                //right sub array of pivot
                int dividedN = n - pivot - 1;
                int[] arrayToPerformBinarySearch = new int[dividedN];
                System.arraycopy(sortedRotatedArray, pivot + 1, arrayToPerformBinarySearch, 0, dividedN);
                int indexOfElementInSubArray = Arrays.binarySearch(arrayToPerformBinarySearch, keyToSearch);
                int indexOfElement = indexOfElementInSubArray + pivot + 1;
                System.out.println(keyToSearch + " is found at: " + indexOfElement);
            } else if (sortedRotatedArray[0] <= keyToSearch) {
                //left sub array of pivot
                int dividedN = n - pivot;
                int[] arrayToPerformBinarySearch = new int[dividedN];
                System.arraycopy(sortedRotatedArray, 0, arrayToPerformBinarySearch, 0, pivot + 1);
                int indexOfElement = Arrays.binarySearch(arrayToPerformBinarySearch, keyToSearch);
                System.out.println(keyToSearch + " is found at: " + indexOfElement);
            }
        }
    }

    private int findPivot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}

