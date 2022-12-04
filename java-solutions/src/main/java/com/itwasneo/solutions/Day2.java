package com.itwasneo.solutions;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was asked by Uber.
 * Given an array of integers, return a new array such that each element at
 * index i of the new array is the product of all the numbers in the original
 * array except the one at ith index.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would
 * be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output
 * would be [2, 3, 6].
 * Follow-up: what if you can't use division?
 */
public class Day2 {

    /**
     * <p>
     *     Basic solution using division. First calculate
     *     the result of the total product. Divide total
     *     product with each ith element to find the result.
     * </p>
     * <p>
     *     Complexity: O(n)
     * </p>
     * @param inputArray int[ ]
     * @return int[ ]
     */
    public static int[] solve(int[] inputArray) {
        OptionalInt t = Arrays.stream(inputArray).reduce((x, y) -> x * y);
        int total = t.getAsInt();
        int[] result = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            result[i] = total / inputArray[i];
        }
        return result;
    }

    /**
     * <p>
     *     Solution without using division operation.
     * </p>
     * <p>
     *     Calculating the products of all the elements coming
     *     before and after the ith element, and then multiplying
     *     those two result.
     * </p>
     * <p>
     *     Complexity: O(n)
     * </p>
     * @param inputArray int [ ]
     * @return int [ ]
     */
    public static int[] solve_wo_division(int[] inputArray) {
        int[] result = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            OptionalInt f = Arrays.stream(inputArray, i + 1, inputArray.length).reduce((x, y) -> x * y);
            OptionalInt b = Arrays.stream(inputArray, 0, i).reduce((x, y) -> x * y);

            result[i] = f.orElse(1) * b.orElse(1);
        }
        return result;
    }
}
