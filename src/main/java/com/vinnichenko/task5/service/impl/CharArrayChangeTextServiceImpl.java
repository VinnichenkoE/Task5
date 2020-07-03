package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import com.vinnichenko.task5.service.ChangeTextService;

public class CharArrayChangeTextServiceImpl implements ChangeTextService {

    @Override
    public String replaceLetterWithSymbol
            (String text, int position, char symbol)
            throws ProgramException {
        if (text == null || position <= 0) {
            throw new ProgramException("incorrect parameters");
        }
        char[] chars = text.toCharArray();
        int begin;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            begin = i;
            if (begin >= end && Character.isLetter(chars[begin])) {
                end = begin;
                for (int j = begin; j < chars.length; j++) {
                    if (!(Character.isLetter(chars[end])
                            || chars[end] == '-')) {
                        break;
                    }
                    end++;
                }
                if ((end - begin) >= position) {
                    chars[begin + position - 1] = symbol;
                }
            }
        }
        return String.valueOf(chars);
    }

    @Override
    public String replaceWrongLetter
            (String text, char oldLetter, char newLetter, char previousLetter)
            throws ProgramException {
        if (text == null) {
            throw new ProgramException("incorrect parameter");
        }
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == previousLetter && chars[i + 1] == oldLetter) {
                chars[i + 1] = newLetter;
            }
        }
        return String.valueOf(chars);
    }

    @Override
    public String replaceWordWithSubstring
            (String text, int length, String substring)
            throws ProgramException {
        if (text == null || length <= 0 || substring == null) {
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
                if ((end - begin) == length) {
                    stringBuilder.append(substring);
                } else {
                    stringBuilder.append(chars, begin, (end - begin));
                }
            }
        }
        if (end < chars.length) {
            stringBuilder.append(chars, end, (chars.length - end));
        }
        return stringBuilder.toString();
    }
}