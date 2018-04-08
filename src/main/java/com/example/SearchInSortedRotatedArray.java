package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        SearchInSortedRotatedArray searchInSortedRotatedArray = new SearchInSortedRotatedArray();
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCase = Integer.parseInt(scanner.nextLine().trim());
        List<SearchArrayMetadata> searchArrayMetadataList = new ArrayList<>();
        for (int testCase = 0; testCase < numberOfTestCase; testCase++) {
            String nAndKey = scanner.nextLine().trim();
            String[] nAndKeyArray = nAndKey.split(" ");
            int n = Integer.parseInt(nAndKeyArray[0]);
            int key = Integer.parseInt(nAndKeyArray[1]);
            String[] inputArrayAsString = scanner.nextLine().trim().split(" ");
            int[] inputArray = new int[inputArrayAsString.length];
            for (int i = 0; i < inputArrayAsString.length; i++) {
                inputArray[i] = Integer.parseInt(inputArrayAsString[i]);
            }
            SearchArrayMetadata searchArrayMetadata = new SearchArrayMetadata(inputArray, n, key);
            searchArrayMetadataList.add(searchArrayMetadata);
        }
        for (SearchArrayMetadata searchArrayMetadata : searchArrayMetadataList) {
            int[] sortedRotatedArray = searchArrayMetadata.getInputArray();
            int n = searchArrayMetadata.getN();
            int keyToSearch = searchArrayMetadata.getKey();
            int pivot = searchInSortedRotatedArray.findPivot(sortedRotatedArray);

            //reverse right array into increasing order
            int rightArrayN = n - pivot-1;
            int[] increasingRightArray = new int[rightArrayN];
            int[] decreasingRightArray = new int[rightArrayN];
            System.arraycopy(sortedRotatedArray, pivot + 1, decreasingRightArray, 0, rightArrayN);
            for (int i = rightArrayN - 1; i >= 0; i--) {
                increasingRightArray[rightArrayN - i - 1] = decreasingRightArray[i];
            }
            int[] mergedArray = new int[n];
            System.arraycopy(sortedRotatedArray, 0, mergedArray, 0, pivot + 1);
            System.arraycopy(increasingRightArray, 0, mergedArray, pivot + 1, rightArrayN);

            assert mergedArray.length == sortedRotatedArray.length;
            System.out.println("Merged array");
            searchInSortedRotatedArray.printArray(mergedArray);
            //System.out.println("pivot is: " + pivot);
            if (pivot != -1) {
                int indexOfElement = -1;
                if (sortedRotatedArray[pivot] == keyToSearch) {
                    System.out.println(pivot);
                } else if (sortedRotatedArray[0] > keyToSearch) {
                    //right sub array of pivot
                    int indexOfElementInSubArray = Arrays.binarySearch(sortedRotatedArray, pivot + 1, n, keyToSearch);
                    if (indexOfElementInSubArray < 0) {
                        indexOfElement = indexOfElementInSubArray + pivot + 1;
                    }
                } else if (sortedRotatedArray[0] <= keyToSearch) {
                    //left sub array of pivot
                    indexOfElement = Arrays.binarySearch(sortedRotatedArray, 0, pivot + 1, keyToSearch);
                }
                if (indexOfElement < 0) {
                    System.out.println("OOPS! NOT FOUND");
                } else {
                    System.out.println(indexOfElement);
                }
            }
        }



    }

    private int findPivot(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if ((i + 1 < n) && (array[i] > array[i + 1])) {
                return i;
            }
        }
        return -1;
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
    }

    private static class SearchArrayMetadata {
        private int[] inputArray;
        private int n;
        private int key;

        SearchArrayMetadata(int[] inputArray, int n, int key) {
            this.inputArray = inputArray;
            this.n = n;
            this.key = key;
        }

        public int[] getInputArray() {
            return inputArray;
        }

        public int getN() {
            return n;
        }

        public int getKey() {
            return key;
        }
    }
}

