package com.example;

public class MergeSortedListIterative {
    public static void main(String[] args) {
        MergeSortedListIterative mergeSortedListIterative = new MergeSortedListIterative();
        Node five = new Node(5, null);
        Node three = new Node(3, five);
        Node list1 = new Node(2, three);

        Node seven = new Node(7, null);
        Node six = new Node(6, seven);
        Node list2 = new Node(1, six);

        Node currentNode = mergeSortedListIterative.iterativeMerge(list1, list2);
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
    }

    private Node iterativeMerge(Node list1, Node list2) {
        Node mergedListHead = null;
        Node mergeListCurrent = null;
        while (list1 != null && list2 != null) {
            if (mergedListHead == null) {
                if (list1.getData() < list2.getData()) {
                    mergedListHead = list1;
                    list1 = list1.getNext();
                } else if (list1.getData() > list2.getData()) {
                    mergedListHead = list2;
                    list2 = list2.getNext();
                } else {
                    mergedListHead = list1;
                    list1 = list1.getNext();
                    list2 = list2.getNext();
                }
                mergeListCurrent = mergedListHead;
            } else {
                if (list1.getData() < list2.getData()) {
                    mergeListCurrent.setNext(list1);
                    list1 = list1.getNext();
                } else if (list1.getData() > list2.getData()) {
                    mergeListCurrent.setNext(list2);
                    list2 = list2.getNext();
                } else {
                    mergeListCurrent.setNext(list1);
                    list1 = list1.getNext();
                    list2 = list2.getNext();
                }
                mergeListCurrent = mergeListCurrent.getNext();
            }


        }

        if (list1 == null && list2 != null) {
            mergeListCurrent.setNext(list2);
        } else if (list1 != null && list2 == null) {
            mergeListCurrent.setNext(list1);
        }
        return mergedListHead;
    }
}
