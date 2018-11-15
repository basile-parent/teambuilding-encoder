package com.proxiad.escape;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MessageResolver {

    public static void main(String[] args) {

    }

    public String decode(String message) {
        return null;
    }

    public String decode(String message, String alphabet) {
        String messageLower = message.toLowerCase();
        return IntStream.range(0, messageLower.length())
                .map(idx -> Integer.valueOf(((int) messageLower.charAt(idx) - 'a') + ""))
                .boxed()
                .map(c -> alphabet.charAt(c) + "")
                .collect(Collectors.joining());
    }

}
