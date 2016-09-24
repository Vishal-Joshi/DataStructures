package com.example;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node tail = new Node(1, null);
        Node fourth = new Node(4, tail);
        Node third = new Node(3, fourth);
        Node second = new Node(2, third);
        Node head = new Node(5, second);

        Node currentNode = reverseLinkedList.reverseList(head);
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }

    }

    private Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return head;
        }
        Node currentNode = head;
        Node headOfReversedList = null;
        while (currentNode != null) {
            headOfReversedList = new Node(currentNode.getData(), headOfReversedList);
            currentNode = currentNode.getNext();
        }
        return headOfReversedList;
    }
}
