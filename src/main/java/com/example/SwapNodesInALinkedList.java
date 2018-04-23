package com.example;

public class SwapNodesInALinkedList {

    public static void main(String[] args) {
        //10->15->12->13->20->14
        Node tail = new Node(14, null);
        Node twenty = new Node(20, tail);
        Node thirteen = new Node(13, twenty);
        Node twelve = new Node(12, thirteen);
        Node fifteen = new Node(15, twelve);
        Node head = new Node(10, fifteen);
        System.out.print("Before swapping: ");
        printLinkedList(head);
        //swap x=12, y=20 swap
        int xContent = 12;
        int yContent = 20;
        Node swapped = swap(xContent, yContent, head);
        System.out.print("After swapping: ");
        if (swapped != null) {
            printLinkedList(swapped);
        } else {
            System.out.print("either x: " + xContent + " or y: " + yContent + " could not be found!");
        }
    }

    private static Node swap(int xContent, int yContent, Node head) {
        Node xBefore = null;
        Node yBefore = null;
        Node x = null;
        Node y = null;

        if (xContent == head.getContent()) {
            xBefore = null;
            x = head;
        }

        if (yContent == head.getContent()) {
            yBefore = null;
            y = head;
        }
        Node temp = head;
        while ((!(xBefore != null && x != null && yBefore != null && y != null)) && temp != null) {
            if (xBefore == null && x == null && temp.getNext() != null && temp.getNext().getContent() == xContent) {
                xBefore = temp;
                x = temp.getNext();
                temp = temp.getNext();
            } else if (yBefore == null && y == null && temp.getNext() != null && temp.getNext().getContent() == yContent) {
                yBefore = temp;
                y = temp.getNext();
                temp = temp.getNext();
            } else {
                temp = temp.getNext();
            }

        }

        if (x != null && y != null) {
            Node xNextTemp = x.getNext();
            if (xBefore != null) {
                xBefore.setNext(y);
            } else {
                //if x is head node
                yBefore.setNext(x);
                head = y;
            }
            x.setNext(y.getNext());
            if (yBefore.getContent() != xContent) {
                y.setNext(xNextTemp);
                if (yBefore != null) {
                    yBefore.setNext(x);
                } else {
                    //if y is head node
                    xBefore.setNext(y);
                    head = x;
                }
            } else {
                //adjacent nodes
                y.setNext(x);
            }
            return head;
        } else {
            return null;
        }

    }

    private static void printLinkedList(Node iteration) {
        while (iteration != null) {
            System.out.print(iteration.getContent());
            iteration = iteration.getNext();
            if (iteration != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    private static class Node {
        private int content;
        private Node next;

        Node(int content, Node next) {
            this.content = content;
            this.next = next;
        }

        public int getContent() {
            return content;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node node) {
            next = node;
        }

    }

}
