package br.com.sistemaobrigacoes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	
	
	
	@Bean
	public Docket obrigacaoApi() {
		
		
		return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.sistemaobrigacoes.controladores"))
                .paths(PathSelectors.ant("/**"))
                //.build()
                //.ignoredParameterTypes(Usuario.class)
               // .globalOperationParameters(
                       // Arrays.asList(
                                //new ParameterBuilder()
                                    //.name("Authorization")
                                   // .description("Header para Token JWT")
                                   // .modelRef(new ModelRef("string"))
                                    //.parameterType("header")
                                   // .required(false)
                                    .build();
	}
	
	

}
