package com.example;

public class BlockSwapAlgorithmOwnPractice {

    public static void main(String[] args) {
        BlockSwapAlgorithmOwnPractice blockSwapAlgorithmOwnPractice = new BlockSwapAlgorithmOwnPractice();
        int[] arrayToRotate = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arrayToRotate.length;
        int d = 2;
        int[] rotatedArray = blockSwapAlgorithmOwnPractice.rotateArray(arrayToRotate, 0, n - 1, d, n);
        printArray(rotatedArray);
        System.out.println();

    }

    private static void printArray(int[] rotatedArray) {
        for (int aRotatedArray : rotatedArray) {
            System.out.print(aRotatedArray + " ");
        }
    }

    private int[] rotateArray(int[] arrayToRotate, int startIndex, int endIndex, int d, int n) {
        System.out.println(String.format("startIndex: %d, endIndex: %d, d: %d, n: %d", startIndex, endIndex, d, n));
        if (startIndex < endIndex) {
            if (d == n - d) {
                System.out.println("A = B");
                swap(arrayToRotate, startIndex, startIndex + d - 1, startIndex + n - d, startIndex + n - 1);
            }
            if (d < n - d) {
                System.out.println("A is shorter");
                swap(arrayToRotate, startIndex, d - 1, n - d, endIndex);
                rotateArray(arrayToRotate, startIndex, n - d - 1, d, n - d);
            } else if (d > n - d) {
                System.out.println("B is shorter");
                swap(arrayToRotate, startIndex, n - d - 1, d, endIndex);
                rotateArray(arrayToRotate, startIndex + n - d, n - 1, 2 * d - n, n - d + 1);
            }

        }
        return arrayToRotate;
    }

    private void swap(int[] arrayToSwap, int start, int end, int secondStart, int secondEnd) {
        System.out.print("Before swap--> ");
        printArray(arrayToSwap);
        System.out.println();
        int index = start;
        int secondIndex = secondStart;
        while (index <= end && secondIndex <= secondEnd) {
            int temp = arrayToSwap[index];
            arrayToSwap[index] = arrayToSwap[secondIndex];
            arrayToSwap[secondIndex] = temp;
            index++;
            secondIndex++;
        }
        System.out.print("After  swap--> ");
        printArray(arrayToSwap);
        System.out.println();
    }
}
