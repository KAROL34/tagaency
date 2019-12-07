package com.karol.travelagency.validator;


import com.karol.travelagency.dto.TripPurchaseDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TripPurchaseValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TripPurchaseDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TripPurchaseDto trip = (TripPurchaseDto) target;
        Integer adultsQuantity = Integer.valueOf(trip.getAdultsQuantity());
        Integer adultsAvailable = Integer.valueOf(trip.getAdultsAvailable());
        Integer childrenQuantity = Integer.valueOf(trip.getChildrenQuantity());
        Integer childrenAvailable = Integer.valueOf(trip.getChildrenAvailable());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clientFirstName", "NotEmpty", "Pole wymagane!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clientLastName", "NotEmpty", "Pole wymagane!");

//        if (trip.getChildrenQuantity() == null || childrenQuantity < 0) {
//            errors.rejectValue("childrenQuantity", "value.positive", "Pole nie może być wartością ujemną.");
//        }
        if (!trip.getAdultsQuantity().matches("^\\d+$")) {
            errors.rejectValue("adultsQuantity", "not.int");
        }
        if (!trip.getChildrenQuantity().matches("^\\d+$")) {
            errors.rejectValue("childrenQuantity", "not.int");
        }
        if (adultsQuantity > adultsAvailable) {
            errors.rejectValue("adultsQuantity", "not.enough.available");
        }
        if (childrenQuantity > childrenAvailable) {
            errors.rejectValue("childrenQuantity", "not.enough.available");
        }
    }
}
