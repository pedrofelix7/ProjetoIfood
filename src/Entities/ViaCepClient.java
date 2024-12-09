package Entities;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepClient {
    public static void main(String[] args) {


        String cep = "55360-000";
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String json = response.body();

                System.out.println("Resposta da API: ");
                System.out.println(response.body());
                String logradouro = extractValueFromJson(json, "logradouro");
                System.out.println("logradouro");
                System.out.println(logradouro);
            } else {
                System.out.println("Erro na consulta ao VIACEP. status code: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String extractValueFromJson(String json, String key) {
        String searchKey = "\"" + key + "\":";
        int startIndex = json.indexOf(searchKey);

        if (startIndex == -1) {
            return null; // Chave não encontrada
        } else {
            startIndex += searchKey.length();
            int endIndex = json.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = json.indexOf("}", startIndex);
            }

            // se tiver aspas remove
            String value = json.substring(startIndex, endIndex).trim();
            if (value.startsWith("\"") && value.endsWith("\"")) {
                value = value.substring(1, value.length() - 1);
            }
            return value;
        }
    }

    public static String buscarEndereco(String cep) {
        // Validação básica do formato do CEP
        if (cep == null || !cep.matches("\\d{5}-?\\d{3}")) {
            throw new IllegalArgumentException("CEP inválido. Deve estar no formato 00000-000 ou 00000000.");
        }

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // Envia a requisição para a API ViaCEP
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String json = response.body();

                // Verifica se o CEP retornou erro
                if (json.contains("\"erro\": true")) {
                    throw new RuntimeException("CEP não encontrado. Verifique e tente novamente.");
                }

                return json; // Retorna o JSON do endereço
            } else {
                throw new RuntimeException("Erro ao consultar ViaCEP. Status Code: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar a API ViaCEP: " + e.getMessage(), e);
        }
    }

}