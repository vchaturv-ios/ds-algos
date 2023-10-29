package Strings;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String str = "{}[])";
        System.out.println(validParenthesis(str));
    }

    public static boolean validParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (isOpening(current)) {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (!isMatching(stack.peek(), current)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isOpening(char c) {
        return c == '{'
                || c == '['
                || c == '(';
    }

    public static boolean isMatching(char a, char b) {
        return true;
    }
}
