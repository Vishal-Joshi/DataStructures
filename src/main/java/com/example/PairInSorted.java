package com.example;

public class PairInSorted {

    public static void main(String[] args) {
        PairInSorted pairInSorted = new PairInSorted();
        int[] array = new int[]{11, 15, 6, 8, 9, 10};
        int x = 16;
        int pivot = pairInSorted.findPivot(array);
        if (pivot != -1) {
            System.out.print(pairInSorted.ifPairExists(array, x, pivot));
        }

    }

    private boolean ifPairExists(int[] array, int x, int pivot) {
        int n = array.length;
        int l = (pivot + 1) % n;
        int r = pivot;
        System.out.println("pivot=" + pivot);
        System.out.println("n=" + n);
        System.out.println("2%6="+(2%6));
        while (l != r) {
            System.out.println("l=" + l + " r=" + r);
            int sum = array[l] + array[r];
            if (sum == x) {
                System.out.println(String.format("(%d(array[%d])+%d(array[%d])=%d)==%d", array[l], l, array[r], r, sum, x));
                return true;
            } else if (sum < x) {
                System.out.println(String.format("(%d(array[%d])+%d(array[%d])=%d)<%d", array[l], l, array[r], r, sum, x));
                l = (l + 1) % n;
            } else {
                System.out.println(String.format("(%d(array[%d])+%d(array[%d])=%d)>%d", array[l], l, array[r], r, sum, x));
                r = (n + r - 1) % n;
            }

        }
        return false;
    }

    private int findPivot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
