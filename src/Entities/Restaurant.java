package Entities;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Restaurant extends Base {
    private String name;
    private Address address;
    private String telephone;
    private Category category;
    private LocalDateTime operatingHour;
    private Boolean Picked = true;


    public Restaurant() {
       this.name = name;
      this.address = address;
     this.telephone = telephone;
      this.category = category;
     this.operatingHour = operatingHour;
    }
//    public Restaurant(String name, Address address, String telephone, Category category, LocalDateTime operatingHour, Boolean picked) {
//        this.name = name;
//        this.address = address;
//        this.telephone = telephone;
//        this.category = category;
//        this.operatingHour = operatingHour;
//        Picked = picked;
//    }

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

    public int selectRest(){
        Scanner entry = new Scanner(System.in);
        System.out.println("Qual restaurante gostaria de escolher?");
        System.out.println("1. Cantana");
        System.out.println("2. Ferreira Espetos");
        System.out.println("3. Falcão Espetos");

        int choice = entry.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Você selecionou: Cantana");
                break;
            case 2:
                System.out.println("Você selecionou: Ferreira Espetos");
                break;
            case 3:
                System.out.println("Você selecionou: Falcão Espetos");
                break;
            default:
                throw new IllegalArgumentException("Opção Inválida, tente novamente.");
        }
        return choice;

    }
}
