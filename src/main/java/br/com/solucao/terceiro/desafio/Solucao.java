package br.com.solucao.terceiro.desafio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class Solucao {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo (lembre-se, o arquivo deve estar dentro da pasta src do projeto)");
        var pathArquivo = scanner.next();

        LeituraArquivoJson arquivoJson = new LeituraArquivoJson();

        try{
            JSONArray jsonArray = arquivoJson.lerAquivoJson(pathArquivo);
            FaturamentoMensal faturamentoMensal = new FaturamentoMensal();
            var lista = faturamentoMensal.converterJSONArrayParaList(jsonArray);
            faturamentoMensal.setFaturamentoDiarios(lista);

            for(FaturamentoDiario f : lista){
                System.out.println(f.toString());
            }

            System.out.println("O menor valor de faturamento ocorrido em um dia do mês: " + faturamentoMensal.menorValorFaturamentoDiaDoMes(faturamentoMensal.getFaturamentoDiarios()));
            System.out.println("O maior valor de faturamento ocorrido em um dia do mês: " + faturamentoMensal.maiorValorFaturamentoDiaDoMes(faturamentoMensal.getFaturamentoDiarios()));
            System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: ");

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
