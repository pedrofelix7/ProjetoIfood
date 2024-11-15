package Entities;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Restaurant> names = new ArrayList<Restaurant>();
//        Restaurant rest = new Restaurant("Cantana", "87 97400-6757");
//        names.add(rest);
//
//        Category category = new Category("Bebida", "Coca", "500ML");
//
//        ArrayList<Products> products = new ArrayList<Products>();
//
//        Products prod = new Products("Coca", "500Ml", 7, category, rest);

//        ArrayList<StatusDelivery> statusDelivery = new ArrayList<StatusDelivery>();
//        StatusDelivery stats = new StatusDelivery();
//        statusDelivery.add(stats);

//        ArrayList<PaymentMethod> paymentMethod = new ArrayList<PaymentMethod>();
//        PaymentMethod paymentMethod1 = new PaymentMethod("Pix");
//       paymentMethod.add(paymentMethod1);
//       PaymentMethod paymentMethod2 = new PaymentMethod("cartão de crédito");
//
//
//
//        LocalDateTime orderDate = LocalDateTime.of(2023, 11, 13, 14, 30);
//        Address address = new Address("Rua João Martins dos Santos", "Centro", "Arcoverde", "Pernambuco", 22, "Casa", "Segunda rua a esquerda depois da padaria", "55600-000");
//
//
//        Orders order1 = new Orders(orderDate, rest, 59.90, 5.0, "Não tem observação", address);
//        Orders order2 = new Orders(orderDate, rest, 39.90, 5.0, "Não tem observação", address);
//
//        System.out.println(order1.toString());
//        System.out.println(order2.toString());
        Restaurant restaurant = new Restaurant();

        Orders orders = new Orders();


        try{
           restaurant.selectRest();
           orders.selectFood();
           orders.selectDrink();
           orders.selectFollowUp();
           orders.showCart();
        }catch (InputMismatchException exception){
            System.out.println("Erro ao ler o que o usuário digitou, por favor selecione uma opção válida!" + exception.getMessage());
        }
        catch (NumberFormatException exception){
            System.out.println("Erro ao processar o pedido: valor inválido!");
        } catch (IllegalArgumentException exception){
            System.out.println("Erro: " + exception.getMessage());
        }
    }
}