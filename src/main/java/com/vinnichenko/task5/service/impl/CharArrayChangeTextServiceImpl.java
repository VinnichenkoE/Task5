package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.service.ChangeTextService;

public class CharArrayChangeTextServiceImpl implements ChangeTextService {
    @Override
    public String replaceLetterWithSymbol(String line, int position, char symbol) {
        char[] chars = line.toCharArray();
        int begin;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            begin = i;
            if (begin >= end && Character.isLetter(chars[begin])) {
                end = begin;
                for (int j = begin; j < chars.length; j++) {
                    if (!Character.isLetter(chars[end])) {
                        break;
                    }
                    end++;
                }
                if ((end - begin) >= position) {
                    chars[begin + position - 1] = symbol;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : chars) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    @Override
    public String replaceLetterAfterLetter(String line, char oldLetter, char newLetter, char previousLetter) {
        char[] chars = line.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == previousLetter && chars[i + 1] == oldLetter) {
                chars[i + 1] = newLetter;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : chars) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    @Override
    public String replaceWordByLengthWithSubstring(String line, int length, String substring) {
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
                if ((end - begin) == length) {
                    stringBuilder.append(substring);
                } else {
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
}