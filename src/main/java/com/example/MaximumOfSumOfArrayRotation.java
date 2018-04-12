package com.example;

public class MaximumOfSumOfArrayRotation {

    public static void main(String[] args) {
        MaximumOfSumOfArrayRotation maximumOfSumOfArrayRotation = new MaximumOfSumOfArrayRotation();
        int[] array = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int maxRotationSum = maximumOfSumOfArrayRotation.findMaxRotationSum(array, maximumOfSumOfArrayRotation.sumOfArrayElements(array));
        System.out.println(maxRotationSum);
    }

    private int sumOfArrayElements(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    private int findMaxRotationSum(int[] array, int sum) {
        int r0 = 0;
        int n = array.length;
        for (int i = 0; i < array.length; i++) {
            r0 += i * array[i];
        }
        int maxVal = r0;
        int currentVal = maxVal;
        for (int j = 1; j < n; j++) {
            currentVal += sum - n * array[n - j];
            if (currentVal > maxVal) {
                maxVal = currentVal;
            }
        }
        return maxVal;
    }
}
