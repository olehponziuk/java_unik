package org.example.Serializers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.Interfaces.ISerializable;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLSerializer<T> implements ISerializable<T> {
    private final XmlMapper xmlMapper;
    private final Class<T> clazz;
    public XMLSerializer(Class<T> clazz) {
        this.clazz = clazz;
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.registerModule(new JavaTimeModule());
    }
    @Override
    public String serialize(T obj) throws IOException {
        return xmlMapper.writeValueAsString(obj);
    }

    @Override
    public String serialize(List<T> objs) throws IOException {
        return xmlMapper.writeValueAsString(objs);
    }

    @Override
    public T deserialize(String string) throws IOException {
        return xmlMapper.readValue(string, clazz);
    }

    @Override
    public List<T> deserializeList(String string) throws IOException {
        return xmlMapper.readValue(string, xmlMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    @Override
    public void writeToFile(T object, String fileName) throws IOException {
        xmlMapper.writeValue(new File(fileName), object);
    }

    @Override
    public void writeToFile(List<T> objects, String fileName) throws IOException {
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), objects);
    }

    @Override
    public List<T> readFromFile(String fileName) throws IOException {
        return xmlMapper.readValue(new File(fileName), xmlMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}
