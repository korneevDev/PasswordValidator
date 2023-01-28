package PasswordValidator;

import PasswordValidator.ValidationResult.ValidationResult;

public class ValidatorChain implements Validator {

    final private Validator current;
    final private Validator next;

    public ValidatorChain(Validator current, Validator next){
        this.current = current;
        this.next = next;
    }

    @Override
    public ValidationResult isValid(String string){
        ValidationResult result = current.isValid(string);

        if(result.getStatus())
            result = next.isValid(string);

        return result;
    }
}
