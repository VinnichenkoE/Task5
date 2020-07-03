package test.vinnichenko.task5.service.impl;

import com.vinnichenko.task5.exception.ProgramException;
import com.vinnichenko.task5.service.impl.StringChangeTextServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringChangeTextServiceImplTest {

    StringChangeTextServiceImpl stringChangeTextService;

    @BeforeMethod
    public void setUp() {
        stringChangeTextService = new StringChangeTextServiceImpl();
    }

    @Test(dataProvider = "replaceLetterWithSymbol",
            dataProviderClass = ChangeTextData.class)
    public void replaceLetterWithSymbolTest
            (String text, int position, char symbol, String expected)
            throws ProgramException {
        String actual = stringChangeTextService
                .replaceLetterWithSymbol(text, position, symbol);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "exceptionReplaceLetterWithSymbol",
            dataProviderClass = ChangeTextData.class,
            expectedExceptions = ProgramException.class)
    public void replaceLetterWithSymbolTestException
            (String text, int position, char symbol) throws ProgramException {
        stringChangeTextService.replaceLetterWithSymbol(text, position, symbol);
    }

    @Test(dataProvider = "replaceWrongLetter",
            dataProviderClass = ChangeTextData.class)
    public void replaceWrongLetterTest
            (String text, char oldLetter, char newLetter,
             char previousLetter, String expected) throws ProgramException {
        String actual = stringChangeTextService
                .replaceWrongLetter(text, oldLetter, newLetter, previousLetter);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void replaceWrongLetterTestException() throws ProgramException {
        String nullText = null;
        stringChangeTextService
                .replaceWrongLetter(nullText, 'a', 'o', 'h');
    }

    @Test(dataProvider = "replaceWordWithSubstring",
            dataProviderClass = ChangeTextData.class)
    public void replaceWordWithSubstringTest
            (String text, int length, String substring, String expected)
            throws ProgramException {
        String actual = stringChangeTextService
                .replaceWordWithSubstring(text, length, substring);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "exceptionReplaceWordWithSubstring",
            dataProviderClass = ChangeTextData.class,
            expectedExceptions = ProgramException.class)
    public void replaceWordWithSubstringTestException
            (String text, int length, String substring)
            throws ProgramException {
        stringChangeTextService.replaceWordWithSubstring(text, length, substring);
    }
}