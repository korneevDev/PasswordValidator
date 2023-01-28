package PasswordValidator.ValidationResult;

public class ValidationResultSuccessful implements ValidationResult {
    @Override
    public boolean getStatus(){
        return true;
    }

    @Override
    public String toString(){
        return "Correct password";
    }
}
