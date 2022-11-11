package in.zestic.gateway.app.controller;

import in.zestic.gateway.app.base.Result;
import in.zestic.gateway.app.exception.GatewayError;
import in.zestic.gateway.app.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Validated
@RestController
@RequestMapping(value = "/test", produces = {MediaType.APPLICATION_JSON_VALUE})
public class Test {

    private final RouteService service;

    public Test(RouteService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public ResponseEntity<Result> find(Principal principal) {
        Result<String> response = new Result(GatewayError.ROUTE_ADDED);
        response.setData(principal.getName());
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
