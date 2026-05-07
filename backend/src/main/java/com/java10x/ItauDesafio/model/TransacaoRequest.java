package com.java10x.ItauDesafio.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoRequest
        (
         @NotNull(message = "Valor é obrigatório") @Positive(message = "Valor deve ser positivo") BigDecimal valor,
         @NotNull(message = "Data e hora são obrigatórias") OffsetDateTime dataHora
        ) {

}
