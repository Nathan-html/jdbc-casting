package fr.hb.casting_agency.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {

    // I add a singleton because the project is little and don't need many user
    private static Connection connection = null;

    public final static Connection getInstance() throws SQLException {

        if (connection == null) {

            synchronized (Connection.class) {
                if (connection == null) {
                    connection = connection();
                }
            }
        }
        return connection;
    }

    private static Connection connection() throws SQLException {
        ApplicationProperties properties = new ApplicationProperties();
        String url = properties.readProperty("db.url");
        String user = properties.readProperty("db.user");
        String password = properties.readProperty("db.password");

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    };

    public static void closeInstance() throws SQLException {
//        connection.close();
        connection = null;
    }
}