package com.bparent.encoder;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 *     __  __     ____
 *    / / / /__  / / /___
 *   / /_/ / _ \/ / / __ \
 *  / __  /  __/ / / /_/ /
 * /_/ /_/\___/_/_/\____/
 *
 *
 * Here is your workspace for the decoder. I prepared two development environments (Java and Javascript) as I
 * didn't know which one you prefer.
 *
 * - If you want to code your resolver in Java, just complete the code on the MessageResolver class and
 *      execute the MessageResolverTest unit test class to check your algorithm.
 * - If you want to code in Javascript, go to message-resolver.html and complete the decode function.
 *      You can check the result of the tests by opening the file in a web browser.
 *
 * Good luck !
 *
 */
public class MessageResolverTest {

    private MessageResolver messageResolver = new MessageResolver();
    private static final String SHAKED_ALPHABET = "FNSTCMJAOHDPUXQKBGRWYVEILZ";

    @Test
    public void decode_shouldReturnDecodedStringFromAlphabetWithOneRepetition() {
        assertEquals("F", messageResolver.decodeLoop("A", SHAKED_ALPHABET, 1));
        assertEquals("M", messageResolver.decodeLoop("F", SHAKED_ALPHABET, 1));
        assertEquals("FF", messageResolver.decodeLoop("AA", SHAKED_ALPHABET, 1));
        assertEquals("FFF", messageResolver.decodeLoop("AAA", SHAKED_ALPHABET, 1));
        assertEquals("NNN", messageResolver.decodeLoop("BBB", SHAKED_ALPHABET, 1));
    }

    @Test
    public void decode_shouldReturnDecodedStringFromAlphabetWithOneRepetitionnn() {
        assertEquals("SFOT", messageResolver.decodeLoop("CAID", SHAKED_ALPHABET, 1));
        assertEquals("KGQIOFT", messageResolver.decodeLoop("PROXIAD", SHAKED_ALPHABET, 1));
        assertEquals("JAMBON", messageResolver.decodeLoop("GHFQIB", SHAKED_ALPHABET, 1));
    }

    @Test
    public void decode_shouldReturnDecodedStringFromAlphabetWithTwoRepetitions() {
        assertEquals("M", messageResolver.decodeLoop("A", SHAKED_ALPHABET, 2));
        assertEquals("Y", messageResolver.decodeLoop("M", SHAKED_ALPHABET, 2));
        assertEquals("MM", messageResolver.decodeLoop("AA", SHAKED_ALPHABET, 2));
        assertEquals("MMM", messageResolver.decodeLoop("AAA", SHAKED_ALPHABET, 2));
        assertEquals("XXX", messageResolver.decodeLoop("BBB", SHAKED_ALPHABET, 2));
    }


    @Test
    public void decode_shouldReturnDecodedStringFromAlphabetWithTwoRepetitionsss() {
        assertEquals("RMQW", messageResolver.decodeLoop("CAID", SHAKED_ALPHABET, 2));
        assertEquals("DJBOQMW", messageResolver.decodeLoop("PROXIAD", SHAKED_ALPHABET, 2));
        assertEquals("JAMBON", messageResolver.decodeLoop("RJAOXQ", SHAKED_ALPHABET, 2));
    }

    @Test
    public void decode_shouldReturnDecodedStringFromAlphabetWithThreeRepetitions() {
        assertEquals("UUU", messageResolver.decodeLoop("AAA", SHAKED_ALPHABET, 3));
    }


    /**
     * Riddle to solve
     */
    @Test
    public void decode_riddle_shouldReturnACodeToOpenSomething() {
        assertEquals("???", messageResolver.decodeLoop("???", SHAKED_ALPHABET, 0));
    }
    

}