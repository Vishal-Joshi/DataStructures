package com.example;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> unreversedStack = new Stack<>();
        unreversedStack.push(1);
        unreversedStack.push(2);
        unreversedStack.push(3);
        ReverseStack reverseStack = new ReverseStack();
        System.out.println(unreversedStack);
        reverseStack.reverse(unreversedStack);
        System.out.println(unreversedStack);
    }

    private void insertAtBottom(Stack<Integer> unreversedStack, Integer itemTOInsert) {
        if (unreversedStack.empty()) {
            unreversedStack.push(itemTOInsert);
            return;
        }
        Integer currentTop = unreversedStack.pop();
        insertAtBottom(unreversedStack, itemTOInsert);
        unreversedStack.push(currentTop);
    }

    private void reverse(Stack<Integer> unreversedStack) {
        if (!unreversedStack.empty()) {
            Integer poppedElement = unreversedStack.pop();
            reverse(unreversedStack);
            insertAtBottom(unreversedStack, poppedElement);
        }
        return;
    }
}
