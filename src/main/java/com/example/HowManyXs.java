package com.example;

import java.util.Scanner;

public class HowManyXs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfTestCase = Integer.parseInt(scanner.nextLine());

        for (int testCase = 0; testCase < numberOfTestCase; testCase++) {
            String x = scanner.nextLine().trim();
            String[] lowerAndUpperBound = scanner.nextLine().trim().split(" ");
            String lowerBound = lowerAndUpperBound[0];
            String upperBound = lowerAndUpperBound[1];
            String xAsString = String.valueOf(x);
            int occurrenceOfX = 0;
            for (int i = Integer.parseInt(lowerBound) + 1; i < Integer.parseInt(upperBound); i++) {

                String iAsString = String.valueOf(i);
                for (int j = 0; j < iAsString.length(); j++) {
                    if (Character.toString(iAsString.charAt(j)).equals(xAsString)) {
                        occurrenceOfX++;
                    }
                }
            }
            System.out.println(occurrenceOfX);


        }

    }
}
