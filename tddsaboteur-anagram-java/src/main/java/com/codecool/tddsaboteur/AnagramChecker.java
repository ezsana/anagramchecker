package com.codecool.tddsaboteur;

import java.util.HashMap;
import java.util.Map;

/**
 * What is an anagram?
 * https://en.wikipedia.org/wiki/Anagram
 *
 * Examples:
 *
 * god == dog
 * funeral == real fun
 * William Shakespeare == I am a weakish speller
 *
 * hello != helo
 * hello != h e l l a
 * javascript != a good programming language
 */
class AnagramChecker {

    boolean isAnagram(String first, String second) {
        if (first == null || second == null) {
            throw new NullPointerException("Both strings are null.");
        }
        if (first.isEmpty() || second.isEmpty()) {
            return false;
        }
        String regex = "[^a-zA-Z]";
        first = first.toLowerCase().replaceAll(regex, "");
        second = second.toLowerCase().replaceAll(regex, "");
        if (first.length() != second.length()) {
            return false;
        }
        Map<Character, Integer> firstMap = new HashMap<>();
        Map<Character, Integer> secondMap = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            firstMap.put(first.toCharArray()[i], firstMap.getOrDefault(first.toCharArray()[i], 0)+1);
            secondMap.put(second.toCharArray()[i], secondMap.getOrDefault(second.toCharArray()[i], 0)+1);
        }

        for (Character key : firstMap.keySet()) {
            if (!firstMap.get(key).equals(secondMap.get(key))) {
                return false;
            }
        }
        return true;
    }

}
