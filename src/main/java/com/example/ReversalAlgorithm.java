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
            int displacement = Integer.parseInt(scanner.nextLine().trim());
            reversalAlgorithm.printArray(reversalAlgorithm.leftRotateArray(inputArray, displacement));
        }

    }

    private int[] leftRotateArray(int[] inputArray, int displacement) {
        for (int i = 0; i < displacement; i++) {
            inputArray = leftRotateArrayByOne(inputArray);
        }
        return inputArray;
    }

    private int[] leftRotateArrayByOne(int[] inputArray) {
        int firstElement = inputArray[0];
        int length = inputArray.length;
        System.arraycopy(inputArray, 1, inputArray, 0, length - 1);
        inputArray[length - 1] = firstElement;
        return inputArray;
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
