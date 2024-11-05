package Entities;

import java.util.ArrayList;

public class DeliveryHistory {

    private Long idDeliveryHistory;
    private StatusDelivery statusDelivery;
    private ArrayList <Orders> order;

    public DeliveryHistory(Long idDeliveryHistory, StatusDelivery statusDelivery, ArrayList <Orders> order) {
        this.idDeliveryHistory = idDeliveryHistory;
        this.statusDelivery = statusDelivery;
        this.order = order;
    }

    public Long getIdDeliveryHistory() {
        return idDeliveryHistory;
    }

    public void setIdDeliveryHistory(Long idDeliveryHistory) {
        this.idDeliveryHistory = idDeliveryHistory;
    }

    public StatusDelivery getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(StatusDelivery statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public ArrayList<Orders> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Orders> order) {
        this.order = order;
    }
}
