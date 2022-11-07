package io.test.weblogorganizer;

import java.util.Scanner;

public class LogLineTokenizer {

    public LogLineTokenizer() {}

    public void tokenize(String logLine, int[] dataLine) {
        try {
            // Scan the logLine for integers.
            Scanner tokenizer = new Scanner(logLine);
            for(int i = 0; i < dataLine.length; i++) {
                dataLine[i] = tokenizer.nextInt();
            }
        }
        catch(java.util.NoSuchElementException e) {
            System.out.println("Insuffient data items on log line: " + logLine);
            throw e;
        }
    }
}
