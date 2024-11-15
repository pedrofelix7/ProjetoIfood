package Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Orders extends Base {

    private static long orderCounter = 1;
    private static long orderNumber;

    private static LocalDateTime date;
    private static Restaurant restaurant;
    private static double value;
    private static double deliveryFee;
    private static Promotion promotion;
    private static ArrayList<StatusDelivery> statusDelivery;
    private static PaymentMethod paymentMethod;
    private static String observation;
    private static double change;
    private static Address address;

    private static ArrayList<String> foodSelection = new ArrayList<>();
    private static ArrayList<String> drinkSelection = new ArrayList<>();
    private static ArrayList<String> followUpSelection = new ArrayList<>();

    public Orders() {

//        this.date = date;
//        this.restaurant = restaurant;
//        this.value = value;
//        this.deliveryFee = deliveryFee;
//        this.promotion = promotion;
//        this.statusDelivery = statusDelivery;
//        this.paymentMethod = paymentMethod;
//        this.observation = observation;
//        this.change = change;
//        this.address = address;
//        this.orderNumber = orderCounter++;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public ArrayList<StatusDelivery> getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(ArrayList<StatusDelivery> statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    static Scanner entry = new Scanner(System.in);

//    public String toString() {
//        return "Pedido " + orderNumber + ":" + "\n" +
//                "Data do pedido: " + date + "\n" +
//                "Restaurante: " + this.getRestaurant().getName() + "\n" +
//                "Valor do pedido: " + getValue() + "\n" +
//                "Taxa de entrega: " + getDeliveryFee() + "\n" +
//                "Observação: " + getObservation() + "\n" +
//                "Endereço: " + getAddress();
//    }

    public static void selectFood() {
        System.out.println("Selecione sua comida: ");
        System.out.println("1. Parmegiana de Carne");
        System.out.println("2. Parmegiana de Frango");
        System.out.println("3. Espeto de picanha");
        int choice = entry.nextInt();
        switch (choice) {
            case 1:
                foodSelection.add("Parmegiana de carne");
                System.out.println("Você selecionou: Parmegiana de carne");
                break;
            case 2:
                foodSelection.add("Parmegiana de frango");
                System.out.println("Você selecionou: Parmegiana de frango");
                break;
            case 3:
                foodSelection.add("Espeto de picanha");
                System.out.println("Você selecionou: Espeto de picanha");
                break;
            default:
                throw new IllegalArgumentException("Opção inválida!" + "\n" + "Por favor selecione uma das opções válidas");

        }
    }

    public static void selectDrink() {
        System.out.println("Selecione sua bebida: ");
        System.out.println("1. Coca-Cola Lata");
        System.out.println("2. Coca-Cola Lata Zero");
        System.out.println("3. Guaraná Antártica Lata");
        System.out.println("4. Guaraná Antártica Lata Zero");

        int choice2 = entry.nextInt();
        switch (choice2) {
            case 1:
                drinkSelection.add("Coca-Cola Lata");
                System.out.println("Você selecionou: Coca-Cola Lata");
                break;
            case 2:
                drinkSelection.add("Coca-Cola Lata Zero");
                System.out.println("Você selecionou: Coca-Cola Lata Zero");
                break;
            case 3:
                drinkSelection.add("Guaraná Antártica Lata");
                System.out.println("Você selecionou: Guaraná Antártica Lata");
                break;
            case 4:
                drinkSelection.add("Guaraná Antártica Lata Zero");
                System.out.println("Você selecionou: Guaraná Antártica Lata Zero");
                break;
            default:
                throw new IllegalArgumentException("Opção inválida!" + "\n" + "Por favor selecione uma das opções válidas");
        }
    }

    public static void selectFollowUp() {
        System.out.println("Selecione os acompanhamentos");
        System.out.println("1. Arroz");
        System.out.println("2. Macarrão");
        System.out.println("3. Farofa");
        System.out.println("4. Vinagrete");

        int choice3 = entry.nextInt();
        switch (choice3) {
            case 1:
                followUpSelection.add("Arroz");
                System.out.println("Você selecionou arroz");
                break;
            case 2:
                followUpSelection.add("Macarrão");
                System.out.println("Você selecionou macarrão");
                break;
            case 3:
                followUpSelection.add("Farofa");
                System.out.println("Você selecionou farofa");
                break;
            case 4:
                followUpSelection.add("Vinagrete");
                System.out.println("Você selecionou vinagrete");
                break;
            default:
                throw new IllegalArgumentException("Opção inválida!" + "\n" + "Por favor selecione uma das opções válidas");
        }
    }
    public static void showCart(){
        System.out.println("Carrinho: ");
        System.out.println("Comidas: " + foodSelection);
        System.out.println("Bebidas: " + drinkSelection);
        System.out.println("Acompanhamentos: " + followUpSelection);
    }
}
