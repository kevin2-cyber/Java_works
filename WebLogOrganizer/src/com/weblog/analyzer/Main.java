package com.weblog.analyzer;

public class Main {
    public static void main(String[] args) {
    LogAnalyzer logAnalyzer = new LogAnalyzer();
    logAnalyzer.numberOfAccesses();
    logAnalyzer.printData();
    logAnalyzer.printHourlyCounts();
    logAnalyzer.quietHour();
    logAnalyzer.analyzeHourlyData();
    }
}
