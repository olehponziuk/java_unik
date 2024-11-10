package org.example.DAO;

import org.example.Interfaces.IDAO;
import org.example.Models.Visit;
import org.example.Models.Place;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VisitDAO implements IDAO<Visit> {
    @Override
    public boolean create(Visit visit) throws SQLException {
        String INSERT_QUERY = "INSERT INTO visits (price, transport, start_date, end_date, place_id) VALUES (?, ?, ?, ?, ?) RETURNING id;";
        try (Connection connection = ConnectionManager.getConnection(); PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {
            ps.setDouble(1, visit.getPrice());
            ps.setString(2, visit.getTransport());
            ps.setDate(3, Date.valueOf(visit.getStartDate()));
            ps.setDate(4, Date.valueOf(visit.getLastDate()));
            ps.setInt(5, visit.getPlace().getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                visit.setId(rs.getInt("id"));
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Visit> getAll() throws SQLException {
        List<Visit> visits = new ArrayList<>();
        String SELECT_ALL_QUERY = "SELECT * FROM visits;";
        try (Connection connection = ConnectionManager.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(SELECT_ALL_QUERY);
            while (res.next()) {
                visits.add(mapToVisit(res));
            }
        }
        return visits;
    }

    @Override
    public Optional<Visit> getById(int id) throws SQLException {
        String SELECT_QUERY = "SELECT * FROM visits WHERE id = ?;";
        try (Connection connection = ConnectionManager.getConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_QUERY)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapToVisit(rs));
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean update(Visit visit) throws SQLException {
        String UPDATE_QUERY = "UPDATE visits SET price = ?, transport = ?, start_date = ?, end_date = ?, place_id = ? WHERE id = ?;";
        try (Connection connection = ConnectionManager.getConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setDouble(1, visit.getPrice());
            ps.setString(2, visit.getTransport());
            ps.setDate(3, Date.valueOf(visit.getStartDate()));
            ps.setDate(4, Date.valueOf(visit.getLastDate()));
            ps.setInt(5, visit.getPlace().getId());
            ps.setInt(6, visit.getId());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Visit visit) throws SQLException {
        String DELETE_QUERY = "DELETE FROM visits WHERE id = ?;";
        try (Connection connection = ConnectionManager.getConnection(); PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, visit.getId());
            return ps.executeUpdate() > 0;
        }
    }

    private Visit mapToVisit(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        double price = rs.getDouble("price");
        String transport = rs.getString("transport");
        LocalDate startDate = rs.getDate("start_date").toLocalDate();
        LocalDate endDate = rs.getDate("end_date").toLocalDate();
        Place place = new PlaceDAO().getById(rs.getInt("place_id")).orElse(null);  // Assuming PlaceDAO exists
        Visit visit = new Visit.VisitBuilder()
                .addPrice(price)
                .addTransport(transport)
                .addFirstDate(startDate)
                .addLastDate(endDate)
                .addPlace(place)
                .build();
        return visit;
    }
}
