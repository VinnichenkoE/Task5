package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.service.DeleteTextService;

public class StringDeleteTextServiceImpl implements DeleteTextService {
    @Override
    public String deleteSymbolsExceptSpaces(String line) {
        String[] tokens = line.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String token : tokens) {
            String word = tokenToWord(token);
            stringBuilder.append(word).append(" ");
        }
        return stringBuilder.toString();
    }

    private String tokenToWord(String token) {
        char[] chars = token.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i])) {
                chars[i] = ' ';
            }
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    @Override
    public String deleteWordsByLengthStartingWithConsonant(String line, int length) {
        String regex = "\\b[^AEIOUaeiouАОУЫЭЯЁЮИЕаоуыэяёюие]\\p{LC}{" + (length - 1) + "}\\b";
        String replacement = "";
        return line.replaceAll(regex, replacement);
    }
}
