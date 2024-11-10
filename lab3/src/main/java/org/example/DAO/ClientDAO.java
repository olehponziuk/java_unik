package org.example.DAO;

import org.example.Interfaces.IDAO;
import org.example.Models.Client;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDAO implements IDAO<Client> {

    @Override
    public List<Client> getAll() throws SQLException {
        List<Client> clients = new ArrayList<>();

        String SELECT_ALL_QUERY =
                "SELECT * "
                +"FROM clients;";

        try (Connection connection = ConnectionManager.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(SELECT_ALL_QUERY);
            while (res.next()) {
                clients.add(mapToClient(res));
            }
        }

        return clients;
    }

    @Override
    public Optional<Client> getById(int id) throws SQLException {
        String SELECT_QUERY = " SELECT * "+
                "FROM clients "
                +"WHERE id = ?;";

        try (Connection connection = ConnectionManager.getConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_QUERY)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Client user = mapToClient(rs);
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    @Override
    public boolean create(Client client) throws SQLException {
        String INSERT_QUERY =
                "INSERT INTO clients (first_name, last_name, birth_date, vip_pass)"+
                " VALUES (?, ?, ?, ?)"
                +" RETURNING id;";

        try (Connection connection = ConnectionManager.getConnection(); PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {


            ps.setString(1, client.getFirstName());
            ps.setString(2,client.getLastName());
            ps.setDate(3, Date.valueOf(client.getBirthDate()));
            ps.setBoolean(4, client.isVipPass());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                client.setId(rs.getInt("id"));
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean update(Client client) throws SQLException {
        String UPDATE_QUERY =
                "UPDATE clients "
                +"SET first_Name = ?, last_Name = ?, email = ?, birth_date = ?, vip_pass = ? "
                +"WHERE id = ?;";

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getEmail());
            ps.setDate(4, Date.valueOf(client.getBirthDate()));
            ps.setBoolean(5, client.getVipPass());
            ps.setInt(6, client.getId());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Client client) throws SQLException {
        String DELETE_QUERY = " DELETE FROM Clients" +
               " WHERE id = ?;";

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, client.getId());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }


    private Client mapToClient(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        Date birthDate = rs.getDate("birth_date");
        boolean vipPass = rs.getBoolean("vip_pass");
        int visitId = rs.getInt("id");
        Client newClient = new Client(id, firstName, lastName, birthDate.toLocalDate(),  vipPass);
        newClient.setId(id);
        return newClient;
    }
}
