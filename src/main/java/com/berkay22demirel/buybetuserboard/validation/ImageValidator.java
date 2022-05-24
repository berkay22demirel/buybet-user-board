package com.berkay22demirel.buybetuserboard.validation;

import com.berkay22demirel.buybetuserboard.annotations.ImageValidation;
import org.apache.tika.Tika;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Base64;

public class ImageValidator implements ConstraintValidator<ImageValidation, String> {

    @Override
    public boolean isValid(String image, ConstraintValidatorContext constraintValidatorContext) {
        if (image == null) {
            return true;
        }
        Tika tika = new Tika();
        String imageType = tika.detect(Base64.getDecoder().decode(image));
        if (imageType.equalsIgnoreCase("image/png")
                || imageType.equalsIgnoreCase("image/jpg")
                || imageType.equalsIgnoreCase("image/jpeg")) {
            return true;
        }
        return false;
    }
}
