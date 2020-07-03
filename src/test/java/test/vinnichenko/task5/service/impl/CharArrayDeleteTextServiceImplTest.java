package test.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import com.vinnichenko.task5.service.impl.CharArrayDeleteTextServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CharArrayDeleteTextServiceImplTest {

    CharArrayDeleteTextServiceImpl charArrayDeleteTextService;

    @BeforeMethod
    public void setUp() {
        charArrayDeleteTextService = new CharArrayDeleteTextServiceImpl();
    }

    @Test(dataProvider = "deleteSymbolsExceptSpaces",
            dataProviderClass = DeleteTextData.class)
    public void deleteSymbolsExceptSpacesTest(String text, String expected) throws ProgramException {
        String actual = charArrayDeleteTextService
                .deleteSymbolsExceptSpaces(text);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void deleteSymbolsExceptSpacesTestException() throws ProgramException {
        String nullText = null;
        charArrayDeleteTextService.deleteSymbolsExceptSpaces(nullText);
    }

    @Test(dataProvider = "deleteWordsStartingConsonant",
            dataProviderClass = DeleteTextData.class)
    public void deleteWordsStartingConsonantTest
            (String text, int length, String expected) throws ProgramException {
        String actual = charArrayDeleteTextService
                .deleteWordsStartingConsonant(text, length);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "exceptionDeleteWordsStartingConsonant",
            dataProviderClass = DeleteTextData.class,
            expectedExceptions = ProgramException.class)
    public void deleteWordsStartingConsonantTestException(String text, int length)
            throws ProgramException {
        charArrayDeleteTextService.deleteWordsStartingConsonant(text, length);
    }
}