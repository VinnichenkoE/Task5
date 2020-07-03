package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import com.vinnichenko.task5.service.DeleteTextService;

public class StringDeleteTextServiceImpl implements DeleteTextService {

    private static final String SPACE = " ";
    private static final String SEPARATOR = "\\b";
    private static final String REGEX_LETTERS = "\\p{LC}+";
    private static final String REGEX_SPACE = "\\s+";
    private static final String VOWELS = "AEIOUaeiouАОУЫЭЯЁЮИЕаоуыэяёюие";

    @Override
    public String deleteSymbolsExceptSpaces(String text)
            throws ProgramException {
        if (text == null) {
            throw new ProgramException("incorrect parameter");
        }
        String[] charSets = text.split(SEPARATOR);
        StringBuilder stringBuilder = new StringBuilder();
        for (String charSet : charSets) {
            if (charSet.matches(REGEX_LETTERS) || charSet.matches(REGEX_SPACE)) {
                stringBuilder.append(charSet).append(SPACE);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String deleteWordsStartingConsonant(String text, int length)
            throws ProgramException {
        if (text == null || length <= 0) {
            throw new ProgramException("incorrect parameters");
        }
        String[] charSets = text.split(SEPARATOR);
        StringBuilder stringBuilder = new StringBuilder();
        for (String charSet : charSets) {
            if (!charSet.matches(REGEX_LETTERS) || charSet.length() != length
                    || VOWELS.contains(String.valueOf(charSet.charAt(0)))) {
                stringBuilder.append(charSet);
            }
        }
        return stringBuilder.toString();
    }
}