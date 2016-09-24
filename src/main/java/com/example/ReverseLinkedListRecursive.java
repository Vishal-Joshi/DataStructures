package com.example;

public class ReverseLinkedListRecursive {

    public static void main(String[] args) {
        ReverseLinkedListRecursive reverseLinkedListRecursive = new ReverseLinkedListRecursive();
        Node tail = new Node(5, null);
        Node fourth = new Node(4, tail);
        Node third = new Node(3, fourth);
        Node second = new Node(2, third);
        Node head = new Node(1, second);

        Node reversedHeadNode = reverseLinkedListRecursive.reverseList(head, null);
        Node currentNode = reversedHeadNode;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }

    }


    private Node reverseList(Node head, Node previousNode) {
        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return new Node(head.getData(), previousNode);
        }

        Node headOfLinkedList = new Node(head.getData(), previousNode);

        return reverseList(head.getNext(), headOfLinkedList);
    }
}
