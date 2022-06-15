package com.geekbrains;

import com.google.gson.Gson;

import java.util.Date;

public class SerializeExampleJson {

    private static final Gson gson = new Gson();

    public static <T> String getJson(T object) {
        return gson.toJson(object);
    }

    private static <T> T getObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static void main(String[] args) {
        Message message = Message.builder()
                .createdAt(new Date())
                .author("Mike")
                .text("Message text")
                .build();

        String json = getJson(message);
        System.out.println(json);
        System.out.println(getObject(json, Message.class));
    }

}
