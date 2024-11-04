package Entities;

import java.time.LocalDateTime;

public class Restaurant {
    private Long idRestaurant;
    private String name;
    private Address address;
    private String telephone;
    private Category category;
    private LocalDateTime operatingHour;
    private Boolean Picked = true;

    public Restaurant(Long idRestaurant, String name, Address address, String telephone, Category category, LocalDateTime operatingHour, Boolean picked) {
        this.idRestaurant = idRestaurant;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.category = category;
        this.operatingHour = operatingHour;
        Picked = picked;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
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
        return Picked;
    }

    public void setPicked(Boolean picked) {
        Picked = picked;
    }
}
