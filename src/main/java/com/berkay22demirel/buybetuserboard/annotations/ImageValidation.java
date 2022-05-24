package com.berkay22demirel.buybetuserboard.annotations;

import com.berkay22demirel.buybetuserboard.validation.ImageValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ImageValidator.class})
public @interface ImageValidation {

    String message() default "{buybet.validation.constraints.image.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
