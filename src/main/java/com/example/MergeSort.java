package com.example;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        List<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(1);
        unsortedList.add(8);
        unsortedList.add(4);
        unsortedList.add(7);
        unsortedList.add(6);
        unsortedList.add(2);
        unsortedList.add(3);
        unsortedList.add(5);

        MergeSort mergeSort = new MergeSort();
        for (Integer integer : mergeSort.divideAndSort(unsortedList)) {
            System.out.print(integer + " ");
        }

    }

    public List<Integer> divideAndSort(List<Integer> unsortedList) {
        if (unsortedList.size() <= 1) {
            return unsortedList;
        } else {
            List<Integer> firstHalfOfList = new ArrayList<>(unsortedList.subList(0, unsortedList.size() / 2));
            List<Integer> secondHalfOfList = new ArrayList<>(unsortedList.subList(unsortedList.size() / 2, unsortedList.size()));
            return merge(divideAndSort(firstHalfOfList), divideAndSort(secondHalfOfList));
        }
    }

    public List<Integer> merge(List<Integer> firstHalfOfList, List<Integer> secondHalfOfList) {
        int firstListCounter = 0;
        int secondListCounter = 0;
        int finalListCounter = 0;
        List<Integer> mergedList = new ArrayList<>();
        while (firstListCounter < firstHalfOfList.size() && secondListCounter < secondHalfOfList.size()) {
            Integer firsListElement = firstHalfOfList.get(firstListCounter);
            Integer secondListElement = secondHalfOfList.get(secondListCounter);
            if (firsListElement < secondListElement) {
                mergedList.add(finalListCounter, firsListElement);
                firstListCounter++;
            } else {
                mergedList.add(finalListCounter, secondListElement);
                secondListCounter++;
            }
            finalListCounter++;
        }

        if (firstListCounter != firstHalfOfList.size()) {
            while (firstListCounter < firstHalfOfList.size()) {
                mergedList.add(finalListCounter, firstHalfOfList.get(firstListCounter));
                firstListCounter++;
                finalListCounter++;
            }
        } else if (secondListCounter != secondHalfOfList.size()) {
            while (secondListCounter < secondHalfOfList.size()) {
                mergedList.add(finalListCounter, secondHalfOfList.get(secondListCounter));
                secondListCounter++;
                finalListCounter++;
            }
        }

        return mergedList;
    }


}
