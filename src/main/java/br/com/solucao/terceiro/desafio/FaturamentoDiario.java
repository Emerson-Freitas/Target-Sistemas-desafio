package br.com.solucao.terceiro.desafio;

import lombok.Getter;
import org.json.simple.JSONObject;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class FaturamentoDiario {

    private LocalDate data;

    private BigDecimal valor;

    public FaturamentoDiario(JSONObject jsonObject){
        this.data = (LocalDate) jsonObject.get("data");
        this.valor = (BigDecimal) jsonObject.get("valor");
    }

}
