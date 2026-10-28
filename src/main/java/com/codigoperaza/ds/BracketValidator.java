package com.codigoperaza.ds;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;

public final class BracketValidator {

    private static final Map<Character, Character> CLOSING = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );

    private BracketValidator() {
    }

    public static boolean isBalanced(String text) {
        Objects.requireNonNull(text, "text");
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (CLOSING.containsKey(current)) {
                if (stack.isEmpty() || stack.pop() != CLOSING.get(current)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
