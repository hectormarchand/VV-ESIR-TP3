package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    void test1() {
        assertTrue(StringUtils.isBalanced(""));
    }
    @Test
    void test2() {
        assertTrue(StringUtils.isBalanced("([])"));
    }

    @Test
    void test3() {
        assertTrue(StringUtils.isBalanced("{hello   }"));
    }

    @Test
    void test4() {
        assertFalse(StringUtils.isBalanced("["));
    }

    @Test
    void test5() {
        assertFalse(StringUtils.isBalanced("]"));
    }

    @Test
    void test6() {
        assertTrue(StringUtils.isBalanced("hello [[[{ hello } () ]] () ]"));
    }

    @Test
    void test7() {
        assertFalse(StringUtils.isBalanced("({["));
    }

    @Test
    void test8() {
        assertFalse(StringUtils.isBalanced(")]}"));
    }

    @Test
    void test9() {
        assertFalse(StringUtils.isBalanced("(( [] ]))"));
    }

}