package com.vinnichenko.task5.service.impl;

import org.testng.annotations.DataProvider;

public class DeleteTextData {

    public static final String TEXT = "Some text: for - testing the program!!!";

    @DataProvider(name = "deleteSymbolsExceptSpaces")
    public static Object[][] createDataDeleteSymbolsExceptSpaces() {
        String expected = "Some text  for   testing the program   ";
        return new Object[][]{{TEXT, expected}};
    }

    @DataProvider(name = "deleteWordsStartingConsonant")
    public static Object[][] createDataDeleteWordsStartingConsonant() {
        String expected = "Some text:  - testing  program!!!";
        return new Object[][]{{TEXT, 3, expected}};
    }

    @DataProvider(name = "exceptionDeleteWordsStartingConsonant")
    public static Object[][] createIncorrectDataDeleteWordsStartingConsonant() {
        return new Object[][]{{null, 4}, {"some text", -2}};
    }
}
