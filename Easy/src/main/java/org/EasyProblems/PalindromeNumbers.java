package org.EasyProblems;

public class PalindromeNumbers {
    public boolean isPalindrome(int x) {
        int result = 0;
        int number = x;
        if(x < 0){
            return false;
        }
        while (number != 0){
            int tempStorage = number % 10;
            number = number / 10;
            result = result * 10 + tempStorage;
        }
        return x == result;
    }
}
