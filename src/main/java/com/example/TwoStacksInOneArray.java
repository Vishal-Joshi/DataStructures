package com.example;

/**
 * Implement two stacks in an array
 * array  stack      Snapdeal    [24]7 Innovation Lab
 * Your task is to implement  2 stacks in  one array efficiently .
 * <p>
 * Input (To be used for Expected Output):
 * <p>
 * The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
 * First line of each test case contains an integer Q denoting the number of queries .
 * A Query Q is of 4 Types
 * (i)    1 1 x    (a query of this type means  pushing 'x' into the stack 1)
 * (ii)   1 2      (a query of this type means to pop element from stack1  and print the poped element)
 * (iii)  2 1 x  (a query of this type means pushing 'x' into the stack 2)
 * (iv)  2 2     (a query of this type means to pop element from stack2 and print the poped element)
 * <p>
 * The second line of each test case contains Q queries seperated by space.
 * <p>
 * Output:
 * The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out from the stack.
 * You are required to complete the 4  methods push1, push2 which takes one argument an integer 'x' to be pushed into the stack one and two  and pop1, pop2 which returns a integer poped out from stack one and two .
 * <p>
 * Constraints:
 * 1<=T<=100
 * 1<=Q<=100
 * 1<=x<=100
 * <p>
 * Example:
 * Input
 * 1
 * 6
 * 1 1 2 1 1 3 2 1 4 1 2 2 2 2 2
 * <p>
 * Output
 * 3 4 -1
 * <p>
 * Explanation:
 * <p>
 * In the first test case for query
 * 1 1 2    the stack1 will be {2}
 * 1 1 3    the stack1 will be {2,3}
 * 2 1 4   the stack2 will be {4}
 * 1 2      the poped element will be 3 from stack1 and stack1 will be {2}
 * 2 2      the poped element will be 4 from stack2 and now stack2 is empty
 * 2 2      the stack2 is now empty hence -1 .
 */
public class TwoStacksInOneArray {
    public static void main(String[] args) {

    }

    private class GfG {
        private int[] arrayOfIntegers;
        private int top1;
        private int top2;
        private int currentIndex;

        GfG(int numberOfQueries) {
            this.arrayOfIntegers = new int[numberOfQueries];
            this.currentIndex = 0;
            this.top1 = -1;
            this.top2 = numberOfQueries;
        }

        public int[] getArrayOfIntegers() {
            return arrayOfIntegers;
        }

        public int getTop1() {
            return top1;
        }

        public int getTop2() {
            return top2;
        }

        public void pushStack1(int elementToPush) {
            pushToArrayOfIntegers(elementToPush);
            ++top1;
        }

        private void pushToArrayOfIntegers(int elementToPush) {
            arrayOfIntegers[currentIndex] = elementToPush;
            ++currentIndex;
        }

        public void pushStack2(int elementToPush) {
            pushToArrayOfIntegers(elementToPush);
            ++top2;
        }

        public int popStack1() {
            return arrayOfIntegers[top1];
        }

        public int popStack2() {
            return arrayOfIntegers[top2];
        }
    }
}
