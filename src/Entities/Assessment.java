package Entities;

public class Assessment extends Base {

    private int grade; //nota
    private Orders order;
    private Restaurant restaurant;

    public Assessment(int grade, Orders order, Restaurant restaurant) {
        this.grade = grade;
        this.order = order;
        this.restaurant = restaurant;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
