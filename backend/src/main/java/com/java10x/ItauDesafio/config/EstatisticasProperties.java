package com.java10x.ItauDesafio.config;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated // Super necessario para a validacao funcionar
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasProperties(@NotNull @Positive Integer segundos) {

}
