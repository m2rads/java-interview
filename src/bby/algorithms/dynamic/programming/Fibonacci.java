package bby.algorithms.dynamic.programming;

import java.util.HashMap;

public class Fibonacci {

    public static int fib(int n) {
        if (n <= 2) { return 1;}
        return fib(n -1) + fib(n -2);
    }

    public static int fibMemoized(int n, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(n)) { return memo.get(n); }
        if (n <= 2) { return 1;}
        memo.put(n, fibMemoized(n -1, memo) + fibMemoized(n -2, memo));
        return memo.get(n);
    }

}
