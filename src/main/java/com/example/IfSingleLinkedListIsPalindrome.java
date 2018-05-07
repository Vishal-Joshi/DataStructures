package com.example;

public class IfSingleLinkedListIsPalindrome {

    public static void main(String[] args) {
        IfSingleLinkedListIsPalindrome ifSingleLinkedListIsPalindrome = new IfSingleLinkedListIsPalindrome();

        Node tail = new Node(1, null);
        Node twoSecondLast = new Node(2, tail);
        Node oneMid = new Node(1, twoSecondLast);
        Node two = new Node(2, oneMid);
        Node one = new Node(1, two);

        boolean isPalindrome = ifSingleLinkedListIsPalindrome.isPalindrome(one);

        Node currentNode = one;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
        System.out.println("isPalindrome: " + isPalindrome);
    }

    private boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        Node prevOfSlow = null;
        boolean result = false;

        while (fast != null && fast.getNext() != null) {
            prevOfSlow = slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if (prevOfSlow != null) {
            Node secondHalf;
            if (fast != null) {
                //odd case
                secondHalf = slow.getNext();

            } else {
                secondHalf = slow;
                //even case
                //detach first and second half
            }
            prevOfSlow.setNext(null);


            //reverse second half
            Node currentNode = secondHalf;
            Node reversedList = null;
            while (currentNode != null) {
                reversedList = new Node(currentNode.getData(), reversedList);
                currentNode = currentNode.getNext();
            }
            result = compareListsForEquality(head, reversedList);

            //reconstruct list
            if (fast != null) {
                //odd case
                prevOfSlow.setNext(slow);
            } else {
                prevOfSlow.setNext(secondHalf);
            }
        }

        return result;
    }

    private boolean compareListsForEquality(Node list1, Node list2) {
        Node currentForList1 = list1;
        Node currentForList2 = list2;
        while (currentForList1 != null && currentForList2 != null) {
            if (currentForList1.getData() != currentForList2.getData()) {
                return false;
            }
            currentForList1 = currentForList1.getNext();
            currentForList2 = currentForList2.getNext();
        }

        return currentForList1 == null && currentForList2 == null;

    }
}
