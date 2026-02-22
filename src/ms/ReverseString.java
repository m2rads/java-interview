package ms;

import java.util.Stack;

public class ReverseString {

    public String reverseWords(String s) {
        // solve this with Stack
        // last in first out

        Stack<String> stack = new Stack<>();
        String[] sArray = s.trim().split("\\s+");

        for (String string : sArray) {
            stack.push(string);
        }

        String reversedString = "";

        while(!stack.isEmpty()) {
            reversedString += stack.pop();
            if (!stack.isEmpty()) {
                reversedString += " ";
            }
        }

        return reversedString;
    }

}
