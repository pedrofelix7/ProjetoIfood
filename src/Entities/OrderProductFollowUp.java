package Entities;

import java.util.ArrayList;

public class OrderProductFollowUp extends Base {

    private OrderProduct orderProduct;
    private ArrayList<FollowUp> followUp;

    public OrderProductFollowUp(OrderProduct orderProduct, ArrayList<FollowUp> followUp) {
        this.orderProduct = orderProduct;
        this.followUp = followUp;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public ArrayList<FollowUp> getFollowUp() {
        return followUp;
    }

    public void setFollowUp(ArrayList<FollowUp> followUp) {
        this.followUp = followUp;
    }


}
