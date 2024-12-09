package Entities;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {
    private final DatabaseManager dbManager = new MySQLDatabaseManager();

    public void create(Products products){
        String sql = "INSERT INTO product (name, description, price, category_id, restaurant_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dbManager.openConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, products.getName());
            ps.setString(2, products.getDescription());
            ps.setDouble(3, products.getPrice());
            ps.setInt(4, products.getCategory());
            ps.setInt(5, products.getRestaurant());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir produto", e);
        }
    }

    public ArrayList<Products> readAll(){
        String sql = "SELECT * FROM product";
        ArrayList<Products> product = new ArrayList<>();

        try(Connection connection = dbManager.openConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()){
                Products products = new Products();
                products.setId(rs.getLong("id_product"));
                products.setName(rs.getString("name"));
                products.setPrice(rs.getDouble("price"));
                products.setDescription(rs.getString("description"));
                products.setCategory(rs.getInt("category_id"));
                products.setRestaurant(rs.getInt("restaurant_id"));
                product.add(products);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os produtos", e);
        }
        return product;
    }

    public void update(Products products){
        String sql = "UPDATE product SET name = ?, price = ?, category_id = ?, restaurant_id = ? WHERE id_product == ?";

        try(Connection connection = dbManager.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, products.getName());
            ps.setDouble(2, products.getPrice());
            ps.setString(3, products.getDescription());
            ps.setInt(4, products.getCategory());
            ps.setInt(5, products.getRestaurant());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto", e);
        }
    }

    public void delete(long id){
        String sql = "DELETE FROM product WHERE id_product = ?";

        try(Connection connection = dbManager.openConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Erro ao deletar produto", e);
        }
    }

    public ArrayList<Products> getRest(long restaurantID){
        ArrayList<Products> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE restaurant_id = ?";

        try(Connection connection = dbManager.openConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, restaurantID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Products product = new Products();
                product.setId(rs.getLong("id_product"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(rs.getInt("category_id"));
                product.setRestaurant(rs.getInt("restaurant_id"));
                products.add(product);
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao mostrar produto do restaurante selecionado!");
        }
        return products;
    }
}

