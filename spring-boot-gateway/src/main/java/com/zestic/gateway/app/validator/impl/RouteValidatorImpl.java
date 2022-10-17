package com.zestic.gateway.app.validator.impl;

import com.zestic.gateway.app.document.Route;
import com.zestic.gateway.app.validator.RouteValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RouteValidatorImpl implements ConstraintValidator<RouteValidator, Route> {

    @Override
    public boolean isValid(Route route, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }
}
