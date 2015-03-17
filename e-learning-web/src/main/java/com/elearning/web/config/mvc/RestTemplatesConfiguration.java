package com.elearning.web.config.mvc;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

/**
 * 
 * @author Gustavo Orsi
 *
 */
@Configuration
public class RestTemplatesConfiguration {

	@Bean(name = "oauth2RestTemplate")
	public OAuth2RestTemplate getOauth2RestTemplate() {

		ClientCredentialsResourceDetails clientDetails = new ClientCredentialsResourceDetails();
		clientDetails.setAccessTokenUri("http://localhost:8081/oauth/token");
		clientDetails.setClientId("my-client-with-secret");
		clientDetails.setClientSecret("secret");
		clientDetails.setScope(Arrays.asList("read"));

		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(clientDetails, clientContext);

		return restTemplate;

	}

}
