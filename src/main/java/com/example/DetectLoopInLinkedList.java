package com.example;

public class DetectLoopInLinkedList {

    public static void main(String[] args) {
        DetectLoopInLinkedList detectLoopInLinkedList = new DetectLoopInLinkedList();
        Node tail = new Node(6, null);
        Node five = new Node(5, tail);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        Node one = new Node(1, two);
        tail.setNext(three);
        System.out.println(detectLoopInLinkedList.detectLoop(one) ? "loop found!" : "no loop detected");
    }

    /**
     * Floyd’s Cycle-Finding Algorithm
     *
     * @return true if there is loop, else false
     */
    private boolean detectLoop(Node head) {
        Node loop1 = head.getNext();
        Node loop2 = head.getNext().getNext();
        while (loop1 != null && loop2 != null) {
            if (loop1 == loop2) {
                return true;
            }
            loop1 = loop1.getNext();
            Node loop2OneStep = loop2.getNext();
            if (loop2OneStep != null) {
                loop2 = loop2OneStep.getNext();
            } else {
                loop2 = null;
            }
        }
        return false;
    }
}
