package com.example;

import java.util.List;
import java.util.Objects;

public class FindStartIndexOfSubList {

    public int findIndex(List<Integer> fullList, List<Integer> sublist) {
        int indexOfFirstElement = fullList.indexOf(sublist.get(0));
        if (indexOfFirstElement != -1) {
            for (int i = 1; i < sublist.size(); i++) {
                if(!Objects.equals(sublist.get(i), fullList.get(indexOfFirstElement+i))){
                    return -1;
                }
                return indexOfFirstElement;
            }
        }
        return -1;
    }
}
