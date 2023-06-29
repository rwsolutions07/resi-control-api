package rw.solutions.api.resi.configurations;

import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Component
@OpenAPIDefinition
@Configuration
public class DocumentacaoConfiguration {
	
	@Value("${bezkoder.openapi.dev-url}")
	private String devUrl;

	@Value("${bezkoder.openapi.prod-url}")
	private String prodUrl;
	
	@Autowired
	private BuildProperties buildProperties;
	
	@Bean
	protected OpenAPI apiInfo() {
		
		return new OpenAPI()
				   .info(getInfo())
				   .servers(List.of(getDevServer(), getProdServer()))
				   .components(getComponentes());
	}
	
	
	@Bean
    public GroupedOpenApi authenticationApi(){
        String [] paths = {"/autenticacao/**"};
        return GroupedOpenApi.builder()
                .group("Authentication")
                .pathsToMatch(paths)
                .build();
    }
	
	
	private Server getDevServer() {
		Server devServer = new Server();
	    devServer.setUrl(devUrl);
	    devServer.setDescription("Servidor de testes");
		return devServer;
	}
	
	private Server getProdServer() {
		Server prodServer = new Server();
	    prodServer.setUrl(prodUrl);
	    prodServer.setDescription("Servidor de produção");
		return prodServer;
	}

	private Info getInfo() {
		return new Info().title("API Resi Controll").version(buildProperties.getVersion());
	}
	
	private Components getComponentes() {
		return new Components().addSecuritySchemes("bearer-key", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"));
	}

	
}
