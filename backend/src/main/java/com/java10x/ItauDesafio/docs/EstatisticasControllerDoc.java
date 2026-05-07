package com.java10x.ItauDesafio.docs;


import com.java10x.ItauDesafio.model.EstatisticaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name="Estatisticas", description = "EndPoint responsavel por calcular as estatisticas pedidas no desafio")
public interface EstatisticasControllerDoc {

    @Operation(
            summary = "Calcula estatisticas",
            description = "Calcula as estatisticas dentro do limite de tempo requisitado nas propriedades"
    )
    @ApiResponse(responseCode = "200", description = "Estatisticas calculadas com sucesso!")

    ResponseEntity<EstatisticaDTO> estatistica();

}
