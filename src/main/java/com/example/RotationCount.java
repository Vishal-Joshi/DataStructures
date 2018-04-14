package com.example;

public class RotationCount {

    public static void main(String[] args) {
        RotationCount rotationCount = new RotationCount();
        //int[] array = new int[]{7, 9, 11, 12, 5};
        int[] array = new int[]{5, 7, 9, 11, 12};
        System.out.print(rotationCount.findMinElementIndex(array, array.length - 1, 0));
    }

    private int findMinElementIndex(int[] array, int high, int low) {
        if (high < low) {
            return low;
        }
        if (high == low) {
            return low;
        }
        int mid = (high + low) / 2;

        if (mid > low && array[mid] < array[mid - 1]) {
            return mid;
        }

        if (mid < high && array[mid] > array[mid + 1]) {
            return mid + 1;
        }
        if (array[mid] < array[high]) {
            return findMinElementIndex(array, mid - 1, low);
        } else if (array[mid] > array[high]) {
            return findMinElementIndex(array, high, mid + 1);
        }
        return -1;
    }
}
