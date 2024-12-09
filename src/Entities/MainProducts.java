package Entities;

import java.util.ArrayList;

public class MainProducts {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        Products newProducts = new Products();

        newProducts.setName("Schweppes Citrus");
        newProducts.setDescription("Lata 350ml");
        newProducts.setPrice(8.90);
        newProducts.setCategory(6);
        newProducts.setRestaurant(2);
        productDAO.create(newProducts);

        ArrayList<Products> products = productDAO.readAll();
        for (Products product:products){
            System.out.printf("ID: %d | Nome: %s | Descrição: %s | Preço: %f | Categoria: %s | Restaurante: %s\n",
                    product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCategory(), product.getRestaurant());
        }
    }
}
