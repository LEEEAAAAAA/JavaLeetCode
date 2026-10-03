package org.EasyProblems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumbersTest {
    private final PalindromeNumbers palindromeNumbers = new PalindromeNumbers();

    @ParameterizedTest
    @MethodSource("cases")
    void paramtests(int x, boolean expected){
        assertEquals(expected, palindromeNumbers.isPalindrome(x));
    }

    static Stream<Arguments> cases(){
        return Stream.of(
                Arguments.of(121,true),
                Arguments.of(-121, false),
                Arguments.of(10, false)
        );
    }
}