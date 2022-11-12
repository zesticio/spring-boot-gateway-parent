package in.zestic.gateway.app.controller;

import in.zestic.gateway.app.base.Result;
import in.zestic.gateway.app.document.Route;
import in.zestic.gateway.app.exception.GatewayError;
import in.zestic.gateway.app.service.RouteService;
import in.zestic.gateway.app.validator.RouteValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping(value = "/routes", produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "Test APIs", description = "Test APIs for demo purpose")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @SneakyThrows
    @PostMapping(path = "")
    @Operation(description = "Get a test model demo",
            parameters = {
                    @Parameter(name = "name", in = ParameterIn.QUERY, required = true, description = "name parameter")
            })
    public ResponseEntity<Result> create(@RouteValidator @RequestBody Route route) {
        Result<Void> response = new Result(GatewayError.ROUTE_ADDED);
        service.create(route);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @GetMapping(path = "")
    public ResponseEntity<Result> findAll() {
        Result<Flux<Route>> response = new Result(GatewayError.SUCCESS);
        response.setData(service.list());
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Result> findById(@PathVariable(value = "id") String id) {
        Result<Mono<Route>> response = new Result(GatewayError.SUCCESS);
        response.setData(service.findById(id));
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
