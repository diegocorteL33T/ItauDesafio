package com.java10x.ItauDesafio.model;


import java.math.BigDecimal;

public record EstatisticaDTO(
        Long count,
        BigDecimal sum,
        BigDecimal avg,
        BigDecimal max,
        BigDecimal min

        ) {

}
