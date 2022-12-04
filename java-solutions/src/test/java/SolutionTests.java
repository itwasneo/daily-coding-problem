import com.itwasneo.day1.Day1;
import org.junit.jupiter.api.Test;

import com.itwasneo.day1.Day2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTests {

    @Test
    public void day1_test() {
        assertEquals(true, Day1.solve(new int[] {10, 15, 3, 7}, 17));
    }

    @Test
    public void day2_test() {
        assertArrayEquals(new int[] {120, 60, 40, 30, 24}, Day2.solve(new int[] {1, 2, 3, 4, 5}));
        assertArrayEquals(new int[] {120, 60, 40, 30, 24}, Day2.solve_wo_division(new int[] {1, 2, 3, 4, 5}));
    }
}
