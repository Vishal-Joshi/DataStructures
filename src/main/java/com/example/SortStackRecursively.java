package com.example;

import java.util.Stack;

public class SortStackRecursively {

    public static void main(String[] args) {
        Stack<Integer> unsortedStack = new Stack<>();
        unsortedStack.push(-3);
        unsortedStack.push(14);
        unsortedStack.push(8);
        unsortedStack.push(-5);
        unsortedStack.push(30);
        System.out.println(unsortedStack);
        new SortStackRecursively().sortStack(unsortedStack);
        System.out.println(unsortedStack);
    }

    private void sortStack(Stack<Integer> stackToSorted) {
        if (!stackToSorted.isEmpty()) {
            Integer temp = stackToSorted.pop();
            sortStack(stackToSorted);
            sortInserted(stackToSorted, temp);
        }
    }

    private void sortInserted(Stack<Integer> stackToBeInsertedTo, Integer element) {
        if (stackToBeInsertedTo.isEmpty() || stackToBeInsertedTo.peek() > element) {
            stackToBeInsertedTo.push(element);
        } else {
            int temp = stackToBeInsertedTo.pop();
            sortInserted(stackToBeInsertedTo, element);
            stackToBeInsertedTo.push(temp);
        }

    }
}
