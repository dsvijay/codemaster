package com.leet.codemaster.easy;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
 * Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
 * Example 1:
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
 * Example 2:
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
 * Example 3:
 * Input: letters = ["x","x","y","y"], target = "z"
 * Output: "x"
 * Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
 */

public class SmallestLetter {

    public static void main(String[] argz) {
//        char[] letters = {'x', 'x', 'y', 'y'};
        char[] letters = {'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//      char[] letters = {'c', 'f', 'j'};
//      char target = 'j';
//      char target = 'z';
        char target = 'y';
        System.out.println("Smallest Letter Greater Than Target :: " + nextGreatestLetter(letters,target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        final String alphabets = "abcdefghijklmnopqrstuvwxyz";
        List<String> alphabetList = Arrays.asList(alphabets.split(""));
        int indexOfTarget = alphabetList.indexOf(String.valueOf(target));


        int smallestOfInput = alphabetList.size();

        for (char character : letters) {
            int characterIndex = alphabetList.indexOf(String.valueOf(character));
            if(characterIndex > indexOfTarget && characterIndex <= smallestOfInput) {
                smallestOfInput = characterIndex;
            }
        }

        if(indexOfTarget == smallestOfInput || smallestOfInput == alphabetList.size()) {
            return letters[0];
        }

        return  alphabetList.get(smallestOfInput).charAt(0);
    }

}
