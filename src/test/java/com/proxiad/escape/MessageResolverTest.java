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
        assertEquals("JESUISUNETHEIERE", messageResolver.decode("TEIFLIFWEGOELEXE", "DBKREQICJVLTZYNGWXMSOFHAPU", 11));
    }

    @Test
    public void test_encode_shouldReturnEncodedStringForEnigma() {
        assertEquals("ABCDE", messageResolver.encode("BESFC", ALPHABET, 1));
        assertEquals("TEIFLIFWEGOELEXE", messageResolver.encode("JESUISUNETHEIERE", "DBKREQICJVLTZYNGWXMSOFHAPU", 11));
    }
    // Enigme à résoudre : TEIFLIFWEGOELEXE - DBKREQICJVLTZYNGWXMSOFHAPU - 11

}