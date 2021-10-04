package com.sdcc.gpao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication
public class ReactiveGpaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveGpaoApplication.class, args);
	}

}
