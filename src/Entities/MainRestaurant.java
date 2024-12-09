package Entities;

import java.util.ArrayList;

public class MainRestaurant {
    public static void main(String[] args) {
     RestaurantDAO restaurantDAO = new RestaurantDAO();

     Restaurant newRest = new Restaurant();

//     newRest.setName("Ferreira");
//     newRest.setTelephone("87 99120-3040");
//     restaurantDAO.create(newRest);


     ArrayList<Restaurant> restaurantes = restaurantDAO.readAll();
     for (Restaurant restaurant:restaurantes){
         System.out.printf("ID: %d | Nome: %s | Telefone: %s\n",
                 restaurant.getId(), restaurant.getName(), restaurant.getTelephone());
     }
//        ArrayList<Restaurant> restaurants = new ArrayList<>();
//
//        if (!restaurantes.isEmpty()){
//            System.out.println("Deletando restaurante");
//            long idExcluir = restaurantes.get(1).getId();
//            restaurantDAO.delete(idExcluir);
//            System.out.println("Restaurante deletado!");
//        }
    }
}
