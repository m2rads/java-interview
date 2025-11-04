package bby.algorithms.challenges;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductsDigits {

    public static int productDigits(int num) {

        int minDigits = Integer.MAX_VALUE;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                int factor1 = i;
                int factor2 = num / i;

                int digitCount = countDigits(factor1) + countDigits(factor2);

                minDigits = Math.min(minDigits, digitCount);
            }
        }

        return minDigits;
    }

    private static int countDigits (int num) {
        if (num == 0 ) return 1;
        int count = 0;

        while (num > 0) {
            count++;
            n = n / 10;
        }

        return count;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(productDigits(Integer.parseInt(s.nextLine())));
    }

}
