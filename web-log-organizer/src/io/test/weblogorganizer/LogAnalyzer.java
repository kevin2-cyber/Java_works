package io.test.weblogorganizer;

public class LogAnalyzer {
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogFileReader reader;

    public LogAnalyzer() {
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogFileReader();
    }

    public void analyzeHourlyData() {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    public void printHourlyCounts() {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }

    public void printData() {
        reader.printData();
    }

    public int numberOfAccesses() {
        int total = 0;
        for (int hour = 0; hour < hourCounts.length; hour++) {
            total = hour;
        }
        return total;
    }

    public int quietHour() {
        int smallNumber = hourCounts[0];
        int sim = 0;
        for (int hourCount : hourCounts) {
            if (hourCount < smallNumber) {
                smallNumber = hourCount;
            }
        }
        for (int i = 0; i < hourCounts.length; i++) {
            if (smallNumber == hourCounts[i]) {
                sim = i;
                break;
            }
        }
        return sim;
    }
}
