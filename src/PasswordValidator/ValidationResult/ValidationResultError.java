package PasswordValidator.ValidationResult;

public class ValidationResultError implements ValidationResult {
    private final String status;
    public ValidationResultError(String status){
        this.status = status;
    }

    @Override
    public boolean getStatus(){
        return false;
    }

    @Override
    public String toString(){
        return status;
    }
}
