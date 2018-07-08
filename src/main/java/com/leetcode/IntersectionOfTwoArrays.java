package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1};
        intersectionOfTwoArrays.intersection(nums1, nums2);
    }

    private int[] intersection(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] arrayToLoop = null;
        int[] arrayToSearch = null;
        System.out.println(length1+"--"+length2);
        if(length1 != 0 && length2 != 0){
            if(length1<length2){
                arrayToLoop = nums2;
                arrayToSearch = nums1;

            } else {
                arrayToLoop = nums1;
                arrayToSearch = nums2;
            }

            int lastIndexOfMatch = -1;
            int arrayToSearchCounter = 0;
            for (int i=0; (i< arrayToLoop.length) || (arrayToSearchCounter < arrayToSearch.length); i++){
                if(arrayToLoop[i]==arrayToSearch[arrayToSearchCounter]){
                    lastIndexOfMatch=i;
                    ++arrayToSearchCounter;
                }
                if(lastIndexOfMatch!=-1){
                    break;
                }
            }
            System.out.println("arrayToSearchCounter: "+arrayToSearchCounter);
            List<Integer> newNonDuplicateArray = new ArrayList<Integer>();

            for(int i=0;i<=arrayToSearchCounter;i++){
                boolean isDuplicate = false;
                for(int j=0;j<newNonDuplicateArray.size();j++){
                    if(newNonDuplicateArray.get(j)==arrayToSearch[i]){
                        isDuplicate=true;
                        break;
                    }
                }
                if(!isDuplicate){
                    newNonDuplicateArray.add(arrayToSearch[i]);
                    System.out.println("adding: "+arrayToSearch[i]);
                }
            }

            int[] resultantArray = new int[newNonDuplicateArray.size()];
            int resultantArrayCounter = 0;
            for(Integer element:newNonDuplicateArray){
                resultantArray[resultantArrayCounter]=element;
                ++resultantArrayCounter;
            }

            return resultantArray;
        } else {
            return new int[0];
        }

    }
}
