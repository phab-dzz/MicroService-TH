package iuh.fit.edu.vn.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("product-service", r -> r.path("/api/products/**")
						.uri("http://product-service:8081"))
				.route("order-service", r -> r.path("/api/orders/**")
						.uri("http://order-service:8082"))
				.route("customer-service", r -> r.path("/api/customers/**")
						.uri("http://customer-service:8083"))
				.build();
	}

}
