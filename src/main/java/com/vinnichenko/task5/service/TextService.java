package com.vinnichenko.task5.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextService {
    public String changeSymbol(String line, char letter, int position) {
        String[] words = line.trim().split("\\s");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= position) {
                words[i] = words[i].substring(0, position - 1) + letter + words[i].substring(position);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : words) {
            stringBuilder.append(s).append(" ");
        }
        return stringBuilder.toString();
    }

    public String changeSymbol2(String line, char letter, int position) {
        String regex = "\\b(\\p{LC}{" + (position - 1) + "})(\\p{LC})(\\p{LC}*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        String regexReplace = "$1" + letter + "$3";
        return matcher.replaceAll(regexReplace);
    }

    public String changeWrongLetter(String line) {
        String regex = "\\b(\\p{LC}*)([Pр])([а])(\\p{LC}+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        String regexReplace = "$1$2о$4";
        return matcher.replaceAll(regexReplace);
    }

    public String changeWrongLetter2(String line) {
        char[] chars = line.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'р' && chars[i + 1] == 'а') {
                chars[i + 1] = 'о';
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : chars) {
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }

    public String changeWrongLetter3(String line) {
        return  line.replaceAll("[Рр][а]", "ро");
    }

    public String replaceWords(int length, String input, String substring) {
        String[] words = input.trim().split("\\s");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == length) {
                words[i] = substring;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : words) {
            stringBuilder.append(s).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public String deleteSymbols(String input) {
        char[] chars = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ((Character.isAlphabetic(chars[i])) || (Character.isSpaceChar(chars[i]))) {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }
}

