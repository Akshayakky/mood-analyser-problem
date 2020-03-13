package com.moodanalyser;

import java.util.Objects;

public class MoodAnalyser {

    public String message;

    public MoodAnalyser() {

    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Mood Analyser Problem");
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length() == 0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, "Empty Mood. Please enter proper mood");

            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "Null Mood. Please enter proper mood");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}