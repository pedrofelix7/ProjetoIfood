package Entities;

import java.time.LocalDateTime;

public class Restaurant extends Base {
    private long id;
    private String name;
    private Address address;
    private String telephone;
    private Category category;
    private LocalDateTime operatingHour;
    private boolean picked = true;

    public Restaurant() {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.category = category;
        this.operatingHour = operatingHour;
        picked = picked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getOperatingHour() {
        return operatingHour;
    }

    public void setOperatingHour(LocalDateTime operatingHour) {
        this.operatingHour = operatingHour;
    }

    public Boolean getPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        picked = picked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPicked() {
        return picked;
    }
}

