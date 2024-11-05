package Entities;

import java.util.ArrayList;

public class RestaurantPayment {

    private ArrayList<Restaurant> restaurant;
    private PaymentMethod paymentMethod;

    public RestaurantPayment(ArrayList<Restaurant> restaurant, PaymentMethod paymentMethod) {
        this.restaurant = restaurant;
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(ArrayList<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
