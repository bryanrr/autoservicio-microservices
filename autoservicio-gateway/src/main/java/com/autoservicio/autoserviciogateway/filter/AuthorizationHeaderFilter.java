package com.autoservicio.autoserviciogateway.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

import java.util.Optional;

import org.springframework.core.Ordered;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AuthorizationHeaderFilter extends ZuulFilter{
	
	private final OAuth2AuthorizedClientService clientService;
	
	public AuthorizationHeaderFilter(OAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;
    }

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
        Optional<String> authorizationHeader = getAuthorizationHeader();
        System.out.println(authorizationHeader.isPresent()?authorizationHeader.get():"NO ESTUVO");
        authorizationHeader.ifPresent(s -> ctx.addZuulRequestHeader("Authorization", s));
        
		return null;
	}

	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}
	
    private Optional<String> getAuthorizationHeader() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(
                oauthToken.getAuthorizedClientRegistrationId(),
                oauthToken.getName());

        OAuth2AccessToken accessToken = client.getAccessToken();

        if (accessToken == null) {
            return Optional.empty();
        } else {
            String tokenType = accessToken.getTokenType().getValue();
            String authorizationHeaderValue = String.format("%s %s", tokenType, accessToken.getTokenValue());
            return Optional.of(authorizationHeaderValue);
        }
    }
}
