package com.java10x.ItauDesafio.model;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Transacao {


    private BigDecimal valor;
    private OffsetDateTime dataHora;


}
