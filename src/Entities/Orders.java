package Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Orders extends Base {

    private static long orderCounter = 1;
    private static long orderNumber;

    private long id;
    private static LocalDateTime date;
    private static Restaurant restaurant;
    private static double totalValue;
    private static double deliveryFee;
    private static Promotion promotion;
    private static ArrayList<StatusDelivery> statusDelivery;
    private static PaymentMethod paymentMethod;
    private static String observation;
    private static double change;
    private static Address address;



    public Orders() {

        this.id = id;
        this.date = date;
        this.totalValue = totalValue;
        this.deliveryFee = deliveryFee;
        this.promotion = promotion;
        this.statusDelivery = statusDelivery;
        this.paymentMethod = paymentMethod;
        this.observation = observation;
        this.change = change;
        this.address = address;
        this.orderNumber = orderCounter++;
    }

    public static long getOrderCounter() {
        return orderCounter;
    }

    public static void setOrderCounter(long orderCounter) {
        Orders.orderCounter = orderCounter;
    }

    public static void setOrderNumber(long orderNumber) {
        Orders.orderNumber = orderNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static double getTotalValue() {
        return totalValue;
    }

    public static void setTotalValue(double totalValue) {
        Orders.totalValue = totalValue;
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
        return totalValue;
    }

    public void setValue(double totalValue) {
        this.totalValue = totalValue;
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

    public void setPaymentMethod(ArrayList<PaymentMethod> paymentMethods) {
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

}
