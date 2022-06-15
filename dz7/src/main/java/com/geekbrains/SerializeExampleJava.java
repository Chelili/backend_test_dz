package com.geekbrains;

import java.io.*;
import java.util.Date;

public class SerializeExampleJava {

    private static void serializeMessage() {
        Message message = Message.builder()
                .createdAt(new Date())
                .author("Mike")
                .text("Message text")
                .build();
        try (ObjectOutputStream os = new ObjectOutputStream(
                new FileOutputStream(new File("user.obj")))) {
            os.writeObject(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void deserializeMessage() {

        Message message = null;

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("data/user.obj"))){
            message = (Message) is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(message);
    }


    public static void main(String[] args) {
        deserializeMessage();
    }
}
