package com.itwasneo.day1;

/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from
 * the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 */
public class Day1 {

    /**
     * <p>
     *      Keeping remainders in memory in array form.
     *      This approach assumes that the given input
     *      array consists positive numbers.
     * </p>
     * <p>
     *      This approach can be changed to hashset
     *      Complexity: O(n)
     * </p>
     * @param inputArray
     * @param target
     * @return
     */
    public static boolean solve(int[] inputArray, int target) {
        int[] remainders = new int[target];
        for (int i = 0; i < inputArray.length; i++) {
            int remainder = target - inputArray[i];
            if (remainders[remainder] == 1) {
                return true;
            }
            remainders[inputArray[i]] = 1;
        }
        return false;
    }
}
