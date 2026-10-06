package org.EasyProblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class RomanToIntegerTest {

    RomanToInteger romanToInteger = new RomanToInteger();
    @Test
    void FirstTest(){
        //given
        String input = "III";
        int expected = 3;
        //when
        int actual = romanToInteger.romanToInt(input);
        //then
        Assertions.assertEquals(expected, actual);
    }
}