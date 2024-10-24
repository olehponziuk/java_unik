package org.example.Interfaces;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ISerializable<T> {
    String serialize(T obj) throws IOException;
    String serialize(List<T> objs) throws IOException;
    T deserialize(String string) throws IOException;
    List<T> deserializeList(String string) throws IOException;

    void writeToFile(T object, String fileName) throws IOException;
    void writeToFile(List<T> objects, String fileName) throws IOException;

    List<T> readFromFile(String fileName) throws IOException;
}
