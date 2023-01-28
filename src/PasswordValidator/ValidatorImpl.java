package PasswordValidator;

import PasswordValidator.ValidationResult.ValidationResult;
import PasswordValidator.ValidationResult.ValidationResultError;
import PasswordValidator.ValidationResult.ValidationResultSuccessful;
import PasswordValidator.ValidatorCondition.ValidationCondition;

public class ValidatorImpl implements Validator {
    final private ValidationCondition condition;

    public ValidatorImpl(ValidationCondition condition){
        this.condition = condition;
    }

    @Override
    public ValidationResult isValid(String string){
        return condition.checkCondition(string) ?
                new ValidationResultSuccessful():
                new ValidationResultError(condition.getDescription());
    }
}
