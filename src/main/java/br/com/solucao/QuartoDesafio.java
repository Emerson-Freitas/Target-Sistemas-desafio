package br.com.solucao;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class QuartoDesafio {

    public static void main(String[] args) {

        var listaDePorcentagens = calculaPercentualDeRepresentacao(67386.43, 36678.66, 29229.88, 27165.48, 19849.53);
        var nomeEstados = listaDePorcentagens.keySet();
        var decimalFormat = new DecimalFormat("#.##");

        for(String estado : nomeEstados){
           var porcentagem = listaDePorcentagens.get(estado);
           var porcentagemFormatada = decimalFormat.format(porcentagem);
           System.out.println(estado + " = " + porcentagemFormatada + "%");
        }

    }

    public static Map<String, Double> calculaPercentualDeRepresentacao(double valorSP, double valorRJ, double valorMG, double valorES, double valorOutros){
        var valorTotal = valorSP + valorRJ + valorMG + valorES + valorOutros;

        var listaDePorcentagens = new LinkedHashMap<String, Double>();
        var porcentagemSP = (valorSP / valorTotal) * 100;
        var porcentagemRJ = (valorRJ / valorTotal) * 100;
        var porcentagemMG = (valorMG / valorTotal) * 100;
        var porcentagemES = (valorES / valorTotal) * 100;
        var porcentagemOutros = (valorOutros / valorTotal) * 100;

        listaDePorcentagens.put("SP", porcentagemSP);
        listaDePorcentagens.put("RJ", porcentagemRJ);
        listaDePorcentagens.put("MG", porcentagemMG);
        listaDePorcentagens.put("ES", porcentagemES);
        listaDePorcentagens.put("Outros", porcentagemOutros);

        return listaDePorcentagens;
    }
}
