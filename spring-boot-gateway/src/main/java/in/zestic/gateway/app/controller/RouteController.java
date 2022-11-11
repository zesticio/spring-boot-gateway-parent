package in.zestic.gateway.app.controller;

import in.zestic.gateway.app.base.Result;
import in.zestic.gateway.app.document.Route;
import in.zestic.gateway.app.exception.GatewayError;
import in.zestic.gateway.app.service.RouteService;
import in.zestic.gateway.app.validator.RouteValidator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/routes", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @SneakyThrows
    @PostMapping(path = "")
    @ApiOperation(value = "Create a new route", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a new donor"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<Result> create(@RouteValidator @RequestBody Route route) {
        Result<Void> response = new Result(GatewayError.ROUTE_ADDED);
        service.create(route);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @ApiOperation(value = "List all routes", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a new donor"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    @GetMapping(path = "")
    public ResponseEntity<Result> findAll() {
        Result<List<Route>> response = new Result(GatewayError.SUCCESS);
        response.setData(service.list().collectList().block());
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @ApiOperation(value = "Find a route by id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a new donor"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<Result> findById(@PathVariable(value = "id") String id) {
        Result<Route> response = new Result(GatewayError.SUCCESS);
        response.setData(service.findById(id).block());
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
