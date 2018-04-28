package com.vijeth.serialization;

import java.io.*;

public class SerializationUtil {

    public static void serialize(Object object, File file) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(file); BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
            objectOutputStream.writeObject(object);
        }
    }

    public static Object deserialize(File file) throws IOException, ClassNotFoundException {
        try(FileInputStream fileInputStream = new FileInputStream(file); BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)){
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            return objectInputStream.readObject();
        }
    }

}
