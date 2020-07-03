package com.vinnichenko.task5.reader;

import com.vinnichenko.task5.exception.ProgramException;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.*;

public class ProgramReaderTest {

    @Test
    public void readConsoleTest() throws ProgramException {
        ProgramReader programReader = new ProgramReader();
        String expected = "Testing console input. Let's go...";
        String consoleInput = "Testing console input. Let's go...\nexit";
        InputStream input = new ByteArrayInputStream(consoleInput.getBytes());
        System.setIn(input);
        String actual = programReader.readConsole();
        assertEquals(actual, expected);
    }
}