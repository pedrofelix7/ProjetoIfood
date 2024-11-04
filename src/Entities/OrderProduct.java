package Entities;

public class OrderProduct {

    private Long idOrderProduct;
    private Order order;
    private Product product;
    private int quantity;

    public OrderProduct(Long idOrderProduct, Order order, Product product, int quantity) {
        this.idOrderProduct = idOrderProduct;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getIdOrderProduct() {
        return idOrderProduct;
    }

    public void setIdOrderProduct(Long idOrderProduct) {
        this.idOrderProduct = idOrderProduct;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
