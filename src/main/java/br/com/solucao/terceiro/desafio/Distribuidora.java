package br.com.solucao.terceiro.desafio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    private List<FaturamentoDiario> faturamentos = new ArrayList<FaturamentoDiario>();

    public Integer numeroDiasMesSuperiorMediaMensal(List<FaturamentoDiario> faturamentos){

        int dias = 0;
        BigDecimal mediaMensal = calculaMediaMensal(faturamentos);

        for(FaturamentoDiario dia : faturamentos){
            
        }
        return dias;
    }
    public BigDecimal calculaMediaMensal(List<FaturamentoDiario> faturamentos){
        return BigDecimal.valueOf(faturamentos.stream()
                .map(FaturamentoDiario::getValor)
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .orElse(Double.NaN));
    }
    public BigDecimal menorValorFaturamentoDiaDoMes(List<FaturamentoDiario> faturamentos){
        return faturamentos.stream()
                .map(FaturamentoDiario::getValor)
                .min(BigDecimal::compareTo)
                .orElse(null);
    }

    public BigDecimal maiorValorFaturamentoDiaDoMes(List<FaturamentoDiario> faturamentos){
        return faturamentos.stream()
                .map(FaturamentoDiario::getValor)
                .max(BigDecimal::compareTo)
                .orElse(null);
    }
}
