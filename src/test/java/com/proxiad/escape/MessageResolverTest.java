package com.proxiad.escape;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageResolverTest {

    private MessageResolver messageResolver = new MessageResolver();

    @Test
    public void test_decode_shouldReturnDecodedStringFromAlphabet() {
        final String arg2 = "BESFCOYAJDLQZPRVXTMIWUHNGK";

        assertEquals("BBB", messageResolver.decode("AAA", arg2, 1));
        assertEquals("BESFC", messageResolver.decode("ABCDE", arg2, 1));
        assertEquals("ECMOS", messageResolver.decode("ABCDE", arg2, 2));
        assertEquals("ECMOS", messageResolver.decode("ABCDE", arg2, 2));
    }

    // Enigme à résoudre : TEIFLIFWEGOELEXE - DBKREQICJVLTZYNGWXMSOFHAPU - 11

}