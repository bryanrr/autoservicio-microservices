# Microservice based architecture
	A microservice based architecture secured by Okta Oauth2 mechanism

## This demo has the following components:
- **Config Server:** Module encouraged to provide needed properties for microservices.
- **Discovery Service:** A eureka server to provide info of other microservices.
-	**Product Service:** Microservice connected to a Mongo database in charge of providing data.
-	**Gateway:** A zuul proxy in charge of forwarding requests to microservices and append an Auhotization header of Bearer type to pass the acess token.  
		It's made of the following components:  
			- Zuul proxy: Forwards requests to microservice.  
			- Feign client: An alternative to zuul proxy to forward the request to microservices.
		
## Security:
In order to provide authentication we use Okta Oauth2 OIDC mechanism.  
Both the *Gateway Service*  and *Product Service* are secured by this okta Oauth2 mechanism.  
*Gateway Service* follows all the Oauth2 flow to get an acess token and forwads the acess token to the *Product Service*.  
*Product Service* is configured as a resource server, so its job is to use the acess token forwarded from *Gateway Service* to let acess to the user.  
>NOTE: Please provide okta.oauth2.client-id and okta.oauth2.secret as properties and its values for the Oauth2 flow to both *Gateway Service* and *Product Service*.
