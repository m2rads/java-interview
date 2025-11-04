package bby.algorithms.challenges;

import java.util.Scanner;

public class OtherProducts {

    public static String otherProducts(int[] arr) {
        int totalProduct = 1;
        for (int num : arr) {
            totalProduct *= num;
        }

        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = totalProduct / arr[i];
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < newArr.length; i++) {
            str.append(newArr[i]);
            if (i < newArr.length - 1) {
                str.append("-");
            }
        }

        return str.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
    }
}
