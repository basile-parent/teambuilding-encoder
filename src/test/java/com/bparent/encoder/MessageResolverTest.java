package com.bparent.encoder;

import org.junit.Test;

import static org.junit.Assert.*;

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
    public void decode_shouldReturnDecodedStringFromAlphabetWithOneRepetition_realWords() {
        assertEquals("PCGQLUCGPOX", messageResolver.decodeLoop("LEROYMERLIN", SHAKED_ALPHABET, 1));
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
    public void decode_shouldReturnDecodedStringFromAlphabetWithTwoRepetitions_realWords() {
        assertEquals("KSJBPYSJKQI", messageResolver.decodeLoop("LEROYMERLIN", SHAKED_ALPHABET, 2));
        assertEquals("JAMBON", messageResolver.decodeLoop("RJAOXQ", SHAKED_ALPHABET, 2));
    }

    @Test
    public void decode_shouldReturnDecodedStringFromAlphabetWithThreeRepetitions() {
        assertEquals("UUU", messageResolver.decodeLoop("AAA", SHAKED_ALPHABET, 3));
    }




    @Test
    public void decode_enigma() {
        assertEquals("JESUISUNETHEIERE", messageResolver.decodeLoop("KMYCBYCOMADMBMLM", SHAKED_ALPHABET, 27));
    }



    // Ne pas recopier dans la branche main
    @Test
    public void encode_shouldReturnEncodedStringForEnigma() {
        final String ALPHABET_TEST = "FNSTCMJAOHDPUXQKBGRWYVEILZ";
        assertEquals("ABCDE", messageResolver.encodeLoop("FNSTC", ALPHABET_TEST, 1));

        final String ALPHABET_ENIGME = "FNSTCMJAOHDPUXQKBGRWYVEILZ";
        assertEquals("KMYCBYCOMADMBMLM", messageResolver.encodeLoop("JESUISUNETHEIERE", ALPHABET_ENIGME, 27));
    }


}