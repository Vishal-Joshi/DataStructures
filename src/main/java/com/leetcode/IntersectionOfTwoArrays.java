package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] nums1 = new int[]{2,1};
        int[] nums2 = new int[]{1,2};
        for (int element : intersectionOfTwoArrays.intersection(nums1, nums2)) {
            System.out.print(element);
        }
    }

    private int[] intersection(int[] nums1, int[] nums2) {
        int arrayToSearchCounter = 0;
        for (int i = 0; (i < nums1.length) && (arrayToSearchCounter < nums2.length); i++) {
            if (nums1[i] == nums2[arrayToSearchCounter]) {
                ++arrayToSearchCounter;
            }
        }
        List<Integer> newNonDuplicateArray = new ArrayList<>();

        for (int i = 0; i < arrayToSearchCounter; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < newNonDuplicateArray.size(); j++) {
                if (newNonDuplicateArray.get(j) == nums2[i]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                newNonDuplicateArray.add(nums2[i]);
            }
        }

        int[] resultantArray = new int[newNonDuplicateArray.size()];
        int resultantArrayCounter = 0;
        for (Integer element : newNonDuplicateArray) {
            resultantArray[resultantArrayCounter] = element;
            ++resultantArrayCounter;
        }

        return resultantArray;
    }
}
