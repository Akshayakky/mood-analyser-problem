package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTestCases {
    @Test
    public void givenMessage_WhenSad_ThenReturnSad() {
        MoodAnalyser moodanalyser = new MoodAnalyser();
        String mood = moodanalyser.analyseMood("Sad");
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMessage_WhenContainsSad_ThenReturnSad() {
        MoodAnalyser moodanalyser = new MoodAnalyser();
        String mood = moodanalyser.analyseMood("I am in Sad Mood");
        Assert.assertEquals("SAD", mood);
    }
}