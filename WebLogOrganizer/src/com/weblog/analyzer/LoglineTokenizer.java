package com.weblog.analyzer;

import java.util.Scanner;

public class LoglineTokenizer {
    public LoglineTokenizer() {}
    public void tokenize(String logline, int[] dataLine) {
        try {
            // Scan the logline for integers.
            Scanner tokenizer = new Scanner(logline);
            for(int i = 0; i < dataLine.length; i++) {
                dataLine[i] = tokenizer.nextInt();
            }
        }
        catch(java.util.NoSuchElementException e) {
            System.out.println("Insuffient data items on log line: " + logline);
            throw e;
        }
    }
}
