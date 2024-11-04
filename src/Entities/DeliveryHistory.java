package Entities;

public class DeliveryHistory {

    private Long idDeliveryHistory;
    private StatusDelivery statusDelivery;
    private Order order;

    public DeliveryHistory(Long idDeliveryHistory, StatusDelivery statusDelivery, Order order) {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
