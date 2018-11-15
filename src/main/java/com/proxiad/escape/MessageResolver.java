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
        return IntStream.range(0, message.length())
                .map(idx -> Integer.valueOf(message.charAt(idx) + ""))
                .boxed()
                .map(c -> alphabet.charAt(c) + "")
                .collect(Collectors.joining());
    }

}
