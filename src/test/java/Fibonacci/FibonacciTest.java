package Fibonacci;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {

    Fibonacci fibonacci = new Fibonacci();

    @Test
    public void fibinacciMemoizationTest(){

        long start = System.currentTimeMillis();
        Integer fib = fibonacci.bruteForce(42);
        long finish = System.currentTimeMillis();

        long startMemoized = System.currentTimeMillis();
        Integer fibMemoized = fibonacci.memoized(42, new HashMap<>());
        long finishMemoized = System.currentTimeMillis();

        assertThat(fib).isEqualTo(267914296);
        assertThat(fibMemoized).isEqualTo(267914296);

        assertThat(finishMemoized - startMemoized).isLessThan(finish - start);
        assertThat((finishMemoized - startMemoized) * 1000).isLessThan(finish - start); // at least 1000 times faster
    }
}