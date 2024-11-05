package Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Orders extends Base {

    private LocalDateTime date;
    private Restaurant restaurant;
    private double value;
    private double deliveryFee;
    private Promotion promotion;
    private ArrayList<StatusDelivery> statusDelivery;
    private PaymentMethod paymentMethod;
    private String observation;
    private double change;
    private Address address;

    public Orders(LocalDateTime date, Restaurant restaurant, double value, double deliveryFee, Promotion promotion, ArrayList<StatusDelivery> statusDelivery, PaymentMethod paymentMethod, String observation, double change, Address address) {

        this.date = date;
        this.restaurant = restaurant;
        this.value = value;
        this.deliveryFee = deliveryFee;
        this.promotion = promotion;
        this.statusDelivery = statusDelivery;
        this.paymentMethod = paymentMethod;
        this.observation = observation;
        this.change = change;
        this.address = address;
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
}
