package com.weblog.analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class LogfileReader implements Iterator<LogEntry> {

    private String format;
    // Where the file's contents are stored in the form
    // of LogEntry objects.
    private ArrayList<LogEntry> entries;
    // An iterator over entries.
    private Iterator<LogEntry> dataIterator;

    public LogfileReader() {

        this("weblog.txt");
    }

    public LogfileReader(String fileName) {
        // The format for the data.
        format = "Year Month(1-12) Day Hour Minute";
        // Where to store the data.
        entries = new ArrayList<>();
        // Attempt to read the complete set of data from file.
        boolean dataRead;
        try {
            // Locate the file with respect to the current environment.
            URL fileURL = getClass().getClassLoader().getResource(fileName);
            if (fileURL == null) {
                throw new FileNotFoundException(fileName);
            }
            Scanner logFile = new Scanner(new File(fileURL.toURI()));
            // Read the data lines until the end of file.
            while (logFile.hasNextLine()) {
                String logLine = logFile.nextLine();
                // Break up the line and add it to the list of entries.
                LogEntry entry = new LogEntry(logLine);
                entries.add(entry);
            }
            logFile.close();
            dataRead = true;
        }
        catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("Problem encountered: " + e);
            dataRead = false;
        }
        // If we couldn't read the log file, use simulated data.
        if (!dataRead) {
            System.out.println("Failed to read the data file: " + fileName);
            System.out.println("Using simulated data instead.");
            createSimulatedData(entries);
        }
        // Sort the entries into ascending order.
        Collections.sort(entries);
        reset();
    }

    public boolean hasNext() {

        return dataIterator.hasNext();
    }

    public LogEntry next() {

        return dataIterator.next();
    }

    public void remove() {

        System.err.println("It is not permitted to remove entries.");
    }

    public String getFormat() {

        return format;
    }

    public void reset() {

        dataIterator = entries.iterator();
    }

    public void printData() {
        for (LogEntry entry :
                entries) {
            System.out.println(entry);
        }
    }

    private void createSimulatedData(ArrayList<LogEntry> data) {
        LogFileCreator creator = new LogFileCreator();
        // How many simulated entries we want.
        int numEntries = 100;
        for (int i = 0; i < numEntries; i++) {
            data.add(creator.createEntry());
        }
    }

}
