package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import com.vinnichenko.task5.service.DeleteTextService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDeleteTextServiceImpl implements DeleteTextService {

    private static final String SYMBOLS_EXPECT_LETTERS_AND_SPACE
            = "[^\\p{LC}*\\s*]";
    private static final String SPACE = " ";
    private static final String WORD_GIVEN_LENGTH_STARTING_CONSONANT
            = "\\b[^AEIOUaeiouАОУЫЭЯЁЮИЕаоуыэяёюие]\\p{LC}{%d}\\b";

    @Override
    public String deleteSymbolsExceptSpaces(String text)
            throws ProgramException {
        if (text == null) {
            throw new ProgramException("incorrect parameter");
        }
        Pattern pattern = Pattern.compile(SYMBOLS_EXPECT_LETTERS_AND_SPACE);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(SPACE);
    }

    @Override
    public String deleteWordsStartingConsonant(String text, int length)
            throws ProgramException {
        if (text == null || length <= 0) {
            throw new ProgramException("incorrect parameters");
        }
        Pattern pattern = Pattern.compile(String
                .format(WORD_GIVEN_LENGTH_STARTING_CONSONANT, length - 1));
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("");
    }
}