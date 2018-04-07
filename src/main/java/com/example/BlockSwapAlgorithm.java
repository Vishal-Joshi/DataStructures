package com.example;

public class BlockSwapAlgorithm {

    public static void main(String[] args) {
        BlockSwapAlgorithm blockSwapAlgorithm = new BlockSwapAlgorithm();
        int[] array = new int[]{1, 2, 3, 4, 5};
        blockSwapAlgorithm.leftRotate(array, 2, array.length);
        blockSwapAlgorithm.printArray(array);
    }

    private int[] leftRotate(int[] array, int d, int n) {
        if (d == 0 || d == n) {
            return array;
        }
        if (d < n - d) {
            //A is shorter
            swap(array, 0, n - d, d);
            leftRotate(array, d, n - d);
            return array;
        } else if (d > n - d) {
            //B is shorter
            int[] newArray = new int[array.length];
            swap(array, 0, d, n - d);
            System.arraycopy(array, 0, newArray, 0, n - d);
            int[] rotatedArray = leftRotate(divideArray(array, n - d), 2 * d - n, d);
            System.arraycopy(rotatedArray, 0, newArray, n - d, rotatedArray.length);
            return newArray;
        } else if (d == n - d) {
            swap(array, 0, n - d, d);
            return array;
        }
        return null;
    }

    private int[] divideArray(int[] array, int from) {
        int[] dividedArray = new int[array.length - from];
        System.arraycopy(array, from, dividedArray, 0, array.length - from);
        return dividedArray;
    }

    private int[] swap(int array[], int startIndexOfFirstSubArray, int startIndexOfOtherSubArray, int numberOfElements) {
        for (int index = 0; index < numberOfElements; index++) {
            int temp = array[startIndexOfOtherSubArray];
            array[startIndexOfOtherSubArray] = array[startIndexOfFirstSubArray];
            array[startIndexOfFirstSubArray] = temp;
        }
        return array;
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
