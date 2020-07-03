package com.vinnichenko.task5.service;

import com.vinnichenko.task5.exception.ProgramException;

public interface DeleteTextService {
    String deleteSymbolsExceptSpaces(String text) throws ProgramException;

    String deleteWordsStartingConsonant(String text, int length)
            throws ProgramException;
}