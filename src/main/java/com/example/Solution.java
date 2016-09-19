package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Query> listOfQueries = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String stringRead = scanner.nextLine();
            if (stringRead.equals("")) {
                break;
            }
            String[] queryPerLine = stringRead.split(" ");
            if(queryPerLine.length == 3){
                listOfQueries.add(new Query(Integer.valueOf(queryPerLine[0]), Integer.valueOf(queryPerLine[1]), Integer.valueOf(queryPerLine[2])));
            } else {
                listOfQueries.add(new Query(Integer.valueOf(queryPerLine[0]), Integer.valueOf(queryPerLine[1]), 0));
            }
        }
        Solution solution = new Solution();
        solution.processQueries(listOfQueries);

    }

    private void processQueries(List<Query> listOfQueries) {
        int numberOfQueries = listOfQueries.get(0).getX();
        int numberOfSequences = listOfQueries.get(0).getQueryNumber();
        List<List<Integer>> listOfSequnces = new ArrayList<>();
        for (int sequunces = 0; sequunces < numberOfSequences; sequunces++) {
            listOfSequnces.add(new ArrayList<>());
        }
        int lastAnswer = 0;

        for (int queryIndex = 1; queryIndex <= numberOfQueries; queryIndex++) {
            Query currentQuery = listOfQueries.get(queryIndex);
            if(currentQuery.getQueryNumber()==1){
                perform1QueryOperation(listOfSequnces, currentQuery.getX(), currentQuery.getY(), lastAnswer, numberOfSequences);
            } else {
                lastAnswer = perform2QueryOperation(listOfSequnces, currentQuery.getX(), currentQuery.getY(),lastAnswer, numberOfSequences);
            }
        }
    }

    private void perform1QueryOperation(List<List<Integer>> listOfSequences, int x, int y, int lastAnswer, int n) {
        List<Integer> chosenSequence = listOfSequences.get((x ^ lastAnswer)%n);
        chosenSequence.add(y);
    }

    private int perform2QueryOperation(List<List<Integer>> listOfSequences, int x, int y, int lastAnswer, int n) {
        List<Integer> chosenSequence = listOfSequences.get((x ^ lastAnswer)%n);
        int index = y % chosenSequence.size();
        int newLastAnswer = chosenSequence.get(index);
        if (newLastAnswer != lastAnswer) {
            System.out.println(newLastAnswer);
        }
        return newLastAnswer;
    }

    static class Query {
        private Integer queryNumber;
        private Integer x;
        private Integer y;

        public Query(Integer queryNumber, Integer x, Integer y) {
            this.queryNumber = queryNumber;
            this.x = x;
            this.y = y;
        }


        public Integer getQueryNumber() {
            return queryNumber;
        }

        public Integer getX() {
            return x;
        }

        public Integer getY() {
            return y;
        }

    }


}
