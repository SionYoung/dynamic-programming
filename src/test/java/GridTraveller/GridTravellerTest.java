package GridTraveller;

import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GridTravellerTest {

    @Test
    public void GridTravellerTest(){

        Map<String, Long> memo = new HashMap<>();
        GridTraveller gridTraveller = new GridTraveller();

        long before = System.currentTimeMillis();
        int case1 = gridTraveller.countPathsBruteForce(1, 1);
        int case2 = gridTraveller.countPathsBruteForce(2, 3);
        int case3 = gridTraveller.countPathsBruteForce(3, 2);
        int case4 = gridTraveller.countPathsBruteForce(17, 17);
        long finish = System.currentTimeMillis();
        long timeElapsedBruteForce = finish - before;

        before = System.currentTimeMillis();
        long case5 = gridTraveller.countPathsMemoized(17, 17, memo);
        finish = System.currentTimeMillis();
        long timeElapsedMemoized = finish - before;

        before = System.currentTimeMillis();
        long case6 = gridTraveller.countPathsMemoized(18, 18, memo);
        finish = System.currentTimeMillis();
        long timeElapsed18by18 = finish - before;

        assertThat(case1).isEqualTo(1);
        assertThat(case2).isEqualTo(3);
        assertThat(case3).isEqualTo(3);
        assertThat(case4).isEqualTo(601080390);
        assertThat(case5).isEqualTo(601080390);
        assertThat(case6).isEqualTo(2333606220L);

        // dynamic programming is a lot faster than burte force
        assertThat(timeElapsedMemoized * 1000).isLessThan(timeElapsedBruteForce);
        assertThat(timeElapsed18by18 * 100000).isLessThan(timeElapsedBruteForce);

        System.out.println(timeElapsedBruteForce);
        System.out.println(timeElapsedMemoized);
        System.out.println(timeElapsed18by18);
    }
}