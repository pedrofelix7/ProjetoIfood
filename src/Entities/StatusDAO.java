package Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatusDAO {

    public static void main(String[] args) {
        StatusDAO statusDAO = new StatusDAO();
        StatusDelivery newStatus = new StatusDelivery();

        newStatus.setName("Produção");
        statusDAO.createStatus(newStatus);
        newStatus.setName("Saiu para entrega");
        statusDAO.createStatus(newStatus);
//        newStatus.setName("Entregue");
//        statusDAO.createStatus(newStatus);
    }
    private final DatabaseManager dbManager = new MySQLDatabaseManager();

    public void createStatus(StatusDelivery statusDelivery){

        String sql = "INSERT INTO status_delivery(name) VALUES (?)";

        try {
            Connection connection = dbManager.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, statusDelivery.getName());
            ps.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("erro ao inserir status", e);
        }
    }
}
