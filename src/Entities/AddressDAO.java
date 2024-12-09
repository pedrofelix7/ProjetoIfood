package Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDAO {
    private final DatabaseManager dbManager = new MySQLDatabaseManager();

    public void create(Address address){
        String sql = "INSERT INTO address (road, neighborhood, city, state, number) VALUES (?, ?, ?, ?, ?)";

        try{
            Connection connection = dbManager.openConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, address.getRoad());
            stmt.setString(2, address.getDistrict());
            stmt.setString(3, address.getCity());
            stmt.setString(4, address.getState());
            stmt.setString(5, address.getNumber());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao inserir cliente", e);
        }
    }
}
