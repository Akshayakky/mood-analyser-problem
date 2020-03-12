package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTestCases {
    String mood = null;

    @Test
    public void givenMessage_WhenSad_ThenReturnSad() {
        MoodAnalyser moodanalyser = new MoodAnalyser("Sad");
        try {
            mood = moodanalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMessage_WhenValidSad_ThenReturnSad() {
        MoodAnalyser moodanalyser = new MoodAnalyser("I am in Sad Mood");
        try {
            mood = moodanalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMessage_WhenInvalidSad_ThenReturnHappy() {
        MoodAnalyser moodanalyser = new MoodAnalyser("I am in happy mood");
        try {
            mood = moodanalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertNotEquals("SAD", mood);
    }

    @Test
    public void givenMessage_WhenNullMessage_ShouldThrowException() {
        MoodAnalyser moodanalyser = new MoodAnalyser();
        String mood = null;
        try {
            moodanalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenMessage_WhenEmptyMessage_ShouldThrowException() {
        MoodAnalyser moodanalyser = new MoodAnalyser("");
        String mood = null;
        try {
            moodanalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }
}