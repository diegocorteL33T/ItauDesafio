package com.java10x.ItauDesafio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasProperties(Integer segundos) {

}
