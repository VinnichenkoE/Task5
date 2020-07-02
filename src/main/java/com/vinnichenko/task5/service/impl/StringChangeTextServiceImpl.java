package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.service.ChangeTextService;

public class StringChangeTextServiceImpl implements ChangeTextService {
    @Override
    public String replaceLetterWithSymbol(String line, int position, char symbol) {
        String regex = "(\\p{LC}{" + (position - 1) + "})(\\p{LC})(\\p{LC}*)";
        String replacement = "$1" + symbol + "$3";
        return line.replaceAll(regex, replacement);
    }

    @Override
    public String replaceLetterAfterLetter(String line, char oldLetter, char newLetter, char previousLetter) {
        String incorrectLetters = String.valueOf(previousLetter) + oldLetter;
        String newLetters = String.valueOf(previousLetter) + newLetter;
        String result = "";
        if (line.contains(incorrectLetters)) {
            result = line.replace(incorrectLetters, newLetters);
        }
        return result;
    }

    @Override
    public String replaceWordByLengthWithSubstring(String line, int length, String substring) {
        String regex = "\\b(\\p{LC}{" + length + "})(\\p{Punct}*\\s+)";
        String replacement = substring + "$2";
        return line.replaceAll(regex, replacement);
    }
}
