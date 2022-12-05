package com.itwasneo.solutions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day4 {

    private static final Logger logger = LoggerFactory.getLogger(Day4.class);

    public static int solve(int[] arr) {
        // Find MIN and MAX
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min && arr[i] > 0) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create a fixed sized array to track which
        // positive numbers are already exists
        boolean[] exists = new boolean[max-min + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                exists[arr[i] - min] = true;
            }
        }

        // If there is a false in the array min + i
        // would give the missing number.
        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) {
                return i + min;
            }
        }

        // If there is no false in the "exists" array and
        // min is 1, then the lowest missing positive
        // would be the max + 1
        if (min == 1) {
            return max + 1;
        }

        // If there is no false in the "exists" array and
        // min is not 1, missing number has to be 1
        return 1;
    }
}