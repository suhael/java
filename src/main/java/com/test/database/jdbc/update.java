package com.test.database.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Created by Home on 21/06/2015.
 */
public class update {
    // JDBC driver name and database URL
    static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_CONNECTION = "jdbc:mysql://localhost/test";

    //  Database credentials
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "";

    public static final String PPUK = "PP";
    public static final String PPIE = "PPIE";

    public static void main(String[] argv) {

        try {

            copyCurrentToInterimTable();
            updateInterimTable();
            updateMappingTable();
            truncateInterimTable();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private static void copyCurrentToInterimTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

//        String updateTableSQL = "UPDATE DBUSER SET USERNAME = ? "
//                + " WHERE USER_ID = ?";

        StringBuilder statement = new StringBuilder();
        statement.append("INSERT INTO SERVICE_DCL.agentSiteLocationMappingInterim ");
        statement.append("(agentSiteId,externalId, externalType,");
        statement.append("lastUpdated) ");
        statement.append("SELECT agentSiteId,externalId, externalType,");
        statement.append("NOW() as lastUpdated ");
        statement.append("FROM SERVICE_DCL.agentSiteLocationMapping ");
        statement.append("WHERE agentSiteLocationMapping.externalType != ? AND agentSiteLocationMapping.externalType != ?;");

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(statement.toString());
            int i=1;
            preparedStatement.setString(i++, PPUK);
            preparedStatement.setString(i++, PPIE);

            // execute update SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Executed query " + statement.toString());

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static void updateInterimTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

//        String updateTableSQL = "UPDATE DBUSER SET USERNAME = ? "
//                + " WHERE USER_ID = ?";

        StringBuilder statement = new StringBuilder();
        statement.append("INSERT IGNORE INTO SERVICE_DCL.agentSiteLocationMappingInterim ");
        statement.append("(agentSiteId,externalId, externalType,");
        statement.append("lastUpdated) ");
        statement.append("SELECT id,id,");
        statement.append("IF(agentSite.isoCode = ?,?,?) as externalType,");
        statement.append("NOW() as lastUpdated ");
        statement.append("FROM SERVICE_DCL.agentSite;");

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(statement.toString());
            int i=1;
            preparedStatement.setString(i++, "IE");
            preparedStatement.setString(i++, PPIE);
            preparedStatement.setString(i++, PPUK);

            // execute update SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Executed query " + statement.toString());

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static void updateMappingTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

//        String updateTableSQL = "UPDATE DBUSER SET USERNAME = ? "
//                + " WHERE USER_ID = ?";

        StringBuilder statement = new StringBuilder();
        statement.append("INSERT INTO SERVICE_DCL.agentSiteLocationMapping ");
        statement.append("(agentSiteId, externalId, externalType, ");
        statement.append("lastUpdated) ");
        statement.append("SELECT agentSiteLocationMappingInterim.agentSiteId, agentSiteLocationMappingInterim.externalId, ");
        statement.append("agentSiteLocationMappingInterim.externalType, ");
        statement.append("agentSiteLocationMappingInterim.lastUpdated ");
        statement.append("FROM SERVICE_DCL.agentSiteLocationMappingInterim ");
        statement.append("ON DUPLICATE KEY UPDATE ");
        statement.append("agentSiteLocationMapping.externalId = agentSiteLocationMappingInterim.externalId, ");
        statement.append("agentSiteLocationMapping.externalType = agentSiteLocationMappingInterim.externalType, ");
        statement.append("agentSiteLocationMapping.lastUpdated = agentSiteLocationMappingInterim.lastUpdated;");

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(statement.toString());

            // execute update SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Executed query " + statement.toString());

        } catch (SQLException e) {

            System.out.println(statement.toString());
            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static void truncateInterimTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

//        String updateTableSQL = "UPDATE DBUSER SET USERNAME = ? "
//                + " WHERE USER_ID = ?";

        StringBuilder statement = new StringBuilder();
        statement.append("TRUNCATE SERVICE_DCL.agentSiteLocationMappingInterim;");

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(statement.toString());

            // execute update SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Executed query " + statement.toString());

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
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
