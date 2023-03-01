package br.com.solucao.terceiro.desafio;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
public class FaturamentoMensal {

    List<FaturamentoDiario> faturamentoDiarios = new ArrayList<>();

    public List<FaturamentoDiario> converterJSONArrayParaList(JSONArray jsonArray){
        var lista = (List<FaturamentoDiario>) jsonArray.stream().map(obj ->{
            JSONObject jsonObject = (JSONObject) obj;
            LocalDate data = LocalDate.parse((String) jsonObject.get("data"), DateTimeFormatter.ISO_LOCAL_DATE);
            BigDecimal valor = new BigDecimal((Double) jsonObject.get("valor")).setScale(2, RoundingMode.DOWN);
            return new FaturamentoDiario(data, valor);
        }).collect(Collectors.toList());

        return lista;
    }

    public Integer numeroDiasMesSuperiorMediaMensal(List<FaturamentoDiario> faturamentos){

        var mediaMensal = calculaMediaMensal(faturamentos);

        Long dias = faturamentos
                .stream()
                .filter(dia -> dia.getValor().compareTo(mediaMensal) > 0)
                .count();

        return Long.valueOf(dias).intValue();
    }
    public BigDecimal calculaMediaMensal(List<FaturamentoDiario> faturamentos){
        return BigDecimal.valueOf(faturamentos.stream()
                .map(FaturamentoDiario::getValor)
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .orElse(Double.NaN)).setScale(2, RoundingMode.DOWN);
    }
    public BigDecimal menorValorFaturamentoDiaDoMes(List<FaturamentoDiario> faturamentos){
        return faturamentos.stream()
                .map(FaturamentoDiario::getValor)
                .min(BigDecimal::compareTo)
                .orElse(null).setScale(2, RoundingMode.DOWN);
    }

    public BigDecimal maiorValorFaturamentoDiaDoMes(List<FaturamentoDiario> faturamentos){
        return faturamentos.stream()
                .map(FaturamentoDiario::getValor)
                .max(BigDecimal::compareTo)
                .orElse(null).setScale(2, RoundingMode.DOWN);
    }
}
