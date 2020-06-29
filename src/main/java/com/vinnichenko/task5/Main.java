package com.vinnichenko.task5;

import com.vinnichenko.task5.exception.ProgramException;
import com.vinnichenko.task5.reader.ProgramReader;
import com.vinnichenko.task5.service.TextService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws ProgramException {
        ProgramReader programReader = new ProgramReader();
        String str = programReader.readFile("src/main/resources/data/data.txt");
        TextService textService = new TextService();
        System.out.println(str);
        System.out.println(textService.changeSymbol3(str, 'Y', 3));
    }
}
