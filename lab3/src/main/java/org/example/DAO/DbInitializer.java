package org.example.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInitializer {
    private static final String CREATE_TABLE_CLIENT = "CREATE TABLE clients ("
            + "id SERIAL PRIMARY KEY, "
            + "first_name VARCHAR(45) NOT NULL CHECK (length(first_name) >= 2), "
            + "last_name VARCHAR(45), "
            + "birth_date DATE, "
            + "email VARCHAR(255), "
            + "vip_pass BOOLEAN"
            + ");";

    private static final String CREATE_TABLE_PLACE = "CREATE TABLE IF NOT EXISTS places ("
            + "id SERIAL PRIMARY KEY, "
            + "name VARCHAR(255) NOT NULL, "
            + "age_limit INT CHECK (age_limit >= 3), "
            + "country VARCHAR(255) NOT NULL, "
            + "city VARCHAR(255) NOT NULL"
            + ");";

    private static final String CREATE_TABLE_VISIT = "CREATE TABLE IF NOT EXISTS visits ("
            + "id SERIAL PRIMARY KEY, "
            + "price NUMERIC(10, 2), "
            + "transport VARCHAR(255), "
            + "start_date DATE, "
            + "end_date DATE, "
            + "place_id INTEGER, "
            + "FOREIGN KEY (place_id) REFERENCES places(id)"
            + ");";

    private static final String CREATE_TABLE_GROUP = "CREATE TABLE IF NOT EXISTS groups ("
            + "id SERIAL PRIMARY KEY, "
            + "client_id INTEGER NOT NULL, "
            + "visit_id INTEGER NOT NULL, "
            + "FOREIGN KEY (client_id) REFERENCES clients(id), "
            + "FOREIGN KEY (visit_id) REFERENCES visits(id)"
            + ");";

    public static void createTables() {
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE_CLIENT);
            statement.execute(CREATE_TABLE_PLACE);
            statement.execute(CREATE_TABLE_VISIT);
            statement.execute(CREATE_TABLE_GROUP);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
