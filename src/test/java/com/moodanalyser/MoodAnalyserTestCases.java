package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTestCases {
    String mood = null;
    MoodAnalysisException.ExceptionType exception = null;

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

    //Test Case 3.1
    @Test
    public void givenMessage_WhenNullMessage_ShouldThrowException() {
        MoodAnalyser moodanalyser = new MoodAnalyser();
        try {
            mood = moodanalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            exception = e.type;
        }
        Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, exception);
    }

    //Test Case 3.2
    @Test
    public void givenMessage_WhenEmptyMessage_ShouldThrowException() {
        MoodAnalyser moodanalyser = new MoodAnalyser("");
        try {
            mood = moodanalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            exception = e.type;
        }
        Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, exception);
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        Object myObject = null;
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("com.moodanalyser.MoodAnalyser", String.class);
            myObject = MoodAnalyserFactory.createMoodAnalyser(constructor, "I am in Happy Mood");
        } catch (MoodAnalysisException e) {
            exception = e.type;
        }
        Assert.assertEquals(new MoodAnalyser("I am in Happy Mood"), myObject);
    }

    @Test
    public void givenMoodAnalyserClass_WhenClassImproper_ShouldThrowException() {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("com.moodanalyser.InvalidClassName", String.class);
        } catch (MoodAnalysisException e) {
            exception = e.type;
        }
        Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, exception);
    }

    @Test
    public void givenMoodAnalyserClass_WhenConstructorImproper_ShouldThrowException() {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("com.moodanalyser.MoodAnalyser", String.class, Integer.class);
        } catch (MoodAnalysisException e) {
            exception = e.type;
        }
        Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, exception);
    }
}