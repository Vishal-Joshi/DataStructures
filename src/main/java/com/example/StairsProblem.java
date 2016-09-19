package com.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StairsProblem {
    public static void main(String[] args) {
        StairsProblem stairsProblem = new StairsProblem();
        stairsProblem.printStairs(6);
    }

    private void printStairs(int n) {
        Map<Integer, List<String>> stepsAndSpacesPlusHashMap = new LinkedHashMap<>();
        for (int steps = 1; steps < n; steps++) {
            List<String> spacesAndHash = new ArrayList<>();
            stepsAndSpacesPlusHashMap.put(steps, spacesAndHash);
            for (int spaces = n - steps; spaces > 0; spaces--) {
                //System.out.print("spaces: " + spaces);
                spacesAndHash.add(" ");
                System.out.print(" ");
            }
            for (int hash = 0; hash < steps; hash++) {
                //System.out.print("hashes: " + hash);
                spacesAndHash.add("#");
                System.out.print("#");
            }
            System.out.println();
        }

    }
}
