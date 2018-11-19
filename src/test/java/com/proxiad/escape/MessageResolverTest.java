package com.proxiad.escape;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageResolverTest {

    private MessageResolver messageResolver = new MessageResolver();
    private static final String ALPHABET = "BESFCOYAJDLQZPRVXTMIWUHNGK";

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabet() {
        assertEquals("BBB", messageResolver.decode("AAA", ALPHABET, 1));
        assertEquals("BESFC", messageResolver.decode("ABCDE", ALPHABET, 1));
        assertEquals("ECMOS", messageResolver.decode("ABCDE", ALPHABET, 2));
        assertEquals("ECMOS", messageResolver.decode("ABCDE", ALPHABET, 2));
    }

    @Test
    public void test_encode_shouldReturnEncodedStringForEnigma() {
        assertEquals("ABCDE", messageResolver.encode("BESFC", ALPHABET, 1));
    }
    // Enigme à résoudre :

}