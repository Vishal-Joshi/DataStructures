package com.example;

public class DeletingFromAPositionInLinkedList {

    public static void main(String[] args) {
        DeletingFromAPositionInLinkedList deletingFromAPositionInLinkedList = new DeletingFromAPositionInLinkedList();
        //8->2->3->1->7
        Node tail = new Node(7, null);
        Node one = new Node(1, tail);
        Node three = new Node(3, one);
        Node two = new Node(2, three);
        Node head = new Node(8, two);
        System.out.print("Before deletion: ");
        printLinkedList(head);
        int positionToDelete = 3;
        Node iteration = deletingFromAPositionInLinkedList.deleteFromPosition(head, positionToDelete);
        System.out.print("After deletion: ");
        printLinkedList(iteration);
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

    private Node deleteFromPosition(Node head, int position) {
        if (position == 0) {
            return head.getNext();
        }

        int currentIndex = 0;
        Node theNextToYouWillBeDeleted = head;
        while ((currentIndex + 1) < position) {
            theNextToYouWillBeDeleted = theNextToYouWillBeDeleted.getNext();
            currentIndex++;
        }
        theNextToYouWillBeDeleted.setNext(theNextToYouWillBeDeleted.getNext().getNext());
        return head;
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
