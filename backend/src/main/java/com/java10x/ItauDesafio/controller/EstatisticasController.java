package com.java10x.ItauDesafio.controller;


import com.java10x.ItauDesafio.model.EstatisticaDTO;
import com.java10x.ItauDesafio.service.EstatisticasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final EstatisticasService service;

    public EstatisticasController(EstatisticasService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<EstatisticaDTO> estatistica() {
        return ResponseEntity.status(HttpStatus.OK).body(service.calcularEstatisticas());

    }

}
