package com.vinnichenko.task5.service;

import com.vinnichenko.task5.exception.ProgramException;

public interface ChangeTextService {
    String replaceLetterWithSymbol(String text, int position, char symbol)
            throws ProgramException;

    String replaceWrongLetter
            (String text, char oldLetter, char newLetter, char previousLetter)
            throws ProgramException;

    String replaceWordWithSubstring(String text, int length, String substring)
            throws ProgramException;
}