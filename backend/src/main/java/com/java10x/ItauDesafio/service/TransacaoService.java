package com.java10x.ItauDesafio.service;

import com.java10x.ItauDesafio.model.TransacaoRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoRequest transacaoRequest) {

        if (transacaoRequest.valor().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Transação inválida, valor menor a zero");
        if (transacaoRequest.dataHora().isAfter(OffsetDateTime.now()))
            throw new IllegalArgumentException("Transação inválida, erro na data da transação");

    }

}

