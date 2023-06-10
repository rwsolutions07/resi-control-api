package rw.solutions.api.resi.configurations;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
@SecurityScheme(
        name = "token",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class DocumentacaoConfiguration {
	
	@Bean
	protected OpenAPI apiInfo() {
		return new OpenAPI()
				   .info(new Info()
						   .title("API Resi Controll")
						   .version("3.0.0"));
	}
	
	@Bean
    public GroupedOpenApi authenticationApi(){
        String [] paths = {"/autenticacao/**"};
        return GroupedOpenApi.builder()
                .group("Authentication")
                .pathsToMatch(paths)
                .build();
    }

}
