package com.proxiad.escape;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageResolverTest {

    private MessageResolver messageResolver = new MessageResolver();
    private static final String ALPHABET = "FNSTCMJAOHDPUXQKBGRWYVEILZ";

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithOneRepetition() {
        // A = 1st position, B = 2nd position, ...
        assertEquals("FFF", messageResolver.decodeRecursivly("AAA", ALPHABET, 1));
        assertEquals("FNSTC", messageResolver.decodeRecursivly("ABCDE", ALPHABET, 1));
        assertEquals("KGQIOFT", messageResolver.decodeRecursivly("PROXIAD", ALPHABET, 1));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithTwoRepetitions() {
        // /!\ Recursive function (input modified at each repetition) /!\
        assertEquals("MMM", messageResolver.decodeRecursivly("AAA", ALPHABET, 2));
        assertEquals("MXRWS", messageResolver.decodeRecursivly("ABCDE", ALPHABET, 2));
        assertEquals("DJBOQMW", messageResolver.decodeRecursivly("PROXIAD", ALPHABET, 2));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithThreeRepetitions() {
        assertEquals("UUU", messageResolver.decodeRecursivly("AAA", ALPHABET, 3));
    }

    // Riddle to solve
    @Test
    public void test_decode_enigma() {
        assertEquals("???", messageResolver.decodeRecursivly("KMYCBYCOMADMBMLM", ALPHABET, 27));
    }

}