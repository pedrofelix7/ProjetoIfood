package Entities;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ProductDAO productDAO = new ProductDAO();
        paymentDAO paymentDAO = new paymentDAO();
//        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);
        orderDAO orderDAO = new orderDAO();
        AddressDAO addressDAO = new AddressDAO();
        Address address = new Address();

        ViaCepClient viaCepClient = new ViaCepClient();

        try {
            boolean continueSelection = true;
            while (true) {
                ArrayList<Restaurant> restaurants = restaurantDAO.readAll();
                for (Restaurant restaurant : restaurants) {
                    System.out.printf("ID: %d | Nome: %s | Telefone: %s\n",
                            restaurant.getId(), restaurant.getName(), restaurant.getTelephone());
                }
                System.out.println("Selecione o restaurante que deseja realizar seu pedido!");
                int choice1 = scanner.nextInt();
                scanner.nextLine();

                if (choice1 < 1 || choice1 > restaurants.size()) {
                    System.out.println("Selecione uma opção válida!");
                    continue;
                } else {
                    Restaurant selectRestaurant = restaurants.get(choice1 - 1);
                    ArrayList<Products> products = productDAO.getRest(selectRestaurant.getId());
                    ArrayList<Products> selectProducts = new ArrayList<>();
                    double totalValue = 0.0;

                    boolean addProduct = true;
                    while (addProduct) {
                        System.out.println("Produtos disponiveis do " + selectRestaurant.getName() + ":");
                        for (Products product : products) {
                            System.out.printf("ID: %d | Nome: %s | Descrição: %s | Preço: %f\n",
                                    product.getId(), product.getName(), product.getDescription(), product.getPrice());
                        }
                        System.out.println("Selecione o ID do produto desejado!");
                        int choice2 = scanner.nextInt();
                        scanner.nextLine();

                        boolean validarEscolha = false  ;
                        for (Products product : products) {
                            if (product.getId() == choice2) {
                                selectProducts.add(product);
                                totalValue += product.getPrice();
                                System.out.printf("Produto %s adicionado ao pedido!\n",
                                        product.getName());
                                validarEscolha = true;
                                break;
                            }
                        }

                        if (!validarEscolha){
                            System.out.println("Selecione uma opção válida!");
                        } else {
                            System.out.println("Deseja adicionar mais algum produto?\n" +
                                    "Digite sim para adicionar outro produto\n" +
                                    "Digite não para ir ao carrinho");
                            String choice3 = scanner.next();
                            if (!choice3.equalsIgnoreCase("sim")){
                                break;
                            }
                        }
                    }
                    System.out.println("Checkout do seu pedido:");
                    for (Products product : selectProducts) {
                        System.out.printf("|Restaurante: %s | Telefone: %s\n" +
                                          "|Nome: %s\n" +
                                          "|Descrição: %s \n" +
                                          "|Preço: %.2f\n",
                                selectRestaurant.getName(), selectRestaurant.getTelephone(), product.getName(), product.getDescription(), product.getPrice());
                    }
                    System.out.printf("|Valor total: %.2f\n", totalValue);

                    System.out.println("Digite seu cep:");
                    scanner.nextLine();
                    String cep = scanner.nextLine().trim();
                    try {
                        String json = ViaCepClient.buscarEndereco(cep);

                        String logradouro = ViaCepClient.extractValueFromJson(json, "logradouro");
                        String bairro = ViaCepClient.extractValueFromJson(json, "bairro");
                        String cidade = ViaCepClient.extractValueFromJson(json, "localidade");
                        String estado = ViaCepClient.extractValueFromJson(json, "uf");

                        System.out.println("Endereço encontrado:");
                        System.out.printf("Lougradoro: %s\n" + "Bairro: %s\n" + "Cidaded: %s\n" + "UF: %s\n",
                                logradouro, bairro, cidade, estado);

                        System.out.println("Digite o número do endereço:");
                        String numero = scanner.nextLine().trim();

                        String enderecoCompleto = String.format("%s, Nº %s, %s, %s - %s",
                                logradouro, numero, bairro, cidade, estado);

                        System.out.println("Endereço completo: ");
                        System.out.println(enderecoCompleto);

                        Address addressAPI = new Address();
                        addressAPI.setRoad(logradouro);
                        addressAPI.setDistrict(bairro);
                        addressAPI.setCity(cidade);
                        addressAPI.setState(estado);
                        addressAPI.setNumber(numero);
                        addressDAO.create(addressAPI);

                    } catch (RuntimeException e) {
                        System.err.println("Erro: " + e.getMessage());
                    }

                    System.out.println("Selecione a forma de pagamento:");

                    ArrayList<PaymentMethod> selectPayment = new ArrayList<>();
                    ArrayList<PaymentMethod> paymentMethods = paymentDAO.readAll();

                    for (PaymentMethod paymentMethod:paymentMethods){
                        System.out.printf("ID: %d | Tipo: %s\n",
                                paymentMethod.getId(), paymentMethod.getPaymentType1());
                    }
                    int choice4 = scanner.nextInt();
                    scanner.nextLine();

                    boolean paymentValid = false;
                    for (PaymentMethod paymentMethod:paymentMethods) {
                        if (paymentMethod.getId() == choice4) {
                            paymentMethods.add(paymentMethod);
                            System.out.printf("Tipo de pagamento escolhido: %s\n\n",
                                    paymentMethod.getPaymentType1());
                            paymentValid = true;
                            break;
                        }
                    }

                        if (!paymentValid){
                            System.out.println("Selecione uma opção válida!");
                        } else {
                            boolean orderFinalized = false;
                            while (!orderFinalized) {
                                System.out.println("Deseja finalizar o pedido?\n" +
                                        "Digite sim para finalizar\n" +
                                        "Digite não para retornar");
                                String choice5 = scanner.nextLine().trim();

                                if (choice5.equalsIgnoreCase("sim")) {
                                    OrderStatusUpdate statusUpdater = new OrderStatusUpdate(choice4);
                                    statusUpdater.startUpdateProcess();

                                    Orders newOrders = new Orders();

                                    newOrders.setTotalValue(totalValue);
                                    newOrders.setRestaurant(selectRestaurant);
                                    newOrders.setPaymentMethod(selectPayment);
                                    newOrders.setAddress(address);
//                                    orderDAO.create(newOrders, totalValue, selectPayment, address);
                                    continueSelection = false;
                                    break;
                                } else if (choice5.equalsIgnoreCase("nao") || choice5.equalsIgnoreCase("não")) {
                                    System.out.println("Retornando ao menu principal");
                                    break;
                                } else {
                                    System.out.println("Opção inválida. Voltando ao menu principal");
                                    orderFinalized = true;
                                    break;
                            }

                        }
                    }

                }
                break;
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}


