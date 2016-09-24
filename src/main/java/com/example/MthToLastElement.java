package com.example;

import java.util.Scanner;

public class MthToLastElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] arraysOfElementsAndIndex = new String[2][];
        int i = 0;
        while (scanner.hasNextLine()) {
            String stringRead = scanner.nextLine();
            if (stringRead.equals("")) {
                break;
            }
            arraysOfElementsAndIndex[i] = stringRead.split(" ");
            if (Integer.parseInt(arraysOfElementsAndIndex[0][0]) > 1024) {
                break;
            }
            i++;
        }
        String elementFound = "NIL";

        if (arraysOfElementsAndIndex[1] !=null && arraysOfElementsAndIndex[1].length != 0 && arraysOfElementsAndIndex[1].length < 1024 && arraysOfElementsAndIndex[1].length > Integer.parseInt(arraysOfElementsAndIndex[0][0])) {
            MthToLastElement mthToLastElement = new MthToLastElement();
            Node headNode = mthToLastElement.prepareSinglyLinkedList(arraysOfElementsAndIndex[1]);
            Node currentNode = headNode;
            int counter = 1;


            while (currentNode.getNext() != null) {
                if ((arraysOfElementsAndIndex[1].length - counter) == Integer.parseInt(arraysOfElementsAndIndex[0][0])) {
                    elementFound = String.valueOf(currentNode.getNext().getData());
                    break;
                }
                currentNode = currentNode.getNext();
                counter++;
            }
        }

        System.out.print(elementFound);
    }

    private Node prepareSinglyLinkedList(String[] array) {
        Node currentNode = null;
        Node head = null;
        for (int i = 0; i < array.length - 1; i++) {
            if (currentNode == null) {
                head = new Node(Integer.parseInt(array[i]), new Node(Integer.parseInt(array[i + 1]), null));
                currentNode = head;
            } else {
                Node newNode = new Node(Integer.parseInt(array[i + 1]), null);

                currentNode.getNext().setNext(newNode);
                currentNode = currentNode.getNext();
            }
        }

        return head;
    }


    static class Node {
        private int data;
        private Node next;

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }
}
