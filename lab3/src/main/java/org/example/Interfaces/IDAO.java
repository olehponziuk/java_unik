package org.example.Interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface IDAO<T> {
    List<T> getAll() throws  SQLException;
    Optional<T> getById(int id) throws SQLException;
    boolean create(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
}