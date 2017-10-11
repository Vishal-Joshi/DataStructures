package com.example;

import java.util.Scanner;

public class FloodFillAlgorithm {

    public static void main(String[] args) {
        FloodFillAlgorithm floodFillAlgorithm = new FloodFillAlgorithm();
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCase = Integer.parseInt(scanner.nextLine());
        int[][][] arrayOfFilledArrays = new int[numberOfTestCase][][];
        int count = 0;
        for (int testCase = 0; testCase < numberOfTestCase; testCase++) {
            String rowAndMaxString = scanner.nextLine();
            String[] split = rowAndMaxString.split(" ");
            int rowMax = Integer.parseInt(split[0]);
            int columnMax = Integer.parseInt(split[1]);
            int[][] arrayToFill = new int[rowMax][columnMax];
            String arrayString = scanner.nextLine();
            String[] arrayStringSplit = arrayString.split(" ");
            int arrayStringCount = 0;
            for (int row = 0; row < rowMax; row++) {
                for (int column = 0; column < columnMax; column++) {
                    arrayToFill[row][column] = Integer.parseInt(arrayStringSplit[arrayStringCount++]);
                }
            }
            String[] startPointAndColor = scanner.nextLine().split(" ");
            int[][] filledArray = floodFillAlgorithm.fillArray(arrayToFill, Integer.parseInt(startPointAndColor[2]), Integer.parseInt(startPointAndColor[0]), Integer.parseInt(startPointAndColor[1]), rowMax, columnMax);
            arrayOfFilledArrays[count++] = filledArray;
        }

        for (int[][] arrayOfFilledArray : arrayOfFilledArrays) {
            for (int[] columns : arrayOfFilledArray) {
                for (int value : columns) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }


    }


    private int[][] fillArray(int[][] arrayToFill, int colorToFill, int x, int y, int rowMax, int columnMax) {
        int previousColor = arrayToFill[x][y];
        fillSurrounding(arrayToFill, colorToFill, x, y, previousColor, rowMax, columnMax);
        return arrayToFill;
    }

    private void fillSurrounding(int[][] arrayToFill, int colorToFill, int x, int y, int previousColor, int rowMax, int columnMax) {
        if (x < 0 || x >= rowMax) {
            return;
        }
        if (y < 0 || y >= columnMax) {
            return;
        }

        if (arrayToFill[x][y] == previousColor) {
            arrayToFill[x][y] = colorToFill;
            fillSurrounding(arrayToFill, colorToFill, x - 1, y, previousColor, rowMax, columnMax);
            fillSurrounding(arrayToFill, colorToFill, x + 1, y, previousColor, rowMax, columnMax);
            fillSurrounding(arrayToFill, colorToFill, x, y - 1, previousColor, rowMax, columnMax);
            fillSurrounding(arrayToFill, colorToFill, x, y + 1, previousColor, rowMax, columnMax);
        }
    }
}
