package com.example;

public class BlockSwapAlgorithm {

    public static void main(String[] args) {
        BlockSwapAlgorithm blockSwapAlgorithm = new BlockSwapAlgorithm();
        int[] array = new int[]{1, 2, 3, 4, 5};
        int[] arrayRotated = blockSwapAlgorithm.leftRotate(array, 4, array.length);
        blockSwapAlgorithm.printArray(arrayRotated);
    }

    private int[] leftRotate(int[] array, int d, int n) {
        System.out.print("leftRotate array called with d: " + d + " n: " + n + " and array: ");
        printArray(array);
        System.out.println();
        if (d == 0 || d == n) {
            return array;
        }
        if (d < n - d) {
            //A is shorter
            System.out.println("A is shorter: d = " + d + ", n-d = " + (n - d));
            swap(array, 0, n - d, d);
            return leftRotate(array, d, n - d);
        } else if (d > n - d) {
            //B is shorter
            System.out.println("B is shorter: d = " + d + ", n-d = " + (n - d));
            int[] newArray = new int[array.length];
            swap(array, 0, d, n - d);
            System.arraycopy(array, 0, newArray, 0, n - d);
            int[] subArray = divideArray(array, n - d);
            int[] rotatedArray = leftRotate(subArray, 2 * d - n, d);
            System.out.print("Merging, ");
            printArray(newArray);
            System.out.print(" with ");
            printArray(rotatedArray);
            System.out.println();
            System.arraycopy(rotatedArray, 0, newArray, n - d, rotatedArray.length);
            return newArray;
        } else if (d == n - d) {
            System.out.println("A and B are equal: d = " + d + ", n-d = " + (n - d));
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

    private int[] swap(int[] array, int startIndexOfFirstSubArray, int startIndexOfOtherSubArray, int numberOfElements) {
        int[] newArray = new int[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        for (int index = 0; index < numberOfElements; index++) {
            int resultantIndexOfOtherSubArray = startIndexOfOtherSubArray + index;
            int resultantIndexOfFirstSubArray = startIndexOfFirstSubArray + index;
            int temp = newArray[resultantIndexOfOtherSubArray];
            newArray[resultantIndexOfOtherSubArray] = newArray[resultantIndexOfFirstSubArray];
            newArray[resultantIndexOfFirstSubArray] = temp;
        }
        System.out.println("Swapping operation:------------");
        System.out.print("from: --> ");
        printArray(array);
        System.out.println();
        System.out.print("to: ---> ");
        printArray(newArray);
        System.out.println();
        System.arraycopy(newArray, 0, array, 0, newArray.length);
        return array;
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
