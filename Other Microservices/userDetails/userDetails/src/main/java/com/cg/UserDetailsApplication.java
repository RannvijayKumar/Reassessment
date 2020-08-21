package com.cg;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class UserDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsApplication.class, args);
	}
	
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cg"))
				.build()
				.apiInfo(myApiInfo());
	}

	private ApiInfo myApiInfo() {
		
		return new ApiInfo(
				"Customer Service API",
				"Sample API for implementing Swagger tutorial",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Ranvijay Kumar", "http://localhost:5555/swagger-ui.html#/", "rannvijaykr007@gmail.com"),
				"Api Licence",
				"http://localhost:5555/swagger-ui.html#/",
				Collections.emptyList());
	}
	


}
