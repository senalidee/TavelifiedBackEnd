package com.cyntex.TourismApp.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONHandler {
    private static ObjectMapper mapper = new ObjectMapper();
    public static String parseToJSON(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static  <T> T parseFromJSON(String jsonMsg, Class<T> clz) throws IOException {
        return mapper.readValue(jsonMsg, clz);
    }
}
