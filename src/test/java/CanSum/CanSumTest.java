package CanSum;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class CanSumTest {

    @Test
    public void testCanSum(){
        CanSum canSum = new CanSum();

        long start = System.currentTimeMillis();
        boolean canSumBf1 = canSum.bruteForce(7, new int[]{2, 3});
        boolean canSumBf2 = canSum.bruteForce(7, new int[]{5, 3, 4, 7});
        boolean canSumBf3 = canSum.bruteForce(7, new int[]{2, 3, 5});
        boolean canSumBf4 = canSum.bruteForce(7, new int[]{2, 4});
        boolean canSumBf5 = canSum.bruteForce(7, new int[]{7, 14});
        boolean canSumBf6 = canSum.bruteForce(300, new int[]{7, 14});
        long finish = System.currentTimeMillis();

        long startMemoized = System.currentTimeMillis();
        boolean canSumMemoized1 = canSum.memoized(7, new int[]{2, 3}, new HashMap<>());
        boolean canSumMemoized2 = canSum.memoized(7, new int[]{5, 3, 4, 7},new HashMap<>());
        boolean canSumMemoized3 = canSum.memoized(7, new int[]{2, 3, 5},new HashMap<>());
        boolean canSumMemoized4 = canSum.memoized(7, new int[]{2, 4},new HashMap<>());
        boolean canSumMemoized5 = canSum.memoized(7, new int[]{7, 14},new HashMap<>());
        boolean canSumMemoized6 = canSum.memoized(300, new int[]{7, 14},new HashMap<>());
        long finishMemoized = System.currentTimeMillis();

        assertThat(finishMemoized - startMemoized).isLessThan(finish - start);
        assertThat((finishMemoized - startMemoized) * 1000).isLessThan(finish - start); // at least 1000 times faster

        assertThat(canSumBf1).isTrue();
        assertThat(canSumBf2).isTrue();
        assertThat(canSumBf3).isTrue();
        assertThat(canSumBf4).isFalse();
        assertThat(canSumBf5).isTrue();
        assertThat(canSumBf6).isFalse();

        assertThat(canSumMemoized1).isTrue();
        assertThat(canSumMemoized2).isTrue();
        assertThat(canSumMemoized3).isTrue();
        assertThat(canSumMemoized4).isFalse();
        assertThat(canSumMemoized5).isTrue();
        assertThat(canSumMemoized6).isFalse();
    }
}