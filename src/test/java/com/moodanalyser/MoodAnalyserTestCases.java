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

    //WHEN MESSAGE CONTAINS SAD THEN RETURN EXPECTED : SAD
    @Test
    public void givenMessage_WhenValidSad_ThenReturnSad() {
        MoodAnalyser moodanalyser = new MoodAnalyser("I am in Sad Mood");
        String mood = moodanalyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }

    //WHEN MESSAGE DOES NOT CONTAIN SAD THEN RETURN EXPECTED : HAPPY
    @Test
    public void givenMessage_WhenInvalidSad_ThenReturnSad() {
        MoodAnalyser moodanalyser = new MoodAnalyser("I am in Any Mood");
        String mood = moodanalyser.analyseMood();
        Assert.assertNotEquals("SAD", mood);
    }

    //HANDLING NULL MOOD : RETURN HAPPY WHEN MESSAGE IS NULL
    @Test
    public void givenMessage_WhenInvalidMood_ThenReturnHappy() {
        MoodAnalyser moodanalyser = new MoodAnalyser();
        String mood = moodanalyser.analyseMood();
        Assert.assertNotEquals("SAD", mood);
    }
}