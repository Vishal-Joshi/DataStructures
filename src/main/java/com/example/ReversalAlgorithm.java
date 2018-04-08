package com.example;

import java.util.Scanner;

public class ReversalAlgorithm {

    public static void main(String[] args) {
        ReversalAlgorithm reversalAlgorithm = new ReversalAlgorithm();
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCase = Integer.parseInt(scanner.nextLine().trim());
        for (int testCase = 0; testCase < numberOfTestCase; testCase++) {
            int lengthOfArray = Integer.parseInt(scanner.nextLine().trim());
            int[] inputArray = new int[lengthOfArray];
            String arrayElements = scanner.nextLine().trim();
            int count = 0;
            for (String stringArrayElement : arrayElements.split(" ")) {
                inputArray[count++] = Integer.parseInt(stringArrayElement);
            }
            int d = Integer.parseInt(scanner.nextLine().trim());
            int n = inputArray.length;
            int[] firstSubArray = new int[d];
            int[] secondSubArray = new int[n - d];
            System.arraycopy(inputArray, 0, firstSubArray, 0, d);
            System.arraycopy(inputArray, d, secondSubArray, 0, n - d);
            int[] reversedArray1 = reversalAlgorithm.reverseArray(firstSubArray);
            int[] reversedArray2 = reversalAlgorithm.reverseArray(secondSubArray);
            int[] reversedTotalArray = new int[n];
            System.arraycopy(reversedArray1, 0, reversedTotalArray, 0, reversedArray1.length);
            System.arraycopy(reversedArray2, 0, reversedTotalArray, reversedArray1.length, reversedArray2.length);

            int[] reverseOfTotalArray = reversalAlgorithm.reverseArray(reversedTotalArray);
            reversalAlgorithm.printArray(reverseOfTotalArray);
        }

    }

    private int[] reverseArray(int[] arrayToReverse) {
        int n = arrayToReverse.length;
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[n - i - 1] = arrayToReverse[i];
        }
        return newArray;
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
