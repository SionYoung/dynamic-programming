package CanSum;

import java.util.Map;

public class CanSum {

    // time complexity O(n to the power of m)
    // space complexity O(m)
    // n: array length, m: target sum
    public boolean bruteForce(int targetSum, int [] numbers){
        if(targetSum == 0)
            return true;
        if(targetSum < 0)
            return false;

        for(int num : numbers){
            int remainder = targetSum - num;
            if (bruteForce(remainder, numbers)){
                return true;
            }
        }
        return false;
    }

    // time complexity O(m*n)
    // space complexity O(m)
    public boolean memoized(int targetSum, int [] numbers, Map<String, Boolean> memo){
        if(memo.containsKey(String.valueOf(targetSum)))
            return memo.get(String.valueOf(targetSum));

        if(targetSum == 0)
            return true;
        if(targetSum < 0)
            return false;

        for(int num : numbers){
            int remainder = targetSum - num;
            boolean result = memoized(remainder, numbers, memo);
            memo.put(String.valueOf(remainder), result);
            if (result){
                return true;
            }
        }
        return false;
    }
}
