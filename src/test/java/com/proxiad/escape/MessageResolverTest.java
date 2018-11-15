package com.proxiad.escape;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageResolverTest {

    private MessageResolver messageResolver = new MessageResolver();
    private static final String ALPHABET = "BESFCOYAJDLQZPRVXTMIWUHNGK";

    @Test
    public void test_decode_shouldReturnDecodedString() {
        assertNull(messageResolver.decode("message"));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabet() {
        assertEquals("BBB", messageResolver.decode("AAA", ALPHABET));
        assertEquals("BESFC", messageResolver.decode("ABCDE", ALPHABET));
    }

}