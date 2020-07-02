package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.service.DeleteTextService;

public class CharArrayDeleteTextServiceImpl implements DeleteTextService {

    private static final String VOWELS = "AEIOUaeiouАОУЫЭЯЁЮИЕаоуыэяёюие";

    @Override
    public String deleteSymbolsExceptSpaces(String line) {
        char[] chars = line.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ((Character.isAlphabetic(chars[i])) || (Character.isSpaceChar(chars[i]))) {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String deleteWordsByLengthStartingWithConsonant(String line, int length) {
        char[] chars = line.toCharArray();
        int begin;
        int end = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            begin = i;
            if (begin >= end && Character.isLetter(chars[begin])) {
                for (int k = end; k < begin; k++) {
                    stringBuilder.append(chars[k]);
                }
                end = begin;
                for (int j = begin; j < chars.length; j++) {
                    if (!Character.isLetter(chars[end])) {
                        break;
                    }
                    end++;
                }
                if (!((end - begin) == length && isConsonant(chars[begin]))) {
                    for (int l = begin; l < end; l++) {
                        stringBuilder.append(chars[l]);
                    }
                }
            }
        }
        if (end < chars.length) {
            for (int f = end; f < chars.length; f++) {
                stringBuilder.append(chars[f]);
            }
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
