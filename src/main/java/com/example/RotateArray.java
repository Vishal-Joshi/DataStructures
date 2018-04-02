package com.example;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        for (int i : rotateArray.leftRotateArray(array, 2)) {
            System.out.print(i + " ");
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
        for (int i = 0; i < inputArray.length - 1; i++) {
            inputArray[i] = inputArray[i + 1];
        }
        inputArray[inputArray.length - 1] = firstElement;
        return inputArray;
    }
}
