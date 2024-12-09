package Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class orderDAO {
    public static void main(String[] args) {

    }

    private Connection connection;
    public orderDAO(){
        this.connection = connection;
    }
    private final DatabaseManager dbManager = new MySQLDatabaseManager();

    public void create(Orders orders, Restaurant restaurant, ArrayList<Products> products, StatusDelivery statusDelivery, PaymentMethod paymentMethod, Address address) {
       String sql = "INSERT INTO orders (restaurant_id, value, payment_method_id, address_id) VALUES (?, ?, ?, ?)";
        try {

            double totalValue = 0.0;
            for (Products product : products) {
                totalValue+= product.getPrice();
            }

            Connection connection = dbManager.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, restaurant.getId());
            ps.setDouble(2, totalValue);
            ps.setLong(4, paymentMethod.getId());
            ps.setLong(5,address.getId());
            ps.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Erro ao inserir pedido", e);
        }
    }

    private void addProductsToOrder(long orderId, ArrayList<Products> products, Connection connection) throws SQLException {
        String sql = "INSERT INTO order_product (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Products product : products) {
                ps.setLong(1, orderId); // Associa o produto ao pedido
                ps.setLong(2, product.getId()); // ID do produto
                ps.setInt(3, 1); // Quantidade do produto (pode ser alterado para permitir múltiplas quantidades)
                ps.setDouble(4, product.getPrice()); // Preço do produto
                ps.addBatch(); // Adiciona à batch de inserções
            }
            ps.executeBatch(); // Executa todas as inserções de uma vez
        }
    }


}
