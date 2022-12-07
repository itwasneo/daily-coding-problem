import com.itwasneo.solutions.*;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTests {

    private static final Logger logger = LoggerFactory.getLogger(SolutionTests.class);

    @Test
    public void day1_test() {
        assertEquals(true, Day1.solve(new int[] {10, 15, 3, 7}, 17));
    }

    @Test
    public void day2_test() {
        assertArrayEquals(new int[] {120, 60, 40, 30, 24}, Day2.solve(new int[] {1, 2, 3, 4, 5}));
        assertArrayEquals(new int[] {120, 60, 40, 30, 24}, Day2.solve_wo_division(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void day4_test() {
        assertEquals(2, Day4.solve(new int [] {3,4,-1,1}));
        assertEquals(3, Day4.solve(new int [] {1,2,0}));
        assertEquals(5, Day4.solve(new int[] {-2,-3,0,1,2,4,9,10,8,3,0,0,2,0,-1}));
        assertEquals(5, Day4.solve(new int[] {4,9,10,8}));
    }

    @Test
    public void day5_test() {
        assertEquals(3, Day5.car(Day5.cons.apply(3,4)));
        assertEquals(4, Day5.cdr(Day5.cons.apply(3,4)));
    }

    @Test
    public void aoc_day5_test() {
        assertEquals("VJSFHWGFT", AoCDay5.solve(1));
        assertEquals("LCTQFBVZV", AoCDay5.solve(2));
    }
}
