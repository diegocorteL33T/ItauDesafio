package com.java10x.ItauDesafio.docs;

import com.java10x.ItauDesafio.model.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="Transacoes", description = "EndPoints responsaveis por criar e adicionar e limpar transacoes da lista")
public interface TransacoesControllerDoc {

    @Operation(
            summary = "Cria e adiciona as novas transacoes a uma lista",
            description = "Recebe e valida a transacao, caso validado, adiciona a lista"
    )
    @ApiResponse(responseCode = "201", description = "Transacao validada e criada com sucesso!")
    @ApiResponse(responseCode = "422", description = "Erro de validacao capturado!")
    @ApiResponse(responseCode = "400", description = "Erro inesperado no servidor!")

    ResponseEntity<Void> adicionar(@RequestBody @Valid TransacaoRequest transacaoRequest);


    @Operation(summary = "Deletar tudo",description = "Deleta todas as transacoes da lista")
    @ApiResponse(responseCode = "200",description = "Lista deletada com sucesso!")

    ResponseEntity<Void> deletar();

}