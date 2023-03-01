package br.com.solucao.terceiro.desafio;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.json.simple.JSONObject;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@EqualsAndHashCode
@ToString
public class FaturamentoDiario {

    private LocalDate data;

    private BigDecimal valor;

    public FaturamentoDiario(LocalDate data, BigDecimal valor){
        this.data = data;
        this.valor = valor;
    }

}
