package com.sdcc.gpao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;

@Configuration
public class R2DBCConfig {
	@Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(ConnectionFactoryOptions.DRIVER, "sqlserver")
                        .option(ConnectionFactoryOptions.HOST, "DI-LPTP-16")
                        .option(ConnectionFactoryOptions.PORT, 1433)
                        .option(ConnectionFactoryOptions.USER, "sa")
                        .option(ConnectionFactoryOptions.PASSWORD, "Damico5089@")
                        .option(ConnectionFactoryOptions.DATABASE, "gpao")
                        //.option(ConnectionFactoryOptions.CONNECT_TIMEOUT, 50000)
                        .build());
    }
}
