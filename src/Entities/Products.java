package Entities;

public class Products extends Base {

    private long id;
    private String name;
    private String description;
    private double price;
    private int category;
    private int restaurant;

    public Products() {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.restaurant = restaurant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
    }
}
