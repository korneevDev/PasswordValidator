package PasswordValidator.ValidatorCondition;

public class ValidatorIsLetterLowerCaseInclude implements ValidationCondition {
    @Override
    public boolean checkCondition(String string){
        return string.matches(".*[a-z].*");
    }

    @Override
    public String getDescription(){
        return "Is letter on lower case included in password?";
    }
}
