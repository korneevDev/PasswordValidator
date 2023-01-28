package PasswordValidator.ValidatorCondition;

public class ValidatorIsLetterUpperCaseInclude implements ValidationCondition {
    @Override
    public boolean checkCondition(String string){
        return string.matches(".*[A-Z].*");
    }

    @Override
    public String getDescription(){
        return "Is letter on upper case included in password?";
    }
}
