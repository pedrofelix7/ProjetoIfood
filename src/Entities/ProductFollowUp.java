package Entities;

public class ProductFollowUp {

    private Product product;
    private FollowUp followUp;

    public ProductFollowUp(Product product, FollowUp followUp) {
        this.product = product;
        this.followUp = followUp;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public FollowUp getFollowUp() {
        return followUp;
    }

    public void setFollowUp(FollowUp followUp) {
        this.followUp = followUp;
    }
}
