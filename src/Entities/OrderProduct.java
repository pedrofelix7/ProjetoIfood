package Entities;

import java.util.ArrayList;

public class OrderProduct extends Base {

    private ArrayList<Orders> order;
    private ArrayList<Products> product;
    private int quantity;

    public OrderProduct(ArrayList<Orders> order, ArrayList<Products> product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public ArrayList<Orders> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Orders> order) {
        this.order = order;
    }

    public ArrayList<Products> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Products> product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
