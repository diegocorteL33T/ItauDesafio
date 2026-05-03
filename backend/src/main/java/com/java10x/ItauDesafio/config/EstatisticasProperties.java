package com.java10x.ItauDesafio.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasProperties(@NotBlank Integer segundos) {

}
