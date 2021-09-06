package GridTraveller;

import java.util.Map;

public class GridTraveller {

    // time complexity O(n*m)
    // space complexity O(n+m)
    public long countPathsMemoized(long n, long m, Map<String, Long> memo){
        String key = n + "," + m;
        if(memo.containsKey(key))
            return memo.get(key);
        if(n == 1l && m == 1l)
            return 1l;
        if(n == 0l || m == 0l)
            return 0l;

        long partialSum = countPathsMemoized(n - 1l , m, memo) + countPathsMemoized(n, m - 1l, memo);
        memo.put(key, partialSum);
        return partialSum;
    }

    // time complexity O(2 to n+m)
    // space complexity O(n+m)
    public int countPathsBruteForce(int n, int m) {
       if(n == 1 && m == 1)
           return 1;
        if(n == 0 || m == 0)
            return 0;
        return countPathsBruteForce(n -1 , m) + countPathsBruteForce(n, m - 1);
    }
}
