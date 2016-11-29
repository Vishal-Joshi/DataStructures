package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InfixToPostFixConverter {

    public static void main(String[] args) {
        String expressionAsString = "a+b*c*d-e";
        System.out.println(expressionAsString);
        String[] expression = new String[9];
        String[] highPrecedenceOperator = new String[2];
        String[] lowerPrecedenceOperator = new String[2];
        expression[0] = "a";
        expression[1] = "+";
        expression[2] = "b";
        expression[3] = "*";
        expression[4] = "c";
        expression[5] = "*";
        //expression[6] = "(";
        expression[6] = "d";
        expression[7] = "-";
        expression[8] = "e";
        //expression[10] = ")";

        lowerPrecedenceOperator[0] = "+";
        lowerPrecedenceOperator[1] = "-";

        highPrecedenceOperator[0] = "*";
        highPrecedenceOperator[1] = "/";
        InfixToPostFixConverter infixToPostFixConverter = new InfixToPostFixConverter();
        System.out.println(infixToPostFixConverter.infixToPostfixExpression(expression, highPrecedenceOperator, lowerPrecedenceOperator));
    }

    private String infixToPostfixExpression(String[] expression, String[] highPrecedenceOperator, String[] lowerPrecedenceOperator) {
        List<String> highPrecedenceOperatorAsList = Arrays.asList(highPrecedenceOperator);
        List<String> lowPrecedenceOperatorAsList = Arrays.asList(lowerPrecedenceOperator);
        Stack<String> holdingStack = new Stack<>();
        List<String> finalExpression = new ArrayList<>();
        Arrays.asList(expression).forEach(element -> {

            if (highPrecedenceOperatorAsList.contains(element)) { // scanned operator is high precedence
                holdingStack.push(element);
            } else if(lowPrecedenceOperatorAsList.contains(element)){
                if (holdingStack.empty()) {
                    holdingStack.push(element);
                } else {
                    if (lowPrecedenceOperatorAsList.contains(holdingStack.peek())) {
                        holdingStack.push(element);
                    } else if (highPrecedenceOperatorAsList.contains(holdingStack.peek())) {
                        while(highPrecedenceOperatorAsList.contains(holdingStack.peek())){
                            finalExpression.add(holdingStack.pop());
                        }
                        holdingStack.push(element);
                    }
                }
            } else {
                finalExpression.add(element);
            }
            System.out.print(holdingStack+"-->");
        });
        while (!holdingStack.empty()){
            finalExpression.add(holdingStack.pop());
        }
        System.out.println();
        return finalExpression.stream().reduce("", (a,b)-> a+=b);
    }
}
