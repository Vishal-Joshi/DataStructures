package com.leetcode;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 2;
        rotateArray.printArray(nums);
        rotateArray.rotate(nums, k);
        rotateArray.printArray(nums);
    }

    private void printArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println(nums[nums.length - 1]);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int start = 0; count < n; start++) {
            int current = start;
            int currentElement = nums[start];
            int next = (current + k) % n;
            for (int i = next; i != start; i = ((current + k) % n)) {
                int temp = nums[i];
                nums[i] = currentElement;
                currentElement = temp;
                current = i;
                ++count;
            }
        }
    }
}
