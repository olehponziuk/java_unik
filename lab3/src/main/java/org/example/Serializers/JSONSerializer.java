package org.example.Serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.example.Interfaces.ISerializable;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONSerializer<T> implements ISerializable<T> {
    private final Class<T> clazz;
    private final ObjectMapper objectMapper;

    public JSONSerializer(Class<T> clazz) {
        this.clazz = clazz;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }


    @Override
    public String serialize(T obj) throws IOException {
        return objectMapper.writeValueAsString(obj);
    }

    @Override
    public String serialize(List<T> objs) throws IOException {
        return objectMapper.writeValueAsString(objs);
    }

    @Override
    public T deserialize(String string) throws IOException {
        return objectMapper.readValue(string, clazz);
    }

    @Override
    public List<T> deserializeList(String string) throws IOException {
        return objectMapper.readValue(string, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    @Override
    public void writeToFile(T object, String fileName) throws IOException {
        objectMapper.writeValue(new File(fileName), object);
    }

    @Override
    public void writeToFile(List<T> objects, String fileName) throws IOException {
        objectMapper.writeValue(new File(fileName), objects);
    }

    @Override
    public List<T> readFromFile(String fileName) throws IOException {
        return objectMapper.readValue(new File(fileName), objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}
