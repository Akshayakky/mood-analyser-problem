package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTestCases {
    @Test
    public void givenMessage_WhenSad_ThenReturnSad() {
        MoodAnalyser moodanalyser = new MoodAnalyser("Sad");
        String mood = moodanalyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMessage_WhenValidSad_ThenReturnSad() {
        MoodAnalyser moodanalyser = new MoodAnalyser("I am in Sad Mood");
        String mood = moodanalyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMessage_WhenInvalidSad_ThenReturnSad() {
        MoodAnalyser moodanalyser = new MoodAnalyser("I am in Any Mood");
        String mood = moodanalyser.analyseMood();
        Assert.assertNotEquals("SAD", mood);
    }

    @Test
    public void givenMessage_WhenInvalidMood_ThenReturnErrorMessage() {
        MoodAnalyser moodanalyser = new MoodAnalyser();
        String mood = moodanalyser.analyseMood();
        Assert.assertNotEquals("SAD", mood);
    }
}