package Entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private final DatabaseManager dbManager = new MySQLDatabaseManager();

    public void create(Cliente cliente){
        String sql = "INSERT INTO clientes (name, age, email) VALUES (?, ?, ?)";

        try{
            Connection connection = dbManager.openConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getName());
            stmt.setInt(2, cliente.getAge());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao inserir cliente", e);
        }
    }

    public List<Cliente> readAll(){
        String sql = "SELECT * FROM clientes";
        List<Cliente> clientes = new ArrayList<>();

        try(Connection connection = dbManager.openConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("name"));
                cliente.setAge(rs.getInt("age"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar clientes", e);
        }
        return clientes;
    }

    public void update(Cliente cliente){
        String sql = "UPDATE clientes SET name = ?, idade = ?, email = ? WHERE id == ?";

        try (Connection connection = dbManager.openConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, cliente.getName());
            stmt.setInt(2, cliente.getAge());
            stmt.setString(2, cliente.getEmail());
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar cliente", e);
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM clientes WHERE id = ?";

        try (Connection connection = dbManager.openConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao deletar cliente", e);
        }
    }
}