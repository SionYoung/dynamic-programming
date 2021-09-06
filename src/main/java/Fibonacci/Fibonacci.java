package Fibonacci;

import java.util.Map;

public class Fibonacci {

    // time complexity O(2 to n)
    // space complexity O(n)
    public Integer bruteForce(Integer n) {
        if(n <= 2 ) return 1;
        return bruteForce(n-1) + bruteForce(n-2);
    }

    // time complexity O(n)
    // space complexity O(n)
    public Integer memoized(Integer n, Map<String, Integer> memo) {

        if(memo.containsKey(String.valueOf(n)))
            return memo.get(String.valueOf(n));

        if(n <= 2 )
            return 1;

        Integer partialSum = memoized(n - 1, memo) + memoized(n - 2, memo);
        memo.put(String.valueOf(n), partialSum);
        return partialSum;
    }
}
