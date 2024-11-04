package Entities;

public class OrderProductFollowUp {
    private Long idOrderProductFollowUp;
    private OrderProduct orderProduct;
    private FollowUp followUp;

    public OrderProductFollowUp(Long idOrderProductFollowUp, OrderProduct orderProduct, FollowUp followUp) {
        this.idOrderProductFollowUp = idOrderProductFollowUp;
        this.orderProduct = orderProduct;
        this.followUp = followUp;
    }

    public Long getIdOrderProductFollowUp() {
        return idOrderProductFollowUp;
    }

    public void setIdOrderProductFollowUp(Long idOrderProductFollowUp) {
        this.idOrderProductFollowUp = idOrderProductFollowUp;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public FollowUp getFollowUp() {
        return followUp;
    }

    public void setFollowUp(FollowUp followUp) {
        this.followUp = followUp;
    }
}
