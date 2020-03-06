package com.moodanalyser;

public class MoodAnalyser {

    private String message;

    public MoodAnalyser() {

    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Mood Analyser Problem");
    }

    public String analyseMood() {
        try {
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "HAPPY";
        }
    }
}