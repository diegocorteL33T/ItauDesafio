package com.java10x.ItauDesafio.controller;


import com.java10x.ItauDesafio.config.EstatisticasProperties;
import com.java10x.ItauDesafio.model.EstatisticaDTO;
import com.java10x.ItauDesafio.service.EstatisticasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final EstatisticasService service;
    private final EstatisticasProperties estatisticasProperties;

    public EstatisticasController(EstatisticasService service, EstatisticasProperties estatisticasProperties) {
        this.service = service;
        this.estatisticasProperties = estatisticasProperties;
    }

    @GetMapping
    public ResponseEntity<EstatisticaDTO> estatistica() {
        // Log de requisicao criado via Lombok
        log.info("Calculando Estatisticas de trasacacao nos ultimos {} segundos: ", estatisticasProperties.segundos());
        EstatisticaDTO stats = service.calcularEstatisticas();
        return ResponseEntity.status(HttpStatus.OK).body(stats);
    }

}
