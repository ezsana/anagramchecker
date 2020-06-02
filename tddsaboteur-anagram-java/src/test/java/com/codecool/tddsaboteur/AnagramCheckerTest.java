package com.codecool.tddsaboteur;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class AnagramCheckerTest {

    private AnagramChecker anagramChecker;

    @BeforeEach
    void setUp() {
        this.anagramChecker = new AnagramChecker();
    }

    @Test
    void smokeTest() {
        assertNotNull(anagramChecker);
    }

    @Test
    void bothParametersAreNull() {
        assertThrows(NullPointerException.class, () -> anagramChecker.isAnagram(null, null));
    }

    @Test
    void oneParameterIsNull() {
        assertThrows(NullPointerException.class, () -> anagramChecker.isAnagram("String", null));
    }

    @Test
    void bothStringsAreEmpty() {
        assertFalse(anagramChecker.isAnagram("", ""));
    }

    @Test
    void oneStringEmpty() {
        assertFalse(anagramChecker.isAnagram("String", ""));
    }

    @TestFactory
    Collection<DynamicTest> isAnagram() {
        return Arrays.asList(DynamicTest.dynamicTest("dusty; study", () -> assertTrue(anagramChecker.isAnagram("dusty", "study"))),
                                DynamicTest.dynamicTest("Night; thing", () -> assertTrue(anagramChecker.isAnagram("Night", "thing"))),
                                DynamicTest.dynamicTest("cat; Act", () -> assertTrue(anagramChecker.isAnagram("cat", "Act"))),
                                DynamicTest.dynamicTest("Elbow; Below", () -> assertTrue(anagramChecker.isAnagram("Elbow", "Below"))),
                                DynamicTest.dynamicTest("debit card; bad credit", () -> assertTrue(anagramChecker.isAnagram("debit card", "bad credit"))),
                                DynamicTest.dynamicTest("astronomer; moon starer", () -> assertTrue(anagramChecker.isAnagram("astronomer", "moon starer"))),
                                DynamicTest.dynamicTest("eleven plus two; twelve plus one", () -> assertTrue(anagramChecker.isAnagram("eleven plus two", "twelve plus one"))));
    }

    @TestFactory
    Collection<DynamicTest> isNotAnagram() {
        return Arrays.asList(DynamicTest.dynamicTest("anagram; mama", () -> assertFalse(anagramChecker.isAnagram("anagram", "mama"))),
                                DynamicTest.dynamicTest("Kes; Doctor", () -> assertFalse(anagramChecker.isAnagram("Kes", "Doctor"))),
                                DynamicTest.dynamicTest("Chakotay; Seven Of Nine", () -> assertFalse(anagramChecker.isAnagram("Chakotay", "Seven Of Nine"))),
                                DynamicTest.dynamicTest("hello; bello", () -> assertFalse(anagramChecker.isAnagram("hello", "bello"))),
                                DynamicTest.dynamicTest("night; day", () -> assertFalse(anagramChecker.isAnagram("night", "day"))),
                                DynamicTest.dynamicTest("Are you ok, love?; I'm fine, thank you.", () -> assertFalse(anagramChecker.isAnagram("Are you ok, love?", "I'm fine, thank you."))),
                                DynamicTest.dynamicTest("Jenkins, Docker", () -> assertFalse(anagramChecker.isAnagram("Jenkins", "Docker"))));
    }


}