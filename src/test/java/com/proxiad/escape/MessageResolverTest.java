package com.proxiad.escape;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageResolverTest {

    private MessageResolver messageResolver = new MessageResolver();
    private static final String arg2 = "BESFCOYAJDLQZPRVXTMIWUHNGK";

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithOneRepetition() {
        assertEquals("BBB", messageResolver.decode("AAA", arg2, 1));
        assertEquals("BESFC", messageResolver.decode("ABCDE", arg2, 1));
        assertEquals("VTRNJBF", messageResolver.decode("PROXIAD", arg2, 1));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithTwoRepetitions() {
        assertEquals("EEE", messageResolver.decode("AAA", arg2, 2));
        assertEquals("ECMOS", messageResolver.decode("ABCDE", arg2, 2));
        assertEquals("UITPDEO", messageResolver.decode("PROXIAD", arg2, 2));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabetWithThreeRepetitions() {
        assertEquals("CCC", messageResolver.decode("AAA", arg2, 3));
    }

    // Enigme à résoudre : TEIFLIFWEGOELEXE - DBKREQICJVLTZYNGWXMSOFHAPU - 11

}