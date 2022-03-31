package com.weblog.analyzer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

// import static java.time.format.DateTimeTextProvider.createEntry;

public class LogfileCreator {
    private Random rand;

    public LogfileCreator() {
        rand = new Random();
    }
    public boolean createFile(String filename, int numEntries)
    {
        boolean success = false;

        if(numEntries > 0) {
            try (FileWriter writer = new FileWriter(filename)) {
                LogEntry[] entries = new LogEntry[numEntries];
                for(int i = 0; i < numEntries; i++) {
                    entries[i] = createEntry();
                }
                Arrays.sort(entries);
                for(int i = 0; i < numEntries; i++) {
                    writer.write(entries[i].toString());
                    writer.write('\n');
                }

                success = true;
            }
            catch(IOException e) {
                System.err.println("There was a problem writing to " + filename);
            }

        }
        return success;
    }

    public LogEntry createEntry()
    {
        int year = 2016;
        int month = 1 + rand.nextInt(12);
        // Avoid the complexities of days-per-month.
        int day = 1 + rand.nextInt(28);
        int hour = rand.nextInt(24);
        int minute = rand.nextInt(60);
        return new LogEntry(year, month, day, hour, minute);
    }
}
