package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.service.DeleteTextService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDeleteTextServiceImpl implements DeleteTextService {
    @Override
    public String deleteSymbolsExceptSpaces(String line) {
        String regex = "(\\p{LC}+)(\\p{Punct}*)(\\s*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        String regexReplace = "$1 $3";
        return matcher.replaceAll(regexReplace);
    }

    @Override
    public String deleteWordsByLengthStartingWithConsonant(String line, int length) {
        String regex = "\\b[^AEIOUaeiouАОУЫЭЯЁЮИЕаоуыэяёюие]\\p{LC}{" + (length-1) + "}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.replaceAll("");
    }
}
