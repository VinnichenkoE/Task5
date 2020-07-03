package test.vinnichenko.task5.service.impl;

import org.testng.annotations.DataProvider;

public class ChangeTextData {

    public static final String TEXT = "If one author has modified another " +
            "author's change, you will see the changes hierarchically arranged" +
            " with a plus sign for opening up the hierarchy.";

    @DataProvider(name = "replaceLetterWithSymbol")
    public static Object[][] createDataReplaceLetterWithSymbol() {

        String expected = "If one aut!or has mod!fied ano!her aut!or's cha!ge, " +
                "you wil! see the cha!ges hie!archically arr!nged wit! a plu! " +
                "sig! for ope!ing up the hie!archy.";
        return new Object[][]{{TEXT, 4, '!', expected}};
    }

    @DataProvider(name = "exceptionReplaceLetterWithSymbol")
    public static Object[][] createIncorrectDataReplaceLetter() {
        return new Object[][]{{null, 4, '!'}, {"some text", -2, '!'}};
    }

    @DataProvider(name = "replaceWrongLetter")
    public static Object[][] createDataReplaceWrongLetter() {
        String expected = "If one author hos modified another author's " +
                "chonge, you will see the chonges hierarchically arranged" +
                " with a plus sign for opening up the hierarchy.";
        return new Object[][]{{TEXT, 'a', 'o', 'h', expected}};
    }

    @DataProvider(name = "replaceWordWithSubstring")
    public static Object[][] createDataReplaceWordWithSubstring() {
        String expected = "If one author has modified another author's " +
                "change, you replacement see the changes hierarchically " +
                "arranged replacement a replacement replacement for opening" +
                " up the hierarchy.";
        return new Object[][]{{TEXT, 4, "replacement", expected}};
    }

    @DataProvider(name = "exceptionReplaceWordWithSubstring")
    public Object[][] createIncorrectDataReplaceWordWithSubstring() {
        return new Object[][]{{null, 4, "substring"},
                {"some text", -2, "substring"}, {"some text", 4, null}};
    }
}
