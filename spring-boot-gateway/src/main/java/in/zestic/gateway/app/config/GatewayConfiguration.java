package in.zestic.gateway.app.config;

import in.zestic.gateway.app.service.RouteService;
import in.zestic.gateway.app.service.impl.ApiPathRouteLocatorImpl;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteService service, RouteLocatorBuilder builder) {
        return new ApiPathRouteLocatorImpl(service, builder);
    }
}
