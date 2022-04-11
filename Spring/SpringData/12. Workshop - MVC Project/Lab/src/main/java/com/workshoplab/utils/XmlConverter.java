package com.workshoplab.utils;

public interface XmlConverter {

    <T> T deserialize(String input, Class<T> type);

    String serialize(Object o);
}
