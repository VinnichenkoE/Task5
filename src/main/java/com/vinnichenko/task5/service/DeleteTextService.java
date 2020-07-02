package com.vinnichenko.task5.service;

public interface DeleteTextService {
    String deleteSymbolsExceptSpaces(String line);
    String deleteWordsByLengthStartingWithConsonant(String line, int length);
}
