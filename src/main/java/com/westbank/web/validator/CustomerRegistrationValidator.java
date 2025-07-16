package com.westbank.web.validator;

import com.westbank.web.form.CustomerRegistrationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerRegistrationValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerRegistrationForm.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        CustomerRegistrationForm form = (CustomerRegistrationForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.required", new String[]{"Title"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.required", new String[]{"First name"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.required", new String[]{"Last name"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "error.required", new String[]{"Date of Birth"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "occupation", "error.required", new String[]{"Occupation"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "income", "error.required", new String[]{"Income"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lengthOfService", "error.required", new String[]{"Length of Service"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "error.required", new String[]{"Street"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.required", new String[]{"City"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipcode", "error.required", new String[]{"Zipcode"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.required", new String[]{"Country"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.required", new String[]{"Phone"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.required", new String[]{"Email"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPin", "error.required", new String[]{"PIN"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPinAgain", "error.required", new String[]{"PIN again"});
        if (form.getNewPin() != null && !form.getNewPin().equals(form.getNewPinAgain())) {
            errors.rejectValue("newPin", "registration.newpin.not.matched", new String[]{"PIN"}, null);
        }
        // Optionally: add email format validation here
    }
} 