package com.nickdeakin.clashofclansservice;

import com.nickdeakin.clashofclansservice.config.SpringApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ClashOfClansServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ClashOfClansServiceApplication.class)
				.initializers(new SpringApplicationContextInitializer())
				.application()
				.run(args);
	}
}
