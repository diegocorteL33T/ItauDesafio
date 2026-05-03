package com.java10x.ItauDesafio.config;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasProperties(@NotNull @Positive Integer segundos) {

}
