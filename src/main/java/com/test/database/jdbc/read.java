package com.test.database.jdbc;


import java.sql.*;

/**
 * Created by Home on 21/06/2015.
 */
public class read {
    // JDBC driver name and database URL
    static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_CONNECTION = "jdbc:mysql://ukndchvm-dev-oltp01.dev.nd.lnet/netdespatch";

    //  Database credentials
    static final String DB_USER = "devteam";
    static final String DB_PASSWORD = "d3vt3@m";

    public static void main(String[] argv) {

        try {

            updateMappingTable();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }


    private static void updateMappingTable() throws SQLException {

        Connection dbConnection = null;
        Statement statement = null;


        String test = "SELECT featureId, active FROM netdespatch.featureActivation WHERE featureActivation.featureId = 25";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // execute update SQL stetement
            ResultSet rs = statement.executeQuery(test);

            System.out.println("Executed query " + test);

            while (rs.next()) {

                String feature = rs.getString("featureId");
                String active = rs.getString("active");

                System.out.println("feature : " + feature);
                System.out.println("active : " + active);

            }

        } catch (SQLException e) {

            System.out.println(test);
            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
}
