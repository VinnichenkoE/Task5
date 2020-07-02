package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.service.ChangeTextService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChangeTextServiceImpl implements ChangeTextService {
    @Override
    public String replaceLetterWithSymbol(String line, int position, char symbol) {
        String regex = "\\b(\\p{LC}{" + (position - 1) + "})(\\p{LC})(\\p{LC}*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        String regexReplace = "$1" + symbol + "$3";
        return matcher.replaceAll(regexReplace);
    }

    @Override
    public String replaceLetterAfterLetter(String line, char oldLetter, char newLetter, char previousLetter) {
        String regex = "\\b(\\p{LC}*)([" + previousLetter + Character.toUpperCase(previousLetter) + "])([" + oldLetter + "])(\\p{LC}*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        String regexReplace = "$1$2" + newLetter + "$4";
        return matcher.replaceAll(regexReplace);
    }

    @Override
    public String replaceWordByLengthWithSubstring(String line, int length, String substring) {
        String regex = "\\b(\\p{LC}{" + length + "})(\\p{Punct}*\\s+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        String regexReplace = substring + "$2";
        return matcher.replaceAll(regexReplace);
    }
}
