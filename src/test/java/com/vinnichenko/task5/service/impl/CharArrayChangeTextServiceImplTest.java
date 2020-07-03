package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CharArrayChangeTextServiceImplTest {

    CharArrayChangeTextServiceImpl charArrayChangeTextService;

    @BeforeMethod
    public void setUp() {
        charArrayChangeTextService = new CharArrayChangeTextServiceImpl();
    }

    @Test(dataProvider = "replaceLetterWithSymbol",
            dataProviderClass = ChangeTextData.class)
    public void replaceLetterWithSymbolTest
            (String text, int position, char symbol, String expected) throws ProgramException {
        String actual = charArrayChangeTextService
                .replaceLetterWithSymbol(text, position, symbol);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "exceptionReplaceLetterWithSymbol",
            dataProviderClass = ChangeTextData.class,
            expectedExceptions = ProgramException.class)
    public void replaceLetterWithSymbolTestException
            (String text, int position, char symbol) throws ProgramException {
        charArrayChangeTextService
                .replaceLetterWithSymbol(text, position, symbol);
    }

    @Test(dataProvider = "replaceWrongLetter",
            dataProviderClass = ChangeTextData.class)
    public void replaceWrongLetterTest
            (String text, char oldLetter, char newLetter,
             char previousLetter, String expected) throws ProgramException {
        String actual = charArrayChangeTextService
                .replaceWrongLetter(text, oldLetter, newLetter, previousLetter);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void replaceWrongLetterTestException() throws ProgramException {
        String nullText = null;
        charArrayChangeTextService
                .replaceWrongLetter(nullText, 'a', 'o', 'h');
    }

    @Test(dataProvider = "replaceWordWithSubstring",
            dataProviderClass = ChangeTextData.class)
    public void replaceWordWithSubstringTest
            (String text, int length, String substring, String expected)
            throws ProgramException {
        String actual = charArrayChangeTextService
                .replaceWordWithSubstring(text, length, substring);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "exceptionReplaceWordWithSubstring",
            dataProviderClass = ChangeTextData.class,
            expectedExceptions = ProgramException.class)
    public void replaceWordWithSubstringTestException
            (String text, int length, String substring)
            throws ProgramException {
        charArrayChangeTextService.replaceWordWithSubstring(text, length, substring);
    }
}