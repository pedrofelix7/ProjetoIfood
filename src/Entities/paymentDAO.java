package Entities;

import java.sql.*;
import java.util.ArrayList;

public class paymentDAO {
    private final DatabaseManager dbManager = new MySQLDatabaseManager();

    public ArrayList<PaymentMethod> readAll(){
        String sql = "SELECT * FROM payment_method";
        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();

        try (Connection connection = dbManager.openConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)){
            while (rs.next()){
                PaymentMethod paymentMethod = new PaymentMethod();
                paymentMethod.setId(rs.getLong("id_payment_method"));
                paymentMethod.setPaymentType1(rs.getString("payment_type"));
//                paymentMethod.setPaymentType2(rs.getString("payment_type"));
//                paymentMethod.setPaymentType3(rs.getString("payment_type"));
//                paymentMethod.setPaymentType4(rs.getString("payment_type"));
                paymentMethods.add(paymentMethod);
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao ler os métodos de pagamento!" + e.getMessage());
        }
        return paymentMethods;
    }

    public ArrayList<PaymentMethod> getPayMet(){
        String sql = "SELECT * FROM payment_method WHERE id_payment_method = ?";
        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();

        try (Connection connection = dbManager.openConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql)){
            while (rs.next()){
                PaymentMethod paymentMethod = new PaymentMethod();
                paymentMethod.setId(rs.getLong("id_payment_method"));
                paymentMethod.setPaymentType1(rs.getString("payment_type"));
                paymentMethods.add(paymentMethod);
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao mostrar forma de pagamento selecionado!", e);
        }
        return paymentMethods;
    }
}
