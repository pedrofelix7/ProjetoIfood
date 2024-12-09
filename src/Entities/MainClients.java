package Entities;

import java.util.ArrayList;

public class MainClients {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        System.out.println("=== Criando um novo cliente ===");
        Cliente newCliente = new Cliente();

        newCliente.setName("Pedro");
        newCliente.setAge(19);
        newCliente.setEmail("imperio@gmail.com");
        clienteDAO.create(newCliente);
        System.out.println("Cliente criado com sucesso");

        ArrayList<Cliente> clientes = new ArrayList<>();

        for (Cliente cliente:clientes){
            System.out.printf("ID: %d | Nome: %s | Idade: %f | Email: %s",
                    cliente.getId(), cliente.getName(), cliente.getAge(), cliente.getEmail());
        }
    }
}
