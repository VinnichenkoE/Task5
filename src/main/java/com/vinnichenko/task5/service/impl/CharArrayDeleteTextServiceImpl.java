package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import com.vinnichenko.task5.service.DeleteTextService;

public class CharArrayDeleteTextServiceImpl implements DeleteTextService {

    private static final String VOWELS = "AEIOUaeiouАОУЫЭЯЁЮИЕаоуыэяёюие";
    private static final String SPACE = " ";

    @Override
    public String deleteSymbolsExceptSpaces(String text)
            throws ProgramException {
        if (text == null) {
            throw new ProgramException("incorrect parameter");
        }
        char[] chars = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ((Character.isAlphabetic(chars[i]))
                    || (Character.isSpaceChar(chars[i]))) {
                stringBuilder.append(chars[i]);
            } else stringBuilder.append(SPACE);
        }
        return stringBuilder.toString();
    }

    @Override
    public String deleteWordsStartingConsonant(String text, int length)
            throws ProgramException {
        if (text == null || length <= 0) {
            throw new ProgramException("incorrect parameters");
        }
        char[] chars = text.toCharArray();
        int begin;
        int end = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            begin = i;
            if (begin >= end && Character.isLetter(chars[begin])) {
                stringBuilder.append(chars, end, (begin - end));
                end = begin;
                for (int j = begin; j < chars.length; j++) {
                    if (!Character.isLetter(chars[end])) {
                        break;
                    }
                    end++;
                }
                if ((end - begin) != length || !isConsonant(chars[begin])) {
                    stringBuilder.append(chars, begin, (end - begin));
                }
            }
        }
        if (end < chars.length) {
            stringBuilder.append(chars, end, (chars.length - end));
        }
        return stringBuilder.toString();
    }

    private boolean isConsonant(char ch) {
        char[] vowels = VOWELS.toCharArray();
        for (char letter : vowels) {
            if (ch == letter) {
                return false;
            }
        }
        return true;
    }
}