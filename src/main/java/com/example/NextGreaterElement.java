package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for (int currentTestCase = 1; currentTestCase <= numberOfTestCases; currentTestCase++) {
            int numberOfIntegers = scanner.nextInt();
            List<Integer> listOfIntegers = new ArrayList<>(numberOfIntegers);
            scanner.nextLine();
            String integerString = scanner.nextLine();
            for (String integerAsString : integerString.split(" ")) {
                listOfIntegers.add(Integer.valueOf(integerAsString));
            }

            Stack<Integer> stack = new Stack<>();
            NextGreaterElement nextGreaterElement = new NextGreaterElement();
            stack.push(listOfIntegers.get(0));
            int currentIndex = 1;//not 0 as starting is 1. get(0) is already in stack
            int[] resultantIntegers = new int[listOfIntegers.size()];
            int[] nextGreaterElementResult = nextGreaterElement.findNextGreaterElement(listOfIntegers, currentIndex, stack, resultantIntegers);
            for (int index = 0; index < nextGreaterElementResult.length; index++) {
                System.out.print(nextGreaterElementResult[index]);
            }
            System.out.println();
        }
    }

    public int[] findNextGreaterElement(List<Integer> listOfIntegers, int currentIndex, Stack<Integer> stackOfElements, int[] resultantIntegers) {

        //put key value based
        // integer with index vise in stack
        //so that while retrieving you can take out with index
        if (listOfIntegers.size() <= currentIndex) {
            while (!stackOfElements.empty()) {
                resultantIntegers[listOfIntegers.indexOf(stackOfElements.pop())] = -1;
            }
            return resultantIntegers;
        } else {
            Integer next = listOfIntegers.get(currentIndex);
            if (!stackOfElements.empty()) {
                Integer poppedElement = stackOfElements.pop();
                if (poppedElement < next) {
                    resultantIntegers[listOfIntegers.indexOf(poppedElement)] = next;
                    boolean shouldContinue = true;
                    while (!stackOfElements.empty() && shouldContinue) {
                        poppedElement = stackOfElements.pop();
                        if (poppedElement < next) {
                            resultantIntegers[listOfIntegers.indexOf(poppedElement)] = next;
                            shouldContinue = true;
                        } else {
                            stackOfElements.push(poppedElement);
                            shouldContinue = false;
                        }
                    }

                } else {
                    stackOfElements.push(poppedElement);
                }
            }
            stackOfElements.push(next);
            return findNextGreaterElement(listOfIntegers, ++currentIndex, stackOfElements, resultantIntegers);
        }

    }
}
