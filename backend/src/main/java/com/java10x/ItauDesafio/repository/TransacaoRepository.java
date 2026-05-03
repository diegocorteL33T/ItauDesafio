package com.java10x.ItauDesafio.repository;

import com.java10x.ItauDesafio.model.TransacaoRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();


    // Salvar os dados em uma lista

    public void salvarDados(TransacaoRequest transacaoRequest){

    listaDeTransacoes.add(transacaoRequest);

    }

    public List<TransacaoRequest> listar(){
        return listaDeTransacoes;
    }

    // Apagar todas as transacoes da lista

    public void deletarDados(){
        listaDeTransacoes.clear();

    }

}
