package com.codigoperaza.ds;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BracketValidatorTest {

    @Test
    void acceptsBalancedBrackets() {
        assertTrue(BracketValidator.isBalanced(""));
        assertTrue(BracketValidator.isBalanced("()"));
        assertTrue(BracketValidator.isBalanced("[]"));
        assertTrue(BracketValidator.isBalanced("{}"));
        assertTrue(BracketValidator.isBalanced("{[()]}"));
    }

    @Test
    void ignoresCharactersThatAreNotBrackets() {
        assertTrue(BracketValidator.isBalanced("if (a[0] == valor) { return true; }"));
        assertTrue(BracketValidator.isBalanced("texto sin corchetes"));
    }

    @Test
    void rejectsUnclosedBrackets() {
        assertFalse(BracketValidator.isBalanced("("));
        assertFalse(BracketValidator.isBalanced("{[()]"));
    }

    @Test
    void rejectsUnexpectedClosingBrackets() {
        assertFalse(BracketValidator.isBalanced(")"));
        assertFalse(BracketValidator.isBalanced("([)]"));
        assertFalse(BracketValidator.isBalanced("}{"));
    }

    @Test
    void rejectsNullInput() {
        assertThrows(NullPointerException.class, () -> BracketValidator.isBalanced(null));
    }
}
