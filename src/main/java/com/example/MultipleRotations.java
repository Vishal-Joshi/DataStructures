package com.example;

public class MultipleRotations {
    public static void main(String[] args) {
        MultipleRotations multipleRotations = new MultipleRotations();
        int[] array = new int[]{1, 3, 5, 7, 9};
        int k = 14;
        int[] newArray = multipleRotations.multipleRotatedArray(array, k);
        for (int i : newArray) {
            System.out.print(i + " ");
        }
    }

    private int[] multipleRotatedArray(int[] array, int k) {
        int n = array.length;
        int startIndex = k % n;

        int[] rotatedArray = new int[n];

        int i = 0;
        int j = startIndex;
        while (i <= startIndex) {
            rotatedArray[i++] = array[j];
            if (!((++j) < n)) {
                j = 0;
            }
        }
        return rotatedArray;
    }
}
