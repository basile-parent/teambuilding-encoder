package com.proxiad.escape;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageResolverTest {

    private MessageResolver messageResolver = new MessageResolver();

    @Test
    public void test_decode_shouldReturnDecodedString() {
        assertNull(messageResolver.decode("message"));
    }

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabet() {
        assertEquals("BESFC", messageResolver.decode("01234", "BESFCOYAJDLQZPRVXTMIWUHNGK"));

    }

}