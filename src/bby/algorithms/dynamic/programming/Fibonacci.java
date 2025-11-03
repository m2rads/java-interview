package bby.algorithms.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static int fib(int n) {
        if (n <= 2) { return 1;}
        return fib(n -1) + fib(n -2);
    }

    public static long fibMemoized(long n, Map<Long, Long> memo) {
        if (memo.containsKey(n)) { return memo.get(n); }
        if (n <= 2) { return 1;}
        memo.put(n, fibMemoized(n -1, memo) + fibMemoized(n -2, memo));
        return memo.get(n);
    }

}
