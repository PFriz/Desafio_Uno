package com.pfriz.desafiouno.swagger;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration @EnableSwagger2
public class SpringFoxConfig {
	TypeResolver typeResolver = new TypeResolver();
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.alternateTypeRules( AlternateTypeRules.newRule(
						typeResolver.resolve(List.class, LocalDate.class), 
						typeResolver.resolve(List.class, String.class), 
                Ordered.HIGHEST_PRECEDENCE))
        
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.pfriz.desafiouno.api"))
				.paths(PathSelectors.any())
				.build();
	}
}
