package com.proxiad.escape;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageResolverTest {

    private MessageResolver messageResolver = new MessageResolver();

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabet() {
        final String ALPHABET = "BESFCOYAJDLQZPRVXTMIWUHNGK";

        assertEquals("BBB", messageResolver.decode("AAA", ALPHABET, 1));
        assertEquals("BESFC", messageResolver.decode("ABCDE", ALPHABET, 1));
        assertEquals("ECMOS", messageResolver.decode("ABCDE", ALPHABET, 2));
        assertEquals("ECMOS", messageResolver.decode("ABCDE", ALPHABET, 2));
    }

    @Test
    public void test_encode_shouldReturnEncodedStringForEnigma() {
        final String ALPHABET_TEST = "BESFCOYAJDLQZPRVXTMIWUHNGK";
        assertEquals("ABCDE", messageResolver.encode("BESFC", ALPHABET_TEST, 1));

        final String ALPHABET_ENIGME = "DBKREQICJVLTZYNGWXMSOFHAPU";
        assertEquals("TEIFLIFWEGOELEXE", messageResolver.encode("JESUISUNETHEIERE", ALPHABET_ENIGME, 11));
    }
    // Enigme à résoudre : TEIFLIFWEGOELEXE - DBKREQICJVLTZYNGWXMSOFHAPU - 11

}