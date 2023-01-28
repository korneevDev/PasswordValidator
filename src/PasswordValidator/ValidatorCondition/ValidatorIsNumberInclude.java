package PasswordValidator.ValidatorCondition;

public class ValidatorIsNumberInclude implements ValidationCondition {
    @Override
    public boolean checkCondition(String string){
        return string.matches(".*\\d.*");
    }

    @Override
    public String getDescription(){
        return "Is number included in password?";
    }
}
