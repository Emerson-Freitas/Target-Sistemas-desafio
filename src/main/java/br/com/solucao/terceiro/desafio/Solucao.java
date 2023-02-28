package br.com.solucao.terceiro.desafio;

import java.util.Scanner;

public class Solucao {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite o caminho do arquivo (lembre-se de criar um arquivo dentro do projeto)");
        var pathArquivo = scanner.next();
        LeituraArquivoJson arquivoJson = new LeituraArquivoJson();

        try {
            System.out.println(arquivoJson.lerAquivoJson(pathArquivo).toString());
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
