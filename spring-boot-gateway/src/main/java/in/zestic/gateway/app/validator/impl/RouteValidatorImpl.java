package in.zestic.gateway.app.validator.impl;

import in.zestic.gateway.app.document.Route;
import in.zestic.gateway.app.validator.RouteValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RouteValidatorImpl implements ConstraintValidator<RouteValidator, Route> {

    @Override
    public boolean isValid(Route route, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }
}
