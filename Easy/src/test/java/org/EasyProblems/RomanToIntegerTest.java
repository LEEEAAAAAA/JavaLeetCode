package org.EasyProblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class RomanToIntegerTest {

    RomanToInteger romanToInteger = new RomanToInteger();

    @ParameterizedTest
    @MethodSource("cases")
    void paramTests(String s, int expected){ assertEquals(expected, romanToInteger.romanToInt(s));}

    static Stream<Arguments> cases(){
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV",  1994)
        );
    }



}