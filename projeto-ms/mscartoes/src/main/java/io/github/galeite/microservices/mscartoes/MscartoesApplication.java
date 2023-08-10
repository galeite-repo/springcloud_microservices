package io.github.galeite.microservices.mscartoes;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
@Configuration
@Slf4j
public class MscartoesApplication {

	public static void main(String[] args) {
		log.info("Informação {}", "Teste info");
		log.error("Erro {}", "Teste error");
		log.warn("Aviso {}", "Teste warning");
		
		SpringApplication.run(MscartoesApplication.class, args);
	}

}
