package Entities;

import java.util.ArrayList;

public class StatusDelivery extends Base {
    private long id;
    private String name;

    public StatusDelivery(){
        this.id = id;
        this.name = name;
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
}
