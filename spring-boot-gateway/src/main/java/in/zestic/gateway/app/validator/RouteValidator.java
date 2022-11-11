package in.zestic.gateway.app.validator;

import in.zestic.gateway.app.validator.impl.RouteValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RouteValidatorImpl.class)
public @interface RouteValidator {

    String message() default "Invalid route object";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
