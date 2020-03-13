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

    public static Object createMoodAnalyser(Constructor<?> constructor, Object... message) throws MoodAnalysisException {
        try {
            return constructor.newInstance(message);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, e.getMessage());
        } catch (InstantiationException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE, e.getMessage());
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE, e.getMessage());
        }
    }

    public static Object invokeMethod(Object myObject, String methodName) throws MoodAnalysisException {
        try {
            return MoodAnalyser.class.getMethod(methodName).invoke(myObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, e.getMessage());
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE, e.getMessage());
        }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            if (fieldValue == null)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "Field value set to null");
            MoodAnalyser.class.getDeclaredField(fieldName).set(myObject, fieldValue);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, e.getMessage());
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, e.getMessage());
        }
    }
}