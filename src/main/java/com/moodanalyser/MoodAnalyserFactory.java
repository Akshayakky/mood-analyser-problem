package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static Constructor<?> getConstructor(String className, Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static Object createMoodAnalyser(Constructor<?> constructor, Object... message) {
        try {
            return constructor.newInstance(message);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeMethod(Object myObject, String methodName) throws MoodAnalysisException {
        try {
            return MoodAnalyser.class.getMethod(methodName).invoke(myObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}