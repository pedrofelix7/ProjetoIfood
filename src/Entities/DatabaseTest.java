package Entities;

import java.sql.Connection;

public class DatabaseTest {
    public static void main(String[] args) {
        DatabaseManager dbManager = new MySQLDatabaseManager();
        Connection connection = null;

        try {
            connection = dbManager.openConnection();
            System.out.println("Conexão bem sucedida com o banco de dados!");
        } catch (RuntimeException e){
            System.err.println("Erro na conexão: " + e.getMessage());
            e.printStackTrace();
        } finally {
            dbManager.closeConnection(connection);
        }
    }
}