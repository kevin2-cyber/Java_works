package com.weblog.analyzer;

import java.util.Calendar;

public class LogEntry implements Comparable<LogEntry> {
    private int[] dataValues;
    private Calendar when;
    private static final int YEAR = 0, MONTH = 1, DAY = 2,
            HOUR = 3, MINUTE = 4;
    private static final int NUMBER_OF_FIELDS = 5;

    public LogEntry(String logline) {
        // The array to store the data for a single line.
        dataValues = new int[NUMBER_OF_FIELDS];
        // Break up the log line.
        LoglineTokenizer tokenizer = new LoglineTokenizer();
        tokenizer.tokenize(logline,dataValues);
        setWhen();
    }

    public LogEntry(int year, int month, int day, int hour, int minute) {
        // The array to store the data for a single line.
        dataValues = new int[NUMBER_OF_FIELDS];
        dataValues[YEAR] = year;
        dataValues[MONTH] = month;
        dataValues[DAY] = day;
        dataValues[HOUR] = hour;
        dataValues[MINUTE] = minute;
        setWhen();
    }

    public int getHour() {
        return dataValues[HOUR];
    }

    public int getMinute() {
        return dataValues[MINUTE];
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for(int value : dataValues) {
            // Prefix a leading zero on single digit numbers.
            if(value < 10) {
                buffer.append('0');
            }
            buffer.append(value);
            buffer.append(' ');
        }
        // Drop any trailing space.
        return buffer.toString().trim();
    }

    public int compareTo(LogEntry otherEntry) {
        // Use the equivalent Calendars comparison method.
        return when.compareTo(otherEntry.getWhen());
    }

    private Calendar getWhen() {
        return when;
    }

    private void setWhen() {
        when = Calendar.getInstance();
        // Adjust from 1-based month and day to 0-based.
        when.set(dataValues[YEAR],
                dataValues[MONTH] - 1, dataValues[DAY] - 1,
                dataValues[HOUR], dataValues[MINUTE]);
    }
}
