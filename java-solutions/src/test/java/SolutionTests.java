import com.itwasneo.solutions.Day1;
import com.itwasneo.solutions.Day2;
import com.itwasneo.solutions.Day3;
import com.itwasneo.solutions.Day4;
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
    public void day3_test() {
//        logger.info("{}", new Day3<String>()
//                .serialize(
//                        new Day3.Node<String>("0",
//                                new Day3.Node<>("1",
//                                        new Day3.Node<>("2", new Day3.Node<>("8", null, null), new Day3.Node<>("3", null, null)),
//                                        new Day3.Node<>("7", null, null)),
//                                new Day3.Node<>("4", null, null))));
        new Day3<String>().deserialize("0/1/2/8#\3#\7#\4#");
//        assertEquals(new Day3.Node<String>(null, null, null), new Day3<String>().deserialize("69"));
    }

    @Test
    public void day4_test() {
        assertEquals(2, Day4.solve(new int [] {3,4,-1,1}));
        assertEquals(3, Day4.solve(new int [] {1,2,0}));
        assertEquals(5, Day4.solve(new int[] {-2,-3,0,1,2,4,9,10,8,3,0,0,2,0,-1}));
        assertEquals(5, Day4.solve(new int[] {4,9,10,8}));
    }
}
