package bby.algorithms.challenges;

import java.util.Scanner;

public class NumberEncoding {

    public static String numberEncoding(String str) {
        StringBuilder result = new StringBuilder();
        char currentChar = ' ';

        for (int i = 0; i < str.length(); i++ ) {
            currentChar = str.charAt(i);
            if (String.valueOf(currentChar).matches("[a-zA-Z]")) { // if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) or if (Character.isLetter(str.CharAt(i))
                char upperChar = Character.toUpperCase(currentChar);
                int position = upperChar - 'A' + 1;
                result.append(position);
            }
            else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(numberEncoding(s.nextLine()));
    }
}
