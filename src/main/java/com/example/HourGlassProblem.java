package com.example;

import java.util.ArrayList;
import java.util.List;

public class HourGlassProblem {

    public static void main(String[] args) {
        int[][] array = new int[6][6];
        //0th column
        array[0][0] = -1;
        array[1][0] = -2;
        array[2][0] = -1;
        array[3][0] = -1;
        array[4][0] = -7;
        array[5][0] = -1;

        //1st column
        array[0][1] = -1;
        array[1][1] = -1;
        array[2][1] = -1;
        array[3][1] = -9;
        array[4][1] = -3;
        array[5][1] = -3;

        //2nd column
        array[0][2] = 0;
        array[1][2] = -6;
        array[2][2] = -1;
        array[3][2] = -2;
        array[4][2] = -3;
        array[5][2] = -1;

        //3rd column
        array[0][3] = -9;
        array[1][3] = -8;
        array[2][3] = -2;
        array[3][3] = -4;
        array[4][3] = -2;
        array[5][3] = -2;

        //4th column
        array[0][4] = -2;
        array[1][4] = -2;
        array[2][4] = -3;
        array[3][4] = -4;
        array[4][4] = -9;
        array[5][4] = -4;

        //5th column
        array[0][5] = -2;
        array[1][5] = -5;
        array[2][5] = -4;
        array[3][5] = -5;
        array[4][5] = -9;
        array[5][5] = -5;
        HourGlassProblem hourGlassProblem = new HourGlassProblem();
        List<Integer[][]> hourGlasses = hourGlassProblem.findHourGlass(array);
        int maxSum = hourGlassProblem.findSumOfHourGlass(hourGlasses.get(0));
        for (Integer[][] hourGlass : hourGlasses) {
            int sumOfHourGlass = hourGlassProblem.findSumOfHourGlass(hourGlass);
            if (maxSum < sumOfHourGlass) {
                maxSum = sumOfHourGlass;
            }
        }

        System.out.println("Max sum is: " + maxSum);

    }

    private int findSumOfHourGlass(Integer[][] hourGlass) {
        int sum = 0;
        for (Integer[] hourGlassColumn : hourGlass) {
            for (Integer currentValue : hourGlassColumn) {
                sum += currentValue;
            }
        }
        return sum-hourGlass[1][0]-hourGlass[1][2];
    }

    private List<Integer[][]> findHourGlass(int[][] inputArray) {
        //row wise
        List<Integer[][]> hourGlasses = new ArrayList<>();
        for (int row = 0; row <= 3; row++) {
            for(int column=0; column<= 3; column++){
                hourGlasses.add(prepareHourGlassFromLeftToRight(inputArray, row, column));
            }
        }

        return hourGlasses;
    }

    private Integer[][] prepareHourGlassFromLeftToRight(int[][] inputArray, int rowStart, int columnStart) {
        Integer[][] hourGlass = new Integer[3][3];
        int hourGlassRow = 0;
        for (int row = rowStart; row < rowStart + 3; row++) {
            int hourGlassColumn = 0;
            for (int column = columnStart; column < columnStart + 3; column++) {
                hourGlass[hourGlassRow][hourGlassColumn] = inputArray[row][column];
                hourGlassColumn++;
            }
            hourGlassRow++;
        }
        return hourGlass;
    }

}
