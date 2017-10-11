package com.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StackUsingTwoQueues {

    public static void main(String[] args) {
        StackUsingTwoQueues stackUsingTwoQueues = new StackUsingTwoQueues();
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for (int currentTestCase = 1; currentTestCase <= numberOfTestCases; currentTestCase++) {
            scanner.nextInt();
            List<Integer> q1 = new LinkedList<>();
            scanner.nextLine();
            String integerString = scanner.nextLine();
            for (String integerAsString : integerString.split(" ")) {
                q1.add(Integer.valueOf(integerAsString));
            }
            
        }
    }


}
