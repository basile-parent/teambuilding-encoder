package com.proxiad.escape;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageResolverTest {

    private MessageResolver messageResolver = new MessageResolver();
    private static final String ALPHABET = "FNSTCMJAOHDPUXQKBGRWYVEILZ";

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithOneRepetition() {
        // A = 1st position on mixed ALPHABET => becomes F
        // B = 2nd position on mixed ALPHABET => becomes N
        // ...
        assertEquals("FFF", messageResolver.decodeRecursivly("AAA", ALPHABET, 1));
        assertEquals("FNSTC", messageResolver.decodeRecursivly("ABCDE", ALPHABET, 1));
        assertEquals("KGQIOFT", messageResolver.decodeRecursivly("PROXIAD", ALPHABET, 1));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithTwoRepetitions() {
        // /!\ Recursive function (input modified at each repetition) /!\
        // A = 1st position => becomes F = 6th position => becomes M
        // B = 2nd position => becomes N = 14th position => becomes X
        // ...
        assertEquals("MMM", messageResolver.decodeRecursivly("AAA", ALPHABET, 2));
        assertEquals("MXRWS", messageResolver.decodeRecursivly("ABCDE", ALPHABET, 2));
        assertEquals("DJBOQMW", messageResolver.decodeRecursivly("PROXIAD", ALPHABET, 2));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithThreeRepetitions() {
        // A = 1st position => becomes F = 6th position => becomes M = 13th position => becomes U
        assertEquals("UUU", messageResolver.decodeRecursivly("AAA", ALPHABET, 3));
    }

    // Enigme à résoudre : LAMWOMWXAJPAOAUA - FNSTCMJAOHDPUXQKBGRWYVEILZ - 27
    // Riddle to solve
    @Test
    public void test_decode_enigma() {
        assertEquals("JESUISUNETHEIERE", messageResolver.decodeRecursivly("KMYCBYCOMADMBMLM", ALPHABET, 27));
    }




    @Test
    public void test_encode_shouldReturnEncodedStringForEnigma() {
        final String ALPHABET_TEST = "FNSTCMJAOHDPUXQKBGRWYVEILZ";
        assertEquals("ABCDE", messageResolver.encode("FNSTC", ALPHABET_TEST, 1));

        final String ALPHABET_ENIGME = "FNSTCMJAOHDPUXQKBGRWYVEILZ";
        assertEquals("KMYCBYCOMADMBMLM", messageResolver.encode("JESUISUNETHEIERE", ALPHABET_ENIGME, 27));
    }


}