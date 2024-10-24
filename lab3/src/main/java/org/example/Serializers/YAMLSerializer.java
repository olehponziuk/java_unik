package org.example.Serializers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.example.Interfaces.ISerializable;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class YAMLSerializer<T> implements ISerializable<T> {
    private final YAMLMapper yamlMapper;
    private final Class<T> clazz;
    public YAMLSerializer(Class<T> tClass, Class<T> clazz) {
        this.clazz = clazz;
        this.yamlMapper = new YAMLMapper();
        this.yamlMapper.registerModule(new JavaTimeModule());
    }
    @Override
    public String serialize(T obj) throws IOException {
        return yamlMapper.writeValueAsString(obj);
    }

    @Override
    public String serialize(List<T> objs) throws IOException {
        return yamlMapper.writeValueAsString(objs);
    }

    @Override
    public T deserialize(String string) throws IOException {
        return yamlMapper.readValue(string, clazz);
    }

    @Override
    public List<T> deserializeList(String string) throws IOException {
        return yamlMapper.readValue(string, yamlMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    @Override
    public void writeToFile(T object, String fileName) throws IOException {
        yamlMapper.writeValue(new File(fileName), object);
    }

    @Override
    public void writeToFile(List<T> objects, String fileName) throws IOException {
        yamlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), objects);
    }

    @Override
    public List<T> readFromFile(String fileName) throws IOException {
        return yamlMapper.readValue(new File(fileName), yamlMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}
