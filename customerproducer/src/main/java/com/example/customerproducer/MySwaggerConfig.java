package com.example.customerproducer;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class MySwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().paths(regex("/.*")).build();
	}

	@SuppressWarnings("deprecation")
	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("LTI Application Development Assessment").description("API reference guide Product Management System").termsOfServiceUrl("https://www.lti.com/").contact("LNT user").version("1.0").build();	
	}


}
