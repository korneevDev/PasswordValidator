package PasswordValidator;

import PasswordValidator.ValidationResult.ValidationResult;

public interface Validator {
    ValidationResult isValid(String string);
}
