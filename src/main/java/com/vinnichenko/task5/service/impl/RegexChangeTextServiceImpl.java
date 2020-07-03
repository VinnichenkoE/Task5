package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import com.vinnichenko.task5.service.ChangeTextService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChangeTextServiceImpl implements ChangeTextService {

    private static final String LETTER_ON_POSITION
            = "\\b(\\p{L}{%d})(\\p{L})(\\p{L}*)";
    private static final String REPLACEMENT = "$1%s$3";
    private static final String WORD_GIVEN_LENGTH = "\\b\\p{LC}{%d}\\b";

    @Override
    public String replaceLetterWithSymbol
            (String text, int position, char symbol)
            throws ProgramException {
        if (text == null || position <= 0) {
            throw new ProgramException("incorrect parameters");
        }
        Pattern pattern = Pattern.compile(String
                .format(LETTER_ON_POSITION, position - 1));
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(String.format(REPLACEMENT, symbol));
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
        Pattern pattern = Pattern.compile(incorrectLetters);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(correctLetters);
    }

    @Override
    public String replaceWordWithSubstring
            (String text, int length, String substring)
            throws ProgramException {
        if (text == null || length <= 0 || substring == null) {
            throw new ProgramException("incorrect parameters");
        }
        Pattern pattern = Pattern.compile(String
                .format(WORD_GIVEN_LENGTH, length));
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(substring);
    }
}