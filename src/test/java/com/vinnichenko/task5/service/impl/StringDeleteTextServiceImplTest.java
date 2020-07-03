package com.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringDeleteTextServiceImplTest {

    StringDeleteTextServiceImpl stringDeleteTextService;

    @BeforeMethod
    public void setUp() {
        stringDeleteTextService = new StringDeleteTextServiceImpl();
    }

    @Test
    public void deleteSymbolsExceptSpacesTest() throws ProgramException {
        String text = "Some text: for - testing the program!!!";
        String expected = "Some   text for testing   the   program ";
        String actual = stringDeleteTextService.deleteSymbolsExceptSpaces(text);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void deleteSymbolsExceptSpacesTestException()
            throws ProgramException {
        String nullText = null;
        stringDeleteTextService.deleteSymbolsExceptSpaces(nullText);
    }

    @Test(dataProvider = "deleteWordsStartingConsonant",
            dataProviderClass = DeleteTextData.class)
    public void deleteWordsStartingConsonantTest
            (String text, int length, String expected)
            throws ProgramException {
        String actual = stringDeleteTextService
                .deleteWordsStartingConsonant(text, length);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "exceptionDeleteWordsStartingConsonant",
            dataProviderClass = DeleteTextData.class,
            expectedExceptions = ProgramException.class)
    public void deleteWordsStartingConsonantTestException(String text, int length)
            throws ProgramException {
        stringDeleteTextService.deleteWordsStartingConsonant(text, length);
    }
}