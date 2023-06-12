package rw.solutions.api.resi.configurations;

import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@OpenAPIDefinition
@Configuration
@SecurityScheme(
        name = "token",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class DocumentacaoConfiguration {
	
	@Value("${bezkoder.openapi.dev-url}")
	private String devUrl;

	@Value("${bezkoder.openapi.prod-url}")
	private String prodUrl;
	
	@Bean
	protected OpenAPI apiInfo() {
		
		Server devServer = new Server();
	    devServer.setUrl(devUrl);
	    devServer.setDescription("Server URL in Development environment");

	    Server prodServer = new Server();
	    prodServer.setUrl(prodUrl);
	    prodServer.setDescription("Server URL in Production environment");
		
		return new OpenAPI()
				   .info(new Info().title("API Resi Controll").version("1.0.0"))
				   .servers(List.of(devServer, prodServer));
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
