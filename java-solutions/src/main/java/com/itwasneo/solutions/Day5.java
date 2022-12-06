package com.itwasneo.solutions;
import org.javatuples.Pair;

import java.util.function.BiFunction;

/**
 * This is the most functional way that I could  do
 * at this moment.
 */
public class Day5 {

    public static BiFunction<Integer, Integer, Pair<Integer, Integer>> cons = Pair::new;

    public static int car(Pair<Integer, Integer> pair) {
        return pair.getValue0();
    }

    public static int cdr(Pair<Integer, Integer> pair) {
        return pair.getValue1();
    }

}
