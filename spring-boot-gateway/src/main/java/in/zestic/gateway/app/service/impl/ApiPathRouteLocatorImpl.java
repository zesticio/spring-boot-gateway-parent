package in.zestic.gateway.app.service.impl;

import in.zestic.gateway.app.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.BooleanSpec;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class ApiPathRouteLocatorImpl implements RouteLocator {

    private final RouteService service;
    private final RouteLocatorBuilder builder;

    @Override
    public Flux<Route> getRoutes() {
        RouteLocatorBuilder.Builder routesBuilder = builder.routes();
        return service.list()
                .map(apiRoute -> routesBuilder.route(String.valueOf(apiRoute.getId()), predicateSpec -> setPredicateSpec(apiRoute, predicateSpec)))
                .collectList()
                .flatMapMany(builders -> routesBuilder.build().getRoutes());
    }

    private Buildable<Route> setPredicateSpec(in.zestic.gateway.app.document.Route route, PredicateSpec predicateSpec) {
        BooleanSpec booleanSpec = predicateSpec.path(route.getPath());
        if (!StringUtils.isEmpty(route.getMethod())) {
            booleanSpec.and().method(route.getMethod());
        }
        return booleanSpec.uri(route.getUri());
    }
}
