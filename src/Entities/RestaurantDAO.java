package Entities;

import java.sql.*;
import java.util.ArrayList;

public class RestaurantDAO {
    private final DatabaseManager dbManager = new MySQLDatabaseManager();

    public void create(Restaurant restaurant){
        String sql = " INSERT INTO restaurant (name, telephone) VALUES (?, ?)";

        try(Connection connection = dbManager.openConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getTelephone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir restaurante", e);
        }
    }

    public ArrayList<Restaurant> readAll(){
        String sql = "SELECT * FROM restaurant";
        ArrayList<Restaurant> restaurantes = new ArrayList<>();

        try(Connection connection = dbManager.openConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Restaurant restaurants = new Restaurant();
                restaurants.setId(rs.getLong("id_restaurant"));
                restaurants.setName(rs.getString("name"));
                restaurants.setTelephone(rs.getString("telephone"));
                restaurantes.add(restaurants);
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar restaurantes", e);
        }
        return restaurantes;
    }

    public void update(Restaurant restaurant){
        String sql = "UPDATE restaurant SET name = ?, telephone = ? WHERE id_restaurant = ?";

        try(Connection connection = dbManager.openConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getTelephone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar restaurante", e);
        }
    }

    public ArrayList<Restaurant> delete(long id){
        String sql = "DELETE FROM restaurant WHERE id_restaurant = ?";

        try(Connection connection = dbManager.openConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar restaurante", e);
        }
        return null;
    }
}
