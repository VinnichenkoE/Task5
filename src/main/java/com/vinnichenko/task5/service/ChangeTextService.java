package com.vinnichenko.task5.service;

public interface ChangeTextService {
    String replaceLetterWithSymbol(String line, int position, char symbol);

    String replaceLetterAfterLetter(String line, char oldLetter, char newLetter, char previousLetter);

    String replaceWordByLengthWithSubstring(String line, int length, String substring);
}
