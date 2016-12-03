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
            stack.push(listOfIntegers.get(0));
            NextGreaterElement nextGreaterElement = new NextGreaterElement();
            for (int index = 1; index < listOfIntegers.size(); index++) {
                for (Integer lesserThanNextIntegers : nextGreaterElement.findNextGreaterElement(listOfIntegers.get(index), stack)) {
                    System.out.print(listOfIntegers.get(index));
                    System.out.print(" ");
                }
                stack.push(listOfIntegers.get(index));
            }
            if (!stack.empty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }

    public List<Integer> findNextGreaterElement(int next, Stack<Integer> stackOfElements) {
        List<Integer> resultantIntegers = new ArrayList<>();
        Integer poppedElement = stackOfElements.pop();
        if (poppedElement < next) {
            resultantIntegers.add(poppedElement);
            boolean shouldContinue = true;
            while (!stackOfElements.empty() && shouldContinue) {
                poppedElement = stackOfElements.pop();
                if (poppedElement < next) {
                    resultantIntegers.add(poppedElement);
                    shouldContinue = true;
                } else {
                    shouldContinue = false;
                }
            }
        } else {
            stackOfElements.push(poppedElement);
        }
        return resultantIntegers;
    }
}
