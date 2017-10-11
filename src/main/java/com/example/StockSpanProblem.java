package com.example;

import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        StockSpanProblem stockSpanProblem = new StockSpanProblem();
        for (int currentTestCase = 1; currentTestCase <= numberOfTestCases; currentTestCase++) {
            scanner.nextInt();
            Stack<Integer> stackOfIntegers = new Stack<>();
            scanner.nextLine();
            String integerString = scanner.nextLine();
            for (String integerAsString : integerString.split(" ")) {
                stackOfIntegers.push(Integer.valueOf(integerAsString));
            }

            stockSpanProblem.traverseStack(stackOfIntegers);
            System.out.println();
        }
    }

    private void traverseStack(Stack<Integer> stackOfStocks) {
        if (!stackOfStocks.empty()) {
            int temp = stackOfStocks.pop();
            traverseStack(stackOfStocks);
            stackOfStocks.push(temp);
            System.out.print(calculateSpan(stackOfStocks, temp, 0) + " ");
        }

    }

    private int calculateSpan(Stack<Integer> stackOfStocks, Integer stock, int count) {
        if (stackOfStocks.empty() || stackOfStocks.peek() > stock) {
            return count;
        } else {
            int top = stackOfStocks.pop();
            ++count;
            int span = calculateSpan(stackOfStocks, stock, count);
            stackOfStocks.push(top);
            return span;
        }
    }

}
