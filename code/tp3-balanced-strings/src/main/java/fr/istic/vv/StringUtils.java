package fr.istic.vv;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }
            else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();


    }

}
