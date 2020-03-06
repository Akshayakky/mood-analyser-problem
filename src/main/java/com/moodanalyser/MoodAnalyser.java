package com.moodanalyser;

public class MoodAnalyser {
    public static void main(String[] args) {
        System.out.println("Welcome To Mood Analyser Problem");
    }

    public String analyseMood(String message) {
        if (message.contains("Sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}