package com.proxiad.escape;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageResolverTest {

    private MessageResolver messageResolver = new MessageResolver();
    private static final String SHAKED_ALPHABET = "FNSTCMJAOHDPUXQKBGRWYVEILZ";

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithOneRepetition() {
        assertEquals("F", messageResolver.decodeRecursivly("A", SHAKED_ALPHABET, 1));
        assertEquals("M", messageResolver.decodeRecursivly("F", SHAKED_ALPHABET, 1));
        assertEquals("FF", messageResolver.decodeRecursivly("AA", SHAKED_ALPHABET, 1));
        assertEquals("FFF", messageResolver.decodeRecursivly("AAA", SHAKED_ALPHABET, 1));
        assertEquals("NNN", messageResolver.decodeRecursivly("BBB", SHAKED_ALPHABET, 1));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithOneRepetitionnn() {
        assertEquals("SFOT", messageResolver.decodeRecursivly("CAID", SHAKED_ALPHABET, 1));
        assertEquals("KGQIOFT", messageResolver.decodeRecursivly("PROXIAD", SHAKED_ALPHABET, 1));
        assertEquals("JAMBON", messageResolver.decodeRecursivly("GHFQIB", SHAKED_ALPHABET, 1));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithTwoRepetitions() {
        assertEquals("M", messageResolver.decodeRecursivly("A", SHAKED_ALPHABET, 2));
        assertEquals("Y", messageResolver.decodeRecursivly("M", SHAKED_ALPHABET, 2));
        assertEquals("MM", messageResolver.decodeRecursivly("AA", SHAKED_ALPHABET, 2));
        assertEquals("MMM", messageResolver.decodeRecursivly("AAA", SHAKED_ALPHABET, 2));
        assertEquals("XXX", messageResolver.decodeRecursivly("BBB", SHAKED_ALPHABET, 2));
    }


    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithTwoRepetitionsss() {
        assertEquals("RMQW", messageResolver.decodeRecursivly("CAID", SHAKED_ALPHABET, 2));
        assertEquals("DJBOQMW", messageResolver.decodeRecursivly("PROXIAD", SHAKED_ALPHABET, 2));
        assertEquals("JAMBON", messageResolver.decodeRecursivly("RJAOXQ", SHAKED_ALPHABET, 2));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithThreeRepetitions() {
        assertEquals("UUU", messageResolver.decodeRecursivly("AAA", SHAKED_ALPHABET, 3));
    }

    // Enigme à résoudre : LAMWOMWXAJPAOAUA - FNSTCMJAOHDPUXQKBGRWYVEILZ - 27
    // Riddle to solve
    @Test
    public void test_decode_enigma() {
        assertEquals("JESUISUNETHEIERE", messageResolver.decodeRecursivly("KMYCBYCOMADMBMLM", SHAKED_ALPHABET, 27));
    }




    @Test
    public void test_encode_shouldReturnEncodedStringForEnigma() {
        final String ALPHABET_TEST = "FNSTCMJAOHDPUXQKBGRWYVEILZ";
        assertEquals("ABCDE", messageResolver.encode("FNSTC", ALPHABET_TEST, 1));

        final String ALPHABET_ENIGME = "FNSTCMJAOHDPUXQKBGRWYVEILZ";
        assertEquals("KMYCBYCOMADMBMLM", messageResolver.encode("JESUISUNETHEIERE", ALPHABET_ENIGME, 27));
    }


}