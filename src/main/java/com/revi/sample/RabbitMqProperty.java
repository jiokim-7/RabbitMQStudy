package com.revi.sample;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
@Getter
@Setter
public class RabbitMqProperty {
    private RabbitMqDetailProperty test;
    @Getter
    @Setter
    public static class RabbitMqDetailProperty {
        private String username;
        private String password;
        private String host;
        private int port;
        private String virtualHost;
        private String routeKey;
        private String exchangeName;
        private String queueName;
        private String deadLetterExchange;
        private String deadLetterRouteKey;
    }
}
