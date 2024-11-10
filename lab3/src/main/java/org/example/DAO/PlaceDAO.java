package org.example.DAO;

import org.example.Models.Place;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaceDAO {
    public List<Place> getAll() throws SQLException {
        List<Place> places = new ArrayList<>();
        String SELECT_ALL_QUERY = "SELECT * FROM places;";

        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(SELECT_ALL_QUERY);
            while (res.next()) {
                Place place = mapToPlace(res);
                places.add(place);
            }
        }
        return places;
    }

    public Optional<Place> getById(int id) throws SQLException {
        String SELECT_QUERY = "SELECT * FROM places WHERE id = ?;";

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_QUERY)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Place place = mapToPlace(rs);
                return Optional.of(place);
            }
        }
        return Optional.empty();
    }

    public boolean create(Place place) throws SQLException {
        String INSERT_QUERY = "INSERT INTO places (name, age_limit, country, city) " +
                "VALUES (?, ?, ?, ?) RETURNING id;";

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {
            ps.setString(1, place.getName());
            ps.setInt(2, place.getAgeLimit());
            ps.setString(3, place.getCountry());
            ps.setString(4, place.getCity());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        return false;
    }

    public boolean update(Place place, int id) throws SQLException {
        String UPDATE_QUERY = "UPDATE places SET name = ?, age_limit = ?, country = ?, city = ? WHERE id = ?;";

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, place.getName());
            ps.setInt(2, place.getAgeLimit());
            ps.setString(3, place.getCountry());
            ps.setString(4, place.getCity());
            ps.setInt(5, id);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String DELETE_QUERY = "DELETE FROM places WHERE id = ?;";

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    private Place mapToPlace(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        int ageLimit = rs.getInt("age_limit");
        String country = rs.getString("country");
        String city = rs.getString("city");

        return new Place(name, ageLimit, country, city);
    }
}

