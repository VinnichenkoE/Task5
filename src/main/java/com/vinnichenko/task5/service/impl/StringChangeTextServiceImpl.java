package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import com.vinnichenko.task5.service.ChangeTextService;

public class StringChangeTextServiceImpl implements ChangeTextService {

    private static final String SEPARATOR = "\\b";
    private static final String WORD = "\\p{LC}+";

    @Override
    public String replaceLetterWithSymbol
            (String text, int position, char symbol)
            throws ProgramException {
        if (text == null || position <= 0) {
            throw new ProgramException("incorrect parameters");
        }
        String[] charSets = text.split(SEPARATOR);
        StringBuilder stringBuilder = new StringBuilder();
        for (String charSet : charSets) {
            if (charSet.matches(WORD) && charSet.length() >= position) {
                String newWord = charSet.substring(0, position - 1) + symbol
                        + charSet.substring(position);
                stringBuilder.append(newWord);
            } else {
                stringBuilder.append(charSet);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String replaceWrongLetter
            (String text, char oldLetter, char newLetter, char previousLetter)
            throws ProgramException {
        if (text == null) {
            throw new ProgramException("incorrect parameter");
        }
        String incorrectLetters = String.valueOf(previousLetter) + oldLetter;
        String correctLetters = String.valueOf(previousLetter) + newLetter;
        return text.replace(incorrectLetters, correctLetters);
    }

    @Override
    public String replaceWordWithSubstring
            (String text, int length, String substring)
            throws ProgramException {
        if (text == null || length <= 0 || substring == null) {
            throw new ProgramException("incorrect parameters");
        }
        String[] charSets = text.split(SEPARATOR);
        StringBuilder stringBuilder = new StringBuilder();
        for (String charSet : charSets) {
            if (charSet.matches(WORD) && charSet.length() == length) {
                stringBuilder.append(substring);
            } else {
                stringBuilder.append(charSet);
            }
        }
        return stringBuilder.toString();
    }
}