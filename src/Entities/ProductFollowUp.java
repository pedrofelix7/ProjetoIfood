package Entities;

public class ProductFollowUp {

    private Products product;
    private FollowUp followUp;

    public ProductFollowUp(Products product, FollowUp followUp) {
        this.product = product;
        this.followUp = followUp;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public FollowUp getFollowUp() {
        return followUp;
    }

    public void setFollowUp(FollowUp followUp) {
        this.followUp = followUp;
    }
}
