// Importações necessárias para leitura de dados, conexão com a internet e manipulação JSON
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria scanner para entrada do usuário
        int opcao = 0; // Variável para armazenar a opção do menu

        // Estrutura de repetição do menu até que o usuário escolha sair
        do {
            // Menu de opções
            System.out.println("\n==== CONVERSOR DE MOEDAS ====");
            System.out.println("1. Dólar (USD) -> Real (BRL)");
            System.out.println("2. Euro (EUR) -> Dólar (USD)");
            System.out.println("3. Real (BRL) -> Peso Argentino (ARS)");
            System.out.println("4. Libra Esterlina (GBP) -> Euro (EUR)");
            System.out.println("5. Iene Japonês (JPY) -> Real (BRL)");
            System.out.println("6. Dólar Canadense (CAD) -> Dólar (USD)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            // Verifica se o usuário digitou um número inteiro
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.nextLine(); // Limpa entrada incorreta
                continue;
            }

            opcao = scanner.nextInt(); // Lê a opção do usuário
            String from = "", to = ""; // Códigos das moedas

            // Define as moedas de origem e destino com base na opção escolhida
            switch (opcao) {
                case 1: from = "USD"; to = "BRL"; break;
                case 2: from = "EUR"; to = "USD"; break;
                case 3: from = "BRL"; to = "ARS"; break;
                case 4: from = "GBP"; to = "EUR"; break;
                case 5: from = "JPY"; to = "BRL"; break;
                case 6: from = "CAD"; to = "USD"; break;
                case 0: System.out.println("Saindo..."); break;
                default:
                    System.out.println("Opção inválida!");
                    continue; // Volta ao menu
            }

            // Se a opção for válida, pede o valor a ser convertido
            if (opcao >= 1 && opcao <= 6) {
                System.out.print("Digite o valor a converter: ");
                scanner.nextLine(); // Limpa o buffer do teclado

                // Captura o valor digitado e troca vírgula por ponto
                String input = scanner.nextLine().replace(",", ".");
                double valor;

                try {
                    valor = Double.parseDouble(input); // Converte para double
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido. Tente novamente.");
                    continue;
                }

                // Chama a função que realiza a conversão
                double resultado = converterMoeda(from, to, valor);

                // Exibe o resultado ou mensagem de erro
                if (resultado != -1) {
                    System.out.printf("Resultado: %.2f %s = %.2f %s%n", valor, from, resultado, to);
                } else {
                    System.out.println("Não foi possível realizar a conversão.");
                }
            }

        } while (opcao != 0); // Repete até o usuário escolher sair

        scanner.close(); // Fecha o scanner
    }

    // Função que consulta a API para obter a taxa de câmbio
    public static double converterMoeda(String from, String to, double amount) {
        try {
            String apiKey = "ce0e44c90caadef89671eb7b"; // Sua chave da API
            // URL formatada com a chave e os parâmetros de conversão
            String apiUrl = String.format(
                    "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.2f",
                    apiKey, from, to, amount
            ).replace(",", ".");

            // Abre conexão com a URL da API
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET"); // Define método GET

            // Lê a resposta JSON da API
            Reader reader = new InputStreamReader(connection.getInputStream());
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();

            // Mostra o JSON para debug
            System.out.println("DEBUG - Resposta da API: " + json);

            // Verifica se a resposta contém o campo esperado
            if (json.has("conversion_result") && !json.get("conversion_result").isJsonNull()) {
                return json.get("conversion_result").getAsDouble(); // Retorna o valor convertido
            } else {
                System.out.println("A API não retornou o campo 'conversion_result' ou ele está ausente.");
                return -1;
            }

        } catch (Exception e) {
            // Em caso de erro na conexão ou leitura da API
            System.out.println("Erro: " + e.getMessage());
            return -1;
        }
    }
}
