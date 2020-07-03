package test.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import com.vinnichenko.task5.service.impl.RegexDeleteTextServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegexDeleteTextServiceImplTest {

    RegexDeleteTextServiceImpl regexDeleteTextService;

    @BeforeMethod
    public void setUp() {
        regexDeleteTextService = new RegexDeleteTextServiceImpl();
    }

    @Test(dataProvider = "deleteSymbolsExceptSpaces",
            dataProviderClass = DeleteTextData.class)
    public void deleteSymbolsExceptSpacesTest(String text, String expected)
            throws ProgramException {
        String actual = regexDeleteTextService
                .deleteSymbolsExceptSpaces(text);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void deleteSymbolsExceptSpacesTestException() throws ProgramException {
        String nullText = null;
        regexDeleteTextService.deleteSymbolsExceptSpaces(nullText);
    }

    @Test(dataProvider = "deleteWordsStartingConsonant",
            dataProviderClass = DeleteTextData.class)
    public void deleteWordsStartingConsonantTest
            (String text, int length, String expected) throws ProgramException {
        String actual = regexDeleteTextService
                .deleteWordsStartingConsonant(text, length);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "exceptionDeleteWordsStartingConsonant",
            dataProviderClass = DeleteTextData.class,
            expectedExceptions = ProgramException.class)
    public void deleteWordsStartingConsonantTestException(String text, int length)
            throws ProgramException {
        regexDeleteTextService.deleteWordsStartingConsonant(text, length);
    }
}