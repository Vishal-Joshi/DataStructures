package com.example;

public class RotateAndDelete {

    public static void main(String[] args) {
        RotateAndDelete rotateAndDelete = new RotateAndDelete();
        int[] inputArray = {1, 2, 3, 4, 5, 6};
        for (int i = 0; (i < inputArray.length || inputArray.length == 1); i++) {
            int n = inputArray.length;
            rotateAndDelete.performClockWiseRotation(inputArray);
            inputArray = rotateAndDelete.deleteNthElement(inputArray, n - i - 1);
            //rotateAndDelete.printArray(inputArray);
        }
    }

    private int[] performClockWiseRotation(int[] inputArray) {
        int size = inputArray.length;
        int lastElement = inputArray[size - 1];
        int elementToStore = inputArray[0];
        for (int i = 0; i < size - 1; i++) {
            int tempElementToStore = inputArray[i + 1];
            inputArray[i + 1] = elementToStore;
            elementToStore = tempElementToStore;
        }
        inputArray[0] = lastElement;
        System.out.print("rotation-->");
        printArray(inputArray);
        return inputArray;
    }

    private int[] deleteNthElement(int[] inputArray, int indexToDelete) {
        int size = inputArray.length;
        int[] newArray;
        if (size == indexToDelete + 1) {
            newArray = new int[size - 1];
            System.arraycopy(inputArray, 0, newArray, 0, size - 1);
            printArray(newArray);
            return newArray;
        } else {
            newArray = new int[size - 1];
            System.arraycopy(inputArray, 0, newArray, 0, indexToDelete);
            System.arraycopy(inputArray, indexToDelete + 1, newArray, indexToDelete, size - indexToDelete - 1);
            printArray(newArray);
            return newArray;
        }
    }

    private void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
