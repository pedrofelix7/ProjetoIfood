package Entities;

public class Assessment{

    private int idAssessment;
    private int grade; //nota
    private Order order;
    private Restaurant restaurant;

    public Assessment(int idAssessment, int grade, Order order, Restaurant restaurant) {
        this.idAssessment = idAssessment;
        this.grade = grade;
        this.order = order;
        this.restaurant = restaurant;
    }

    public int getIdAssessment() {
        return idAssessment;
    }

    public void setIdAssessment(int idAssessment) {
        this.idAssessment = idAssessment;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
