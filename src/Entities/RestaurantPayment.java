package Entities;

public class RestaurantPayment {

    private Restaurant restaurant;
    private PaymentMethod paymentMethod;

    public RestaurantPayment(Restaurant restaurant, PaymentMethod paymentMethod) {
        this.restaurant = restaurant;
        this.paymentMethod = paymentMethod;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
