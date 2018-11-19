package com.proxiad.escape;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MessageResolver {

    public static void main(String[] args) {

    }

    public String decode(String message, String alphabet, int times) {
        String decodedMessage = message;
        for (int i = 0; i < times; i++) {
            decodedMessage = decode(decodedMessage, alphabet);
        }

        return decodedMessage;
    }

    private String decode(String message, String alphabet) {
        String messageUpper = message.toUpperCase();
        return IntStream.range(0, messageUpper.length())
                .map(idx -> Integer.valueOf(((int) messageUpper.charAt(idx) - 'a') + ""))
                .boxed()
                .map(c -> alphabet.charAt(c) + "")
                .collect(Collectors.joining());
    }

    public String encode(String message, String alphabet, int times) {
        String encodedMessage = message;
        for (int i = 0; i < times; i++) {
            encodedMessage = encode(encodedMessage, alphabet);
        }

        return encodedMessage;
    }

    private String encode(String message, String alphabet) {
        String messageUpper = message.toUpperCase();
        String alphabetUpper = alphabet.toUpperCase();
        return IntStream.range(0, messageUpper.length())
                .map(idx -> alphabetUpper.indexOf(messageUpper.charAt(idx) + ""))
                .boxed()
                .map(c -> ((char) ((int) 'A' + c)) + "")
                .collect(Collectors.joining());
    }

}
