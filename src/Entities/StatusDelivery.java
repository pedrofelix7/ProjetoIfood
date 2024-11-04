package Entities;

public class StatusDelivery extends Base {
    private Long idStatusDelivery;
    private String name;


    public StatusDelivery(Long idStatusDelivery, String name) {
        this.idStatusDelivery = idStatusDelivery;
        this.name = name;
    }

    public Long getIdStatusDelivery() {
        return idStatusDelivery;
    }

    public void setIdStatusDelivery(Long idStatusDelivery) {
        this.idStatusDelivery = idStatusDelivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
