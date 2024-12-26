import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class NumeroFrequencia {
    public static void main(String[] args) {
        // Caminho do arquivo (substitua pelo caminho correto do seu arquivo .txt)
        String caminhoArquivo = "numeros.txt";

        // Mapa para armazenar a frequência dos números
        Map<Integer, Integer> frequenciaNumeros = new HashMap<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            // Ler cada linha do arquivo
            while ((linha = leitor.readLine()) != null) {
                // Dividir os números da linha com base na vírgula
                String[] numeros = linha.split(",");
                for (String numero : numeros) {
                    // Converter para inteiro e atualizar a contagem no mapa
                    int num = Integer.parseInt(numero.trim());
                    frequenciaNumeros.put(num, frequenciaNumeros.getOrDefault(num, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        // Ordenar o mapa pela frequência em ordem decrescente
        List<Map.Entry<Integer, Integer>> numerosOrdenados = frequenciaNumeros.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toList());

        // Exibir os números e suas frequências
        System.out.println("Número | Frequência");
        for (Map.Entry<Integer, Integer> entrada : numerosOrdenados) {
            System.out.printf("%6d | %d\n", entrada.getKey(), entrada.getValue());
        }
    }
}