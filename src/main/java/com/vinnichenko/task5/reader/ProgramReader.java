package com.vinnichenko.task5.reader;

import com.vinnichenko.task5.exception.ProgramException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProgramReader {

    private static final String DEFAULT_PATH = "src/main/resources/data/data.txt";

    public String readFile(String filePath) throws ProgramException {
        BufferedReader br = null;
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        if (filePath == null) {
            filePath = DEFAULT_PATH;
        }
        Path path = Paths.get(filePath);
        try {
            br = Files.newBufferedReader(path);
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new ProgramException("can not find file", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString().trim();
    }
}
