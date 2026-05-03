package com.java10x.ItauDesafio.service;

import com.java10x.ItauDesafio.config.EstatisticasProperties;
import com.java10x.ItauDesafio.model.EstatisticaDTO;
import com.java10x.ItauDesafio.model.TransacaoRequest;
import com.java10x.ItauDesafio.repository.TransacaoRepository;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class EstatisticasService {


    private final TransacaoRepository repository;
    private final EstatisticasProperties estatisticasProperties;

    public EstatisticasService(TransacaoRepository repository, EstatisticasProperties estatisticasProperties) {
        this.repository = repository;
        this.estatisticasProperties = estatisticasProperties;
    }

    public EstatisticaDTO calcularEstatisticas(){

        OffsetDateTime agora = OffsetDateTime.now().minusSeconds(estatisticasProperties.segundos());

        List<TransacaoRequest> recentes = repository.listar().stream()
                .filter(t -> t.dataHora().isAfter(agora) || t.dataHora().isEqual(agora))
                .toList();

        if(recentes.isEmpty()) {
            return new EstatisticaDTO(
                    0L,
                    BigDecimal.ZERO,
                    BigDecimal.ZERO,
                    BigDecimal.ZERO,
                    BigDecimal.ZERO);
        }

        BigDecimal sum = recentes.stream()
                .map(TransacaoRequest::valor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avg = sum.divide(BigDecimal.valueOf(recentes.size()),
                2, RoundingMode.HALF_UP);

        BigDecimal max = recentes.stream()
                .map(TransacaoRequest::valor)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        BigDecimal min = recentes.stream()
                .map(TransacaoRequest::valor)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        Long count = (long) recentes.size();

        return new  EstatisticaDTO(
                count,
                sum,
                avg,
                max,
                min
        );


    }



}
