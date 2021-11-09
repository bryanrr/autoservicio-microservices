package com.autoservicio.autoserviciogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;

import com.autoservicio.autoserviciogateway.filter.AuthorizationHeaderFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class AutoservicioGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoservicioGatewayApplication.class, args);
	}
	
	@Bean
    public AuthorizationHeaderFilter authHeaderFilter(OAuth2AuthorizedClientService clientService) {
        return new AuthorizationHeaderFilter(clientService);
    }
	
}
