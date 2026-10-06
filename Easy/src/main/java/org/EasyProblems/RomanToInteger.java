package org.EasyProblems;

import java.util.HashMap;
import java.util.stream.IntStream;

public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int total = IntStream.range(0, s.length())
                .map(i -> {
                    int current = romanValues.get(s.charAt(i));
                    boolean nextIsBigger = i + 1 < s.length() && current < romanValues.get(s.charAt(i + 1));
                    return nextIsBigger ? -current : current;
                }).sum();

        return total;
    }
}
