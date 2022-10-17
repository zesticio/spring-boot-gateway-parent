package com.zestic.gateway.app.controller;

import com.zestic.gateway.app.document.Route;
import com.zestic.gateway.app.service.RouteService;
import com.zestic.gateway.app.validator.RouteValidator;
import com.zestic.springboot.common.entity.Result;
import com.zestic.springboot.common.util.HTTPErrorCodes;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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
        Result<String> response = new Result(HTTPErrorCodes.SUCCESS.getCode(), HTTPErrorCodes.SUCCESS.getMessage());
        response.setData(principal.getName());
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
