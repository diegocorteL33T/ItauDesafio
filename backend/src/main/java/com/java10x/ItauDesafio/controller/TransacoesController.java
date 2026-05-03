package com.java10x.ItauDesafio.controller;


import com.java10x.ItauDesafio.model.TransacaoRequest;
import com.java10x.ItauDesafio.repository.TransacaoRepository;
import com.java10x.ItauDesafio.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;


    public TransacoesController(TransacaoService transacaoService, TransacaoRepository transacaoRepository) {
        this.transacaoService = transacaoService;
        this.transacaoRepository= transacaoRepository;
    }

/*

    //Sem GlobalExceptionHandler

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody @Valid TransacaoRequest transacaoRequest){

        try{
            transacaoService.validarTransacao(transacaoRequest);
            transacaoRepository.salvarDados(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }*/

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody @Valid TransacaoRequest transacaoRequest) {
        transacaoService.validarTransacao(transacaoRequest);
        transacaoRepository.salvarDados(transacaoRequest);
        log.info("Transação adicionada: valor={}, dataHora={}", transacaoRequest.valor(), transacaoRequest.dataHora());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(){
        log.info("Deletando todas as transações");
        transacaoRepository.deletarDados();
        return ResponseEntity.ok().build();
    }

}
