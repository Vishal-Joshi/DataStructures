package com.example;

public class MergeSortedLinkedList {

    public static void main(String[] args) {
        MergeSortedLinkedList mergeSortedLinkedList = new MergeSortedLinkedList();
        Node five = new Node(5, null);
        Node three = new Node(3, five);
        Node list1 = new Node(2, three);

        Node seven = new Node(7, null);
        Node six = new Node(6, seven);
        Node list2 = new Node(1, six);

        Node mergedList = mergeSortedLinkedList.merge(list1, list2);
        Node currentNode = mergedList;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
    }

    private Node merge(Node list1, Node list2) {
        Node mergedList;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.getData() < list2.getData()) {
            mergedList = new Node(list1.getData(), merge(list1.getNext(), list2));
        } else if (list1.getData() > list2.getData()) {
            mergedList = new Node(list2.getData(), merge(list1, list2.getNext()));
        } else {
            mergedList = new Node(list2.getData(), merge(list1.getNext(), list2.getNext()));
        }
        return mergedList;
    }
}
